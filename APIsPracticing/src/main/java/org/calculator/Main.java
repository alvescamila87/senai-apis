 package org.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.add(13, 5);
        calc.multiply(0, 3);
        calc.divide(0, 3);
        calc.subtract(0, 3);
    }
}