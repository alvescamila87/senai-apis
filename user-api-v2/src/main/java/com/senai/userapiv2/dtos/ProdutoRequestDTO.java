package com.senai.userapiv2.dtos;

import com.senai.userapiv2.models.ProdutoModel;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProdutoRequestDTO {

    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidadeEstoque;

    public static ProdutoRequestDTO of(ProdutoModel model) {
        return ProdutoRequestDTO
                .builder()
                .nome(model.getNome())
                .preco(model.getPreco())
                .quantidadeEstoque(model.getQuantidadeEstoque())
                .build();
    }
}
