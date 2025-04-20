package com.senai.userapiv2.dtos;

import com.senai.userapiv2.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCadastroDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;

    public UsuarioCadastroDTO(Long id) {
        this.id = id;
    }

    public UsuarioCadastroDTO of(UsuarioModel model) {
        UsuarioCadastroDTO usuarioCadastroDTO = new UsuarioCadastroDTO();
        usuarioCadastroDTO.setId(model.getId());
        usuarioCadastroDTO.setNome(model.getNome());
        usuarioCadastroDTO.setLogin(model.getLogin());
        usuarioCadastroDTO.setSenha(model.getSenha());

        return usuarioCadastroDTO;
    }
}
