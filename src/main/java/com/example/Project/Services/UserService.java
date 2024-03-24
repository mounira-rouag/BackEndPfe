package com.example.Project.Services;

import com.example.Project.Models.User;
import com.example.Project.Repositories.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User saveUser(User user);
    public boolean validateEmailForDomain(String email);
    public boolean existsByEmail(String email);
    public boolean validatePassword(String password);
}
