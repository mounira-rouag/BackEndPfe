package com.example.Project.Controller;

import com.example.Project.Models.Sites;
import com.example.Project.Models.User;
import com.example.Project.Repositories.UserInterface;
import com.example.Project.Request.ChangePasswordRequest;
import com.example.Project.Request.MessageResponse;
import com.example.Project.Request.ResetPasswordRequest;
import com.example.Project.Services.ResetTokenServiceImpl;
import com.example.Project.Services.SendingEmailService;
import com.example.Project.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();
    private final UserServiceImpl userServiceImp;
    private final UserInterface userRepository;
    private final SendingEmailService senderEmailService;
    private final ResetTokenServiceImpl resetTokenServiceImpl;

    public UserController(UserServiceImpl userServiceImp, UserInterface userRepository, UserInterface userRepository1, SendingEmailService senderEmailService, ResetTokenServiceImpl resetTokenServiceImpl) {
        this.userServiceImp = userServiceImp;

        this.userRepository = userRepository1;
        this.senderEmailService = senderEmailService;
        this.resetTokenServiceImpl = resetTokenServiceImpl;
    }
    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        try {
            String message = userServiceImp.changePassword(request, connectedUser);
            return ResponseEntity.ok().body(new MessageResponse(message));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Passwords do not match"));
        }
    }


    @PostMapping("/findemail")
    public ResponseEntity<?> verifyEmail(@RequestParam String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.ok().body(new MessageResponse("email exist "));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("email does not exist "));
        }
    }

    @GetMapping(value = "/emails")
    public ResponseEntity<List<String>> getAllEmails() {
        List<String> emailList = userServiceImp.findAllEmails();
        if (emailList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emailList);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody User updatedUser) {

            userServiceImp.updateUser(userId, updatedUser);
            return ResponseEntity.ok("User updated successfully");

    }

    @GetMapping("/find-all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam String email) {


        if ((userRepository.findByEmail(email).isPresent())) {
            Optional<User> user=userRepository.findByEmail(email);
            String resetToken = generateResetToken(18);
            userServiceImp.createPasswordResetToken(user.get(), resetToken);
            senderEmailService.sendPasswordResetEmail(user.get().getEmail(), resetToken);
            return ResponseEntity.ok().body("an email was sent check you email");
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Email do not exist ,try again"));
        }
    }


    @PostMapping("/reset-password/confirm")
    public ResponseEntity<?> confirmResetPassword(@RequestParam String token,
                                                  @RequestParam String newPassword,
                                                  @RequestParam String ConfirmPassword) {

        if (!newPassword.equals(ConfirmPassword)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Passwords do not match."));
        }

        boolean success = resetTokenServiceImpl.resetPassword(token, newPassword);
        if (success) {
            return ResponseEntity.ok().body(new MessageResponse("Password reset successfully!"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Invalid or expired token."));
        }
    }

    private String generateResetToken(int length) {
        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
