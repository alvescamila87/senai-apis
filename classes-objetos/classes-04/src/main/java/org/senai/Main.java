package org.senai;

import org.w3c.dom.css.CSSImportRule;

public class Main {
    public static void main(String[] args) {
        Circulo circulo01 = new Circulo();
        circulo01.setRaio(5.34);
        circulo01.calcularArea(circulo01.getRaio());

        System.out.println(circulo01);

        Circulo circulo02 = new Circulo();
        circulo02.setRaio(5.0);
        circulo02.calcularArea(circulo02.getRaio());

        System.out.println(circulo02);


        Circulo circulo03 = new Circulo();
        circulo03.setRaio(4.78);
        circulo03.calcularArea(circulo03.getRaio());

        System.out.println(circulo03);


        Circulo circulo04 = new Circulo();
        circulo04.setRaio(3.90);
        circulo04.calcularArea(circulo04.getRaio());

        System.out.println(circulo04);

        Circulo circulo05 = new Circulo();
        circulo05.setRaio(1.13);
        circulo05.calcularArea(circulo05.getRaio());

        System.out.println(circulo05);

    }
}