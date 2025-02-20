package com.senai.calculator.controllers;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;
import com.senai.calculator.services.CalculatorService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora2")
public class CalculatorController2 {

    @Autowired
    CalculatorService2 service;

    @PostMapping("/{operacao}")
    public ResponseEntity<ResultDTO> executaCalculadora(@PathVariable String operacao, @RequestBody CalculatorDTO inputData) {
        inputData.setOperacao(operacao);
        ResultDTO resultado =  service.executaOperacao(inputData);
        return ResponseEntity.ok().body(resultado);
    }
}
