package com.senai.userapiv2.dtos.usuario;

import com.senai.userapiv2.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    //private String senha;

    public UsuarioDTO(Long id) {
        this.id = id;
    }

    public static UsuarioDTO of(UsuarioModel model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(model.getId());
        usuarioDTO.setNome(model.getNome());
        usuarioDTO.setLogin(model.getLogin());

        return usuarioDTO;
    }
}
