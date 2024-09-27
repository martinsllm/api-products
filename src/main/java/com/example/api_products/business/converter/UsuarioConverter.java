package com.example.api_products.business.converter;

import org.springframework.stereotype.Component;
import com.example.api_products.domain.dto.UsuarioDTO;
import com.example.api_products.domain.entities.UsuarioEntity;

@Component
public class UsuarioConverter {

    public UsuarioEntity paraUsuarioEntity(UsuarioDTO usuario) {
        return UsuarioEntity.builder()
            .login(usuario.getLogin())
            .password(usuario.getPassword())
            .role(usuario.getRole())
            .build();
    }

    public UsuarioDTO paraUsuarioDTO(UsuarioEntity usuario) {
        return UsuarioDTO.builder()
            .login(usuario.getLogin())
            .password(usuario.getPassword())
            .role(usuario.getRole())
            .build();
    }
    
}
