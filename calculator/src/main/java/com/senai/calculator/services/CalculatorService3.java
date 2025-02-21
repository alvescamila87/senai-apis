package com.senai.calculator.services;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService3 {

    public ResultDTO executaOperacao(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();

        switch (inputData.getOperacao()){
            case "+":
                resultDTO = executaSoma(inputData);
                break;
            case "-":
                resultDTO = executaSubtracao(inputData);
                break;
            case "*":
                resultDTO = executaMultiplicacao(inputData);
                break;
            case "/":
                resultDTO = executaDivisao(inputData);
                break;
            case "^":
                resultDTO = executaPotenciacao(inputData);
                break;
            case "%":
                resultDTO = executaModulo(inputData);
                break;

            default:
                System.out.println("[ERRO] Operação inválida. Tente novamente...");
        }

        return resultDTO;
    }

    protected ResultDTO executaSoma(CalculatorDTO inputData) {
        ResultDTO resultDTO = getInputDataAndSetResult(inputData);
        resultDTO.setResultado(inputData.getNumero1() + inputData.getNumero2());

        return resultDTO;
    }

    protected ResultDTO executaSubtracao(CalculatorDTO inputData) {
        ResultDTO resultDTO = getInputData(inputData);
        resultDTO.setResultado(inputData.getNumero1() - inputData.getNumero2());

        return resultDTO;
    }

    private static ResultDTO getInputData(CalculatorDTO inputData) {
        ResultDTO resultDTO = getInputDataAndSetResult(inputData);
        return resultDTO;
    }

    protected ResultDTO executaDivisao(CalculatorDTO inputData) {
        ResultDTO resultDTO = getInputDataAndSetResult(inputData);
        try {
            resultDTO.setResultado(inputData.getNumero1() / inputData.getNumero2());
        } catch (ArithmeticException e) {
            resultDTO.setMensagem("Divisão por zero.");
        }
        return resultDTO;
    }

    protected ResultDTO executaMultiplicacao(CalculatorDTO inputData) {
        ResultDTO resultDTO = getInputDataAndSetResult(inputData);
        resultDTO.setResultado(inputData.getNumero1() * inputData.getNumero2());

        return resultDTO;
    }

    protected ResultDTO executaPotenciacao(CalculatorDTO inputData) {
        ResultDTO resultDTO = getInputDataAndSetResult(inputData);
        resultDTO.setResultado((int) Math.pow(inputData.getNumero1(), inputData.getNumero2()));

        return resultDTO;
    }

    protected ResultDTO executaModulo(CalculatorDTO inputData){
        ResultDTO resultDTO = getInputDataAndSetResult(inputData);
        resultDTO.setResultado(Math.abs(inputData.getNumero1()) % inputData.getNumero2());

        return resultDTO;
    }

    private static ResultDTO getInputDataAndSetResult(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setOperacao(inputData.getOperacao());
        resultDTO.setNumero1(inputData.getNumero1());
        resultDTO.setNumero2(inputData.getNumero2());
        return resultDTO;
    }
}


