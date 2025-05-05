package com.senai.usuario_database_oficial.dtos;

import lombok.Data;

@Data
public class RespostaDto {
    private Long id;
    private String nome;
    private String login;
    private String senha;
}

