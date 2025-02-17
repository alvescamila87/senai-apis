package com.senai.calculator.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorDTO {

    @GetMapping("/calculator")
    public String getCalculator() {
        return "HELLO WORLD, Calculator";
    }
}
