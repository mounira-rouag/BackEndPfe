package com.example.Project.Controller;

import com.example.Project.Models.ERole;
import com.example.Project.Models.Role;
import com.example.Project.Models.User;
import com.example.Project.Repositories.RoleRepository;
import com.example.Project.Repositories.UserInterface;
import com.example.Project.Request.LoginRequest;
import com.example.Project.Request.MessageResponse;
import com.example.Project.Request.SignupRequest;
import com.example.Project.Response.JwtResponse;
import com.example.Project.Services.SendingEmailService;
import com.example.Project.Services.UserDetailsImpl;
import com.example.Project.Services.UserServiceImpl;
import com.example.Project.jwt.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    SendingEmailService sendingEmailService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserInterface userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired

    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private final UserServiceImpl userServiceImpl;
    private final SendingEmailService senderEmailService;

    public AuthController(UserServiceImpl userServiceImpl, SendingEmailService senderEmailService) {
        this.userServiceImpl = userServiceImpl;
        this.senderEmailService = senderEmailService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles)); // Here, you are returning the roles as obtained from UserDetailsImpl
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody @NotNull SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        // Perform password validation
/**
        if (!userServiceImpl.validateEmailForDomain(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("domaine name not supported "));
        }*/

        if (!userServiceImpl.validatePassword(signUpRequest.getPassword())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Password does not meet security requirements"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),

                signUpRequest.getLastname(),
                signUpRequest.getFirstname(),
                signUpRequest.getSite()
        );

        List<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        user.setProfile("Admin");
                        break;
                    case "rc":
                        Role modRole = roleRepository.findByName(ERole.ROLE_RC)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        user.setProfile("RC");
                        break;
                    case "RC+":
                        Role rcRole = roleRepository.findByName(ERole.ROLE_RCPlus)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(rcRole);
                        user.setProfile("RC+");
                        break;
                    case "quality":
                        Role qaRole = roleRepository.findByName(ERole.ROLE_QUALITE_FILIALE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(qaRole);
                        user.setProfile("quality");
                        break;

                    case "RS":
                        Role rsRole = roleRepository.findByName(ERole.ROLE_RS)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(rsRole);
                        user.setProfile("RS");
                        break;
                    case "rspouvoir":
                        Role rspouvoirRole = roleRepository.findByName(ERole.ROLE_RSPOUVOIR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(rspouvoirRole);
                        user.setProfile("rspouvoir");
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);

                }
            });
        }
        user.setRoles(roles);
        userServiceImpl.saveUser(user);



/**
        String to = signUpRequest.getEmail();
        String subject = "Welcome to BaseEcu Platform";
        String body = "Dear " + signUpRequest.getUsername() + ",\n\n"
                + "Thank you for signing up to our platform. We're excited to have you on board!\n\n"
                + "To complete your registration, please click on the following link to set your password:\n"
                + "http://localhost:4200/email-verifiy" ;
        sendingEmailService.sendEmail(to, subject, body);*/

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // Invalidate the current session
        SecurityContextHolder.clearContext();

        // Optionally, perform any additional logout logic such as clearing authentication tokens or session data

        // Return a response indicating successful logout
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("user loged out "));

    }

}
