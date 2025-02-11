package org.example;

import java.util.Scanner;

public class Debug01AlturaPessoas {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double somaAltura = 0;
        int contador = 0;
        double altura;

        while (true) {
            //contador++;
            System.out.println("Insira a altura (cm): ");
            altura = input.nextDouble();
            if (altura > 0) {
                //somaAltura++;
                somaAltura += altura;
                contador++;
            } else if ( altura == 0) {
                System.out.println("Saída do programa. Exibindo resultado final...");
                break;
            } else {
                System.out.println("Não existe altura negativa");
                break;
            }
        }

        //double media = altura / contador;
        double media = somaAltura / contador;
        System.out.println("Média de altura calculada: " + media);
    }
}