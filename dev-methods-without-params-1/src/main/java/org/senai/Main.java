package org.senai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       System.out.println("Insira o valor");
       int opcao = input.nextInt();

       if(opcao == 1) {
           verao();
       } else if(opcao == 2) {
           outono();
       } else if(opcao == 3) {
           inverno();
       } else if(opcao ==4) {
           primavera();
       }
    }

    public static void verao() {
        System.out.println("É verão! \nO tempo está quente...");
    }

    public static void outono() {
        System.out.println("É outono! \nAs folhas caem...");
    }

    public static void inverno() {
        System.out.println("É inverno! \n O tempo está frio...");
    }

    public static void primavera() {
        System.out.println("É primavera! \nAs flores estão florindo...");
    }
}