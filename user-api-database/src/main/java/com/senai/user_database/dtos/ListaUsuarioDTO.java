package com.senai.user_database.dtos;

import com.senai.user_database.models.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter

public class ListaUsuarioDTO {

    private Long id;
    private String nome;
    private String login;

    public ListaUsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
    }

    public static List<ListaUsuarioDTO> of(List<Usuario> usuarios) {
        return usuarios.stream().map(ListaUsuarioDTO::new).collect(Collectors.toList());
    }
}
