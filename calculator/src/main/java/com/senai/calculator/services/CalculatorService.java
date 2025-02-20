package com.senai.calculator.services;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public ResultDTO executaSoma(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setNumero1(inputData.getNumero1());
        resultDTO.setNumero2(inputData.getNumero2());
        resultDTO.setResultado(inputData.getNumero1() + inputData.getNumero2());

        return resultDTO;
    }

    public ResultDTO executaSubtracao(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setNumero1(resultDTO.getNumero1());
        resultDTO.setNumero2(resultDTO.getNumero2());
        resultDTO.setResultado(inputData.getNumero1() - inputData.getNumero2());

        return resultDTO;
    }

    public ResultDTO executaDivisao(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();

        try {
            resultDTO.setNumero1(inputData.getNumero1());
            resultDTO.setNumero2(inputData.getNumero2());
            resultDTO.setResultado(inputData.getNumero1() / inputData.getNumero2());
        } catch (ArithmeticException e) {
            resultDTO.setMensagem("Divisão por zero.");
        }

        return resultDTO;
    }

    public ResultDTO executaMultiplicacao(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setNumero1(inputData.getNumero1());
        resultDTO.setNumero2(inputData.getNumero1());
        resultDTO.setResultado(inputData.getNumero1() * inputData.getNumero2());

        return resultDTO;
    }

    public ResultDTO executaPotenciacao(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setNumero1(inputData.getNumero1());
        resultDTO.setNumero2(inputData.getNumero2());
        resultDTO.setResultado((int) Math.pow(inputData.getNumero1(), inputData.getNumero2()));

        return resultDTO;
    }

    public ResultDTO executaModulo(CalculatorDTO inputData){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setNumero1(inputData.getNumero1());
        resultDTO.setNumero2(inputData.getNumero2());
        resultDTO.setResultado(Math.abs(inputData.getNumero1()) % inputData.getNumero2());

        return resultDTO;
    }
}


