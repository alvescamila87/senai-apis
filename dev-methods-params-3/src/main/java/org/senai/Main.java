package org.senai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe um número: ");
        int opcao = input.nextInt();

        preverProximosNumeros(opcao);
    }

    public static void preverProximosNumeros(int num) {
        System.out.println("Número informado: " + num + " e os 20 próximos são:");
        for(int x = 0; x < 20; x++ ){
            System.out.println(x + 1 + "º: " + (num + x));
        }
    }
}