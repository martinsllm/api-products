package com.example.api_products.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_products.domain.entities.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
    
    ProdutoEntity findByNome(String nome);
}
