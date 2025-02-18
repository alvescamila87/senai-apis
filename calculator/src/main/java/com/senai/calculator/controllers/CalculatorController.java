package com.senai.calculator.controllers;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;
import com.senai.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @PostMapping("/sum")
    public ResponseEntity<ResultDTO> sum(@RequestBody CalculatorDTO inputData) {
//        ResultDTO resultDTO = new ResultDTO();
//        resultDTO.setResult(inputData.getNumber1() + inputData.getNumber2());
//
//        return ResponseEntity.ok().body(resultDTO);
        final var resultado =  calculatorService.executeSum(inputData);
        return ResponseEntity.ok().body(resultado);
    }
}
