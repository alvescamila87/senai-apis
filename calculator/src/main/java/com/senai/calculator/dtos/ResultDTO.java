package com.senai.calculator.dtos;

import lombok.Data;

@Data
public class ResultDTO {

    private Integer numero1;
    private Integer numero2;
    private String operacao;
    private Integer resultado;
    private String mensagem;

}
