package com.example.api_products.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api_products.business.services.ProdutoService;
import com.example.api_products.domain.dto.ProdutoDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping()
    public ResponseEntity<ProdutoDTO> salvaProduto(@RequestBody ProdutoDTO produto) {
        return ResponseEntity.ok(produtoService.salvarProdutoDTO(produto));
    }
    
}
