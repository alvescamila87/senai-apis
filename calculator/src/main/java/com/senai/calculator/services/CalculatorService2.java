package com.senai.calculator.services;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService2 {

    public ResultDTO executaOperacao(CalculatorDTO inputData) {
        if (inputData.getOperacao().equalsIgnoreCase("adicionar")) {
            return executaSoma(inputData);
        } else if (inputData.getOperacao().equalsIgnoreCase("substrair")) {
            return executaSubtracao(inputData);
        } else if (inputData.getOperacao().equalsIgnoreCase("dividir")) {
            return executaDivisao(inputData);
        } else if (inputData.getOperacao().equalsIgnoreCase("multiplicar")) {
            return executaMultiplicacao(inputData);
        } else if (inputData.getOperacao().equalsIgnoreCase("potencia")) {
            return executaPotenciacao(inputData);
        }
        return executaModulo(inputData);
    }

    protected ResultDTO executaSoma(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setOperacao(inputData.getOperacao());
        resultDTO.setNumero1(inputData.getNumero1());
        resultDTO.setNumero2(inputData.getNumero2());
        resultDTO.setResultado(inputData.getNumero1() + inputData.getNumero2());

        return resultDTO;
    }

    protected ResultDTO executaSubtracao(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setOperacao(resultDTO.getOperacao());
        resultDTO.setNumero1(resultDTO.getNumero1());
        resultDTO.setNumero2(resultDTO.getNumero2());
        resultDTO.setResultado(inputData.getNumero1() - inputData.getNumero2());

        return resultDTO;
    }

    protected ResultDTO executaDivisao(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();

        try {
            resultDTO.setOperacao(resultDTO.getOperacao());
            resultDTO.setNumero1(inputData.getNumero1());
            resultDTO.setNumero2(inputData.getNumero2());
            resultDTO.setResultado(inputData.getNumero1() / inputData.getNumero2());
        } catch (ArithmeticException e) {
            resultDTO.setMensagem("Divisão por zero.");
        }

        return resultDTO;
    }

    protected ResultDTO executaMultiplicacao(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setOperacao(resultDTO.getOperacao());
        resultDTO.setNumero1(inputData.getNumero1());
        resultDTO.setNumero2(inputData.getNumero1());
        resultDTO.setResultado(inputData.getNumero1() * inputData.getNumero2());

        return resultDTO;
    }

    protected ResultDTO executaPotenciacao(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setOperacao(resultDTO.getOperacao());
        resultDTO.setNumero1(inputData.getNumero1());
        resultDTO.setNumero2(inputData.getNumero2());
        resultDTO.setResultado((int) Math.pow(inputData.getNumero1(), inputData.getNumero2()));

        return resultDTO;
    }

    protected ResultDTO executaModulo(CalculatorDTO inputData){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setOperacao(resultDTO.getOperacao());
        resultDTO.setNumero1(inputData.getNumero1());
        resultDTO.setNumero2(inputData.getNumero2());
        resultDTO.setResultado(Math.abs(inputData.getNumero1()) % inputData.getNumero2());

        return resultDTO;
    }
}


