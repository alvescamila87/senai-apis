package com.senai.userapiv2.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoListaDTO {

    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidadeEstoque;
}
