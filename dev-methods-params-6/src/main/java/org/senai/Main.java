package org.senai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int valor1 = 0;
        int valor2 = 0;

        System.out.println("Informe o valor 1: ");
        valor1 = input.nextInt();

        System.out.println("Informe o valor 2: ");
        valor2 = input.nextInt();

        checarAproximacaoBase(base, valor1, valor2);

    }

    static int base = 100;

    public static void checarAproximacaoBase(int base, int num1, int num2) {


        if((base - num1) * (base - num1) > (base - num2) * (base + num2))  {
            System.out.println("Número 2: " + num2 + " é mais próximo da Base: " + base);
        } else if ((base - num1) * (base - num1) < (base - num2) * (base + num2))  {
            System.out.println("Número 1 e Número 2 têm a mesma distância da Base: " + base);
        } else {
            System.out.println("Número 1 e Número 2 têm a mesma distância da Base: " + base);
       }

        //((base - num1) * (base + num1)) > (((base - num2) * (base + num2)))
        //((base - num1) * (base + num1)) < (((base - num2) * (base + num2)))

        //((base - num1) * (base - num1)) > ((base - num2) * (base + num2))
    }
}