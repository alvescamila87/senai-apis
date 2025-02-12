package org.controller;

import org.dto.CalculadoraDTO;
import org.dto.ResultadoDTO;
import org.service.CalculadoraService;

public class CalculadoraController {
    public static void main(String[] args) {

        //int numero1 = 5;
        //int numero2 = 7;

        CalculadoraDTO calculadoraDTO =  new CalculadoraDTO();
        calculadoraDTO.setNum1(5);
        calculadoraDTO.setNum2(2);

        CalculadoraService service = new CalculadoraService();
        service.somar(calculadoraDTO);

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.getResultado();

        System.out.println("Resultado: " + resultadoDTO.getResultado());
    }
}