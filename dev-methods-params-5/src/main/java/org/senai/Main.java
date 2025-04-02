package org.senai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int valor1 = 0;
        int valor2 = 0;

        System.out.println("Informe o 1º valor: ");
        valor1 = input.nextInt();

        System.out.println("Informe o 2º valor: ");
        valor2 = input.nextInt();

        calcular(valor1, valor2);

    }

    public static void calcular(int num1, int num2) {
        int resultado1 = 0;
        int resultado2 = 0;
        int resultado3 = 0;

        if(num1 == 5 || num2 == 5 || (num1 + num2 == 5) || (num2 - num1 == 5)) {
            resultado1 = num1 * num1 * num1;
            resultado2 = num2 * num2 * num2;
            System.out.println("Cubo 1: " + resultado1);
            System.out.println("Cubo 2: " + resultado2);
        } else {
            resultado3 = num1 * num2;
            System.out.println("Quadrado: " + resultado3);
        }
    }
}

