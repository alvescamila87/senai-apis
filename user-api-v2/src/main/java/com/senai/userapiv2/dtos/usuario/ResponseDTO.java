package com.senai.userapiv2.dtos.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    private String nome;
    private String login;
    private String senha;
}
