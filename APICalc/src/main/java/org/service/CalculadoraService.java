package org.service;

import org.dto.CalculadoraDTO;
import org.dto.ResultadoDTO;

public class CalculadoraService {

    // métodos
    public ResultadoDTO somar(CalculadoraDTO calcDTO){
        int resultado = calcDTO.getNum1() + calcDTO.getNum2();
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setResultado(resultado);
        return resultadoDTO;
    }

}
