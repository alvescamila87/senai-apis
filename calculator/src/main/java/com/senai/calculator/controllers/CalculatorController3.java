package com.senai.calculator.controllers;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;
import com.senai.calculator.services.CalculatorService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora3")
public class CalculatorController3 {

    @Autowired
    CalculatorService3 service;

    @PostMapping
    public ResponseEntity<ResultDTO> executaCalculadora(@RequestBody CalculatorDTO inputData) {
        ResultDTO resultado =  service.executaOperacao(inputData);
        return ResponseEntity.ok().body(resultado);
    }
}
