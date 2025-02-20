package com.senai.calculator.controllers;

import com.senai.calculator.dtos.CalculatorDTO;
import com.senai.calculator.dtos.ResultDTO;
import com.senai.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @PostMapping("/adicionar")
    public ResponseEntity<ResultDTO> soma(@RequestBody CalculatorDTO inputData) {
        final var resultado =  calculatorService.executaSoma(inputData);
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/subtrair")
    public ResponseEntity<ResultDTO> subtrai(@RequestBody CalculatorDTO inputData) {
        ResultDTO resultDTO = calculatorService.executaSubtracao(inputData);
        return ResponseEntity.ok().body(resultDTO);
    }

    @PostMapping("/dividir ")
    public ResponseEntity<ResultDTO> divide(@RequestBody CalculatorDTO inputData){
        ResultDTO resultado = calculatorService.executaDivisao(inputData);
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/multiplicar")
    public ResponseEntity<ResultDTO> multiplica(@RequestBody CalculatorDTO inputData) {
        ResultDTO resultDTO = calculatorService.executaMultiplicacao(inputData);
        return ResponseEntity.ok().body(resultDTO);
    }

    @PostMapping("/potencia")
    public ResponseEntity<ResultDTO> potencia(@RequestBody CalculatorDTO inputData) {
        ResultDTO resultDTO = calculatorService.executaPotenciacao(inputData);
        return ResponseEntity.ok().body(resultDTO);
    }

    @PostMapping("/modulo")
    public ResponseEntity<ResultDTO> modulo(@RequestBody CalculatorDTO inputData) {
        ResultDTO resultDTO = calculatorService.executaModulo(inputData);
        return ResponseEntity.ok().body(resultDTO);
    }
}
