package com.example.api_products.domain.dto;

import com.example.api_products.domain.UsuarioRole;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
    
    private String login;

    private String password;

    private UsuarioRole role;
    
}