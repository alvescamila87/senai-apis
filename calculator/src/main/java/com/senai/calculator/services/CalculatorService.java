package com.senai.calculator.services;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public ResultDTO executeSum(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(inputData.getNumber1() + inputData.getNumber2());

        return resultDTO;
    }

    public ResultDTO executeSubtract(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(inputData.getNumber1() - inputData.getNumber2());

        return resultDTO;
    }

    public ResultDTO executeDivide(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();

        try {
            resultDTO.setResult(inputData.getNumber1() / inputData.getNumber2());
        } catch (ArithmeticException e) {
            resultDTO.setMensagem("Division by zero");
        }

        return resultDTO;
    }

    public ResultDTO executeMultiply(CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(inputData.getNumber1() * inputData.getNumber2());

        return resultDTO;
    }
}
