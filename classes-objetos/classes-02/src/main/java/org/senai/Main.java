package org.senai;

import org.senai.mercado.Mercado;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Mercado mercado01 = new Mercado();
        mercado01.setNome("Unidade de Blumenau");
        mercado01.setPrecoLaranja(14.90);
        mercado01.setQuantidadeLaranjaVendidaPorAno(55_000);
        mercado01.setPrecoMaca(8.90);
        mercado01.setQuantidadeMacaVendidaPorAno(35_000);
        System.out.println("Mercado 01");
        System.out.println("RECEITA MAÇA: " + mercado01.calcularReceita(mercado01.getPrecoMaca(), mercado01.getQuantidadeMacaVendidaPorAno()));
        System.out.println("RECEITA LARANJA: " + mercado01.calcularReceita(mercado01.getPrecoLaranja(), mercado01.getQuantidadeLaranjaVendidaPorAno()));

        Mercado mercado02 = new Mercado();
        mercado02.setNome("Unidade de Joinville");
        mercado02.setPrecoLaranja(13.90);
        mercado02.setQuantidadeLaranjaVendidaPorAno(54_000);
        mercado02.setPrecoMaca(7.90);
        mercado02.setQuantidadeMacaVendidaPorAno(34_000);
        System.out.println("Mercado 02");
        System.out.println("RECEITA MAÇA: " + mercado02.calcularReceita(mercado02.getPrecoMaca(), mercado02.getQuantidadeMacaVendidaPorAno()));
        System.out.println("RECEITA LARANJA: " + mercado02.calcularReceita(mercado02.getPrecoLaranja(), mercado02.getQuantidadeLaranjaVendidaPorAno()));

        Mercado mercado03 = new Mercado();
        mercado03.setNome("Unidade de Florianópolis");
        mercado03.setPrecoLaranja(12.90);
        mercado03.setQuantidadeLaranjaVendidaPorAno(53_000);
        mercado03.setPrecoMaca(6.90);
        mercado03.setQuantidadeMacaVendidaPorAno(33_000);
        System.out.println("Mercado 03");
        System.out.println("RECEITA MAÇA: " + mercado03.calcularReceita(mercado03.getPrecoMaca(), mercado03.getQuantidadeMacaVendidaPorAno()));
        System.out.println("RECEITA LARANJA: " + mercado03.calcularReceita(mercado03.getPrecoLaranja(), mercado03.getQuantidadeLaranjaVendidaPorAno()));

        System.out.println("RECEITA TOTAL");
        System.out.println("TOTAL MAÇA: "
                + mercado01.calcularReceita(mercado01.getPrecoMaca(), mercado01.getQuantidadeMacaVendidaPorAno())
                + mercado02.calcularReceita(mercado02.getPrecoMaca(), mercado02.getQuantidadeMacaVendidaPorAno())
                + mercado03.calcularReceita(mercado03.getPrecoMaca(), mercado03.getQuantidadeMacaVendidaPorAno())
        );
        System.out.println("TOTAL LARANJA: "
                + mercado01.calcularReceita(mercado01.getPrecoLaranja(), mercado01.getQuantidadeLaranjaVendidaPorAno())
                + mercado02.calcularReceita(mercado02.getPrecoLaranja(), mercado02.getQuantidadeLaranjaVendidaPorAno())
                + mercado03.calcularReceita(mercado03.getPrecoLaranja(), mercado03.getQuantidadeLaranjaVendidaPorAno())
        );

        System.out.println(mercado01);
        System.out.println(mercado02);
        System.out.println(mercado03);
    }
}