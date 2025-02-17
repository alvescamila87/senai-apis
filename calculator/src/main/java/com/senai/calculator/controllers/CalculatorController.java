package com.senai.calculator.controllers;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @PostMapping
    public ResponseEntity<ResultDTO> sum(@RequestBody CalculatorDTO inputData) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(inputData.getNumber1() + inputData.getNumber2());

        return ResponseEntity.ok().body(resultDTO);
    }
}
