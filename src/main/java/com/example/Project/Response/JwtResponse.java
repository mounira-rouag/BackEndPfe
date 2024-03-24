package com.example.Project.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    @JsonProperty("access_token")
    private String Token;
    private String type = "Bearer";

    private int id;
    private String username;
    private String email;
    private List<String> roles;


    public JwtResponse(String jwt, int id, String username, String email, List<String> roles) {
        this.Token=jwt;
        this.id=id;
        this.email=email;
        this.username=username;
        this.roles=roles;
    }
}
