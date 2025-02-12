package org.example;

import java.util.Scanner;

public class Debug02AlturaAtletas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int inscAtletaAlto = 0;
        int inscAtletaBaixo = 0;
        int contador = 0;
        double altura = 0;
        double alturaTotal = 0;
        double alturaMax = Double.MIN_VALUE;
        double alturaMin = Double.MAX_VALUE;

        while (true) {

            System.out.print("Digite o número de inscrição OU (0 para encerrar): ");
            int numInscricao = input.nextInt();

            if(numInscricao <= 0 ){
                System.out.println("Finalizando o programa. Resultado final... \n");
                break;
            }

            System.out.print("Altura do atleta: ");
            altura = input.nextDouble();

            if(altura <= 0 ){
                System.out.println("Altura inválida. Finalizando o programa. Resultado final... \n");
                break;
            }

            if (altura > alturaMax) {
                alturaMax = altura;
                inscAtletaAlto = numInscricao;
            }

            if (altura < alturaMin) {
                alturaMin = altura;
                inscAtletaBaixo = numInscricao;
            }

            alturaTotal += altura;
            contador++;
        }

        double alturaMedia = alturaTotal / contador;

        System.out.println("Atleta mais alto: \nInscrição nº: " + inscAtletaAlto + " metros de altura: "  + alturaMax);
        System.out.println("Atleta mais baixo: \nInscrição nº: " + inscAtletaBaixo + " metros de altura: "  + alturaMin);
        System.out.println("Média de altura: " + alturaMedia + " metros");
        System.out.println("Quantidade de atletas: " + contador);
    }
}