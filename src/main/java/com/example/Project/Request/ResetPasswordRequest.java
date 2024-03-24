package com.example.Project.Request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
public class ResetPasswordRequest {
    private String email;
}
