package org.senai;

public class Calculadora {

    public int soma(int num1, int num2) {
        return num1 + num2;
    }

    public double divide(int num1, int num2) {
        if(num2 == 0) {
            throw new IllegalArgumentException("Não é possível divisão por zero.");
        }
        return (double) num1 / num2;
    }

    public int subtracao(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplica(int num1, int num2) {
        return num1 * num2;
    }
}
