package com.senai.user_database.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
}
