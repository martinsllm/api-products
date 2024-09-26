package com.example.api_products.domain;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UsuarioRole {

    ADMIN("admin"),

    USER("user");

    private String role;
    
}
