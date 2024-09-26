package com.example.api_products.business.converter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.api_products.domain.dto.ProdutoDTO;
import com.example.api_products.domain.entities.ProdutoEntity;

@Component
public class ProdutoConverter {

    public ProdutoEntity paraProdutoEntity(ProdutoDTO produto) {
        return ProdutoEntity.builder()
            .nome(produto.getNome())
            .descricao(produto.getDescricao())
            .preco(produto.getPreco())
            .dataInclusao(LocalDateTime.now())
            .build();
    }

    public ProdutoDTO paraProdutoDTO(ProdutoEntity produto) {
        return ProdutoDTO.builder()
            .nome(produto.getNome())
            .descricao(produto.getDescricao())
            .preco(produto.getPreco())
            .build();
    }

    public List<ProdutoDTO> paraListaProdutosDTO(List<ProdutoEntity> produtos) {
        return produtos.stream().map(this::paraProdutoDTO).toList();
    }
    
}
