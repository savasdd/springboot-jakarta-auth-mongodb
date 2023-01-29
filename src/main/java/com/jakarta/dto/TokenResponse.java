package com.jakarta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponse {

    private String name;
    private String surname;
    private String username;
    private String token;
    private UserRole role;
}
