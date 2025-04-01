package org.senai;

public class Main {
    public static void main(String[] args) {

        int[] numeros = {100, 59, 13, 29, 14, 20, 2};
        maiorElemento(numeros);
        menorElemento(numeros);
        calcularMedia(numeros);
    }

    static int maiorElemento = Integer.MIN_VALUE;
    static int menorElemento = Integer.MAX_VALUE;
    static int media = 0;

    public static void maiorElemento(int[] numeros) {
        for(int i = 0; i < numeros.length; i++) {
            if(numeros[i] > maiorElemento) {
                maiorElemento = numeros[i];
            }
        }
        System.out.println("Maior elemento: " + maiorElemento);
    }

    public static void menorElemento(int[] numeros) {
        for (int numero : numeros) {
            if (numero < menorElemento) {
                menorElemento = numero;
            }
        }
        System.out.println("Menor elemento: " + menorElemento);
    }

    public static void calcularMedia(int[] numeros) {
        int soma = 0;
        for(int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        media = soma / numeros.length;
        System.out.println("Média dos elementos: " + media);
    }

}