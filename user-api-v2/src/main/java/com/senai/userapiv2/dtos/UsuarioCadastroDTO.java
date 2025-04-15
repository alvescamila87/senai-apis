package com.senai.userapiv2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCadastroDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
}
