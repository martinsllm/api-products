package com.example.api_products.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.api_products.domain.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
    UserDetails findByLogin(String login);

    Boolean existsByLogin(String login);
}
