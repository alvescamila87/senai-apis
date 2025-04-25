package com.senai.userapiv2.dtos;

import com.senai.userapiv2.models.ProdutoModel;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoListaDTO {

    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidadeEstoque;

    public static ProdutoListaDTO of(ProdutoModel model) {
        return ProdutoListaDTO
                .builder()
                .id(model.getId())
                .nome(model.getNome())
                .preco(model.getPreco())
                .quantidadeEstoque(model.getQuantidadeEstoque())
                .build();
    }
}
