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
public class ClienteRequestDTO {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;

    public static ClienteRequestDTO of(ClienteModel model) {
        ClienteRequestDTO dto = new ClienteRequestDTO();

        dto.setNome(model.getNome());
        dto.setCpf(model.getCpf());
        dto.setDataNascimento(model.getDataNascimento());
        dto.setTelefone(model.getTelefone());
        dto.setEmail(model.getEmail());

        return dto;
    }
}
