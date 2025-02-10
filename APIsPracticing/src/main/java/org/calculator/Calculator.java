package org.calculator;

public class Calculator {

    public int add(int num1, int num2) {
        int resultado = num1 + num2;
        System.out.println("A soma é: " + resultado);
        return resultado;
    }

    public int multiply(int num1, int num2) {
        if(num1 == 0 || num2 == 0){
            System.out.println("Qualquer número multiplicado por zero é zero.");
            return 0;
        }
        int resultado = num1 * num2;
        System.out.println("O produto é: " + resultado);
        return resultado;
    }

    public double divide(int num1, int num2) {
        if(num1 == 0 || num2 == 0) {
            System.out.println("Qualquer divisão por zero é zero.");
            return 0;
        }
        int resultado = num1 / num2;
        System.out.println("A divisão é: " + resultado);
        return resultado;
    }

    public int subtract(int num1, int num2) {
        int resultado = num1 - num2;
        if(num1 < num2) {
            System.out.println("Resultado negativo: " + resultado);
            return resultado;
        }
        System.out.println("Resultado da substração: " + resultado);
        return resultado;
    }
}
