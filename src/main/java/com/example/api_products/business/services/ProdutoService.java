package com.example.api_products.business.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.api_products.business.converter.ProdutoConverter;
import com.example.api_products.domain.dto.ProdutoDTO;
import com.example.api_products.domain.entities.ProdutoEntity;
import com.example.api_products.infraestructure.exceptions.BusinessException;
import com.example.api_products.infraestructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoConverter produtoConverter;

    private ProdutoEntity salvar(ProdutoEntity produto) {
        return produtoRepository.saveAndFlush(produto);
    }

    public ProdutoDTO salvarProdutoDTO(ProdutoDTO produto) {
        try {
            ProdutoEntity produtoEntity = produtoConverter.paraProdutoEntity(produto);
            return produtoConverter.paraProdutoDTO(salvar(produtoEntity));
        } catch (BusinessException e) {
            throw new BusinessException("Erro ao salvar produto", e);
        }
    }

    public List<ProdutoDTO> buscarTodosProdutos() {
        try {
            List<ProdutoEntity> produtos = produtoRepository.findAll();
            return produtoConverter.paraListaProdutosDTO(produtos);
        } catch (Exception e) {
            throw new BusinessException("Erro ao salvar produto", e);
        }
    }
    
}
