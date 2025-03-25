package org.senai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o nome do colega: ");
        String nome = input.nextLine();

        if(nome.equalsIgnoreCase("zebedeu")) {
            zebedeu();
        } else if(nome.equalsIgnoreCase("madalena")){
            madalena();
        }
    }

    public static void zebedeu() {
        System.out.println("Olá meu nome é Zebedeu.");
        System.out.println("Tenho 20 anos.");
        System.out.println("Estudo no SENAI");
    }

    public static void madalena() {
        System.out.println("Olá meu nome é Madalena.");
        System.out.println("Tenho 18 anos.");
        System.out.println("Estudo no SENAI");
    }
}