package com.senai.userapiv2.dtos;

import com.senai.userapiv2.models.ProdutoModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidadeEstoque;

    public static ProdutoResponseDTO of(ProdutoModel model) {
        return ProdutoResponseDTO
                .builder()
                .id(model.getId())
                .nome(model.getNome())
                .descricao(model.getDescricao())
                .preco(model.getPreco())
                .quantidadeEstoque(model.getQuantidadeEstoque())
                .build();
    }
}
