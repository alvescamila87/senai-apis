package com.senai.calculator.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalculatorDTO {

    private Integer numero1;
    private Integer numero2;
    private String operacao;
}
