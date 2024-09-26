package com.example.api_products_mysql.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_products_mysql.infraestructure.entities.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String>{
    
}
