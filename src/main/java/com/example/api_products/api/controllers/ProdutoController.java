package com.example.api_products.api.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.api_products.business.services.ProdutoService;
import com.example.api_products.domain.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<List<ProdutoDTO>> listaTodosProdutos() {
        return ResponseEntity.ok(produtoService.buscarTodosProdutos());
    }

    @GetMapping("/nome")
    public ResponseEntity<ProdutoDTO> listaProduto(@RequestParam(value = "nome") String nome) {
        return ResponseEntity.ok(produtoService.buscarProduto(nome));
    }

    @PostMapping()
    public ResponseEntity<ProdutoDTO> salvaProduto(@RequestBody ProdutoDTO produto) {
        return ResponseEntity.ok(produtoService.salvarProdutoDTO(produto));
    }
    
}
