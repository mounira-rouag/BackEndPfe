package com.example.Project.Request;

import com.example.Project.Models.Role;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String username;
    private String firstname;
    private String lastname;
    private int site;
    private String email;
    private String password;
    @Getter
    private List<String> roles;

}
