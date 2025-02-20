package com.senai.calculator.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDTO {

    private Integer numero1;
    private Integer numero2;
    private String operacao;
    private Integer resultado;
    private String mensagem;

}
