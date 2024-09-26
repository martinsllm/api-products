package com.example.api_products.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {

    private String nome;

    private String descricao;

    private Long preco;

}
