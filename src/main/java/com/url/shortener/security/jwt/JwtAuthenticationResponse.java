package com.url.shortener.security.jwt;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
    //This class represents the authentication response
    private String token;
}
