package com.example.api_products.business.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.api_products.business.converter.UsuarioConverter;
import com.example.api_products.domain.dto.UsuarioDTO;
import com.example.api_products.domain.entities.UsuarioEntity;
import com.example.api_products.infraestructure.exceptions.BusinessException;
import com.example.api_products.infraestructure.exceptions.ConflictException;
import com.example.api_products.infraestructure.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;


    public UsuarioEntity salvaUsuario(UsuarioEntity usuario) {
        try {
            return usuarioRepository.saveAndFlush(usuario);
        } catch (Exception e) {
            throw new BusinessException("Erro ao cadastrar usuario ", e);
        }
    }
    
    public UsuarioDTO registraUsuario(UsuarioDTO usuarioDTO) {
        try {
            Boolean usuarioExiste = usuarioRepository.existsByLogin(usuarioDTO.getLogin());
            if(usuarioExiste.equals(true)){
                throw new ConflictException("Já existe usuário cadastrado com o login informado!");
            }

            String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDTO.getPassword());
            usuarioDTO.setPassword(encryptedPassword);
            
            UsuarioEntity usuario = salvaUsuario(usuarioConverter.paraUsuarioEntity(usuarioDTO));
            return usuarioConverter.paraUsuarioDTO(usuario);
        } catch(ConflictException e) {
            throw new ConflictException(e.getMessage());
        } catch(Exception e) {
            throw new BusinessException("Erro ao cadastrar usuario:", e);
        }
    }
    
}
