package com.senai.calculator.controllers;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;
import com.senai.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @PostMapping("/sum")
    public ResponseEntity<ResultDTO> sum(@RequestBody CalculatorDTO inputData) {
        final var resultado =  calculatorService.executeSum(inputData);
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/divide")
    public ResponseEntity<ResultDTO> divide(@RequestBody CalculatorDTO inputData){
        ResultDTO resultado = calculatorService.executeDivide(inputData);
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("subtract")
    public ResponseEntity<ResultDTO> subtract(@RequestBody CalculatorDTO inputData) {
        ResultDTO resultDTO = calculatorService.executeSubtract(inputData);
        return ResponseEntity.ok().body(resultDTO);
    }

    @PostMapping("/multiply")
    public ResponseEntity<ResultDTO> multiply(@RequestBody CalculatorDTO inputData) {
        ResultDTO resultDTO = calculatorService.executeMultiply(inputData);
        return ResponseEntity.ok().body(resultDTO);
    }
}
