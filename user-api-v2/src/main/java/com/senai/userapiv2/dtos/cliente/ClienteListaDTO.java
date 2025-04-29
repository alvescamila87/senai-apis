package com.senai.userapiv2.dtos.cliente;

import com.senai.userapiv2.models.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteListaDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private Boolean ativo;

    public static ClienteListaDTO of(ClienteModel model) {
        ClienteListaDTO dto = new ClienteListaDTO();

        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setDataNascimento(model.getDataNascimento());
        dto.setEmail(model.getEmail());
        dto.setAtivo(model.getAtivo());

        return dto;
    }
}
