package com.example.Project.Services;

import com.example.Project.Models.PasswordResetToken;
import com.example.Project.Models.User;
import com.example.Project.Repositories.TokenRepository;
import com.example.Project.Repositories.UserInterface;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl {
    private final TokenRepository tokenRepo;
private final UserInterface userRepo;
    private final PasswordEncoder passwordEncoder;
    public ResetTokenServiceImpl(TokenRepository tokenRepo, UserInterface userRepo, PasswordEncoder passwordEncoder) {
        this.tokenRepo = tokenRepo;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean resetPassword(String token, String newPassword) {
        PasswordResetToken passwordResetToken = tokenRepo.findByToken(token);
        if (passwordResetToken == null ) {
            return false; // Token is invalid or expired
        }

        User user = passwordResetToken.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));

        System.out.println("new password"+user);

        userRepo.save(user);

        tokenRepo.delete(passwordResetToken);
        return true;
    }
}
