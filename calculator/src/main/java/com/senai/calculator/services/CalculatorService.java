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
}
