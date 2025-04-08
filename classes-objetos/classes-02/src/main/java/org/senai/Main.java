package org.senai;

import org.senai.mercado.Mercado;

public class Main {
    public static void main(String[] args) {
        Mercado mercado01 = new Mercado();
        mercado01.setNome("Unidade de Blumenau");
        mercado01.setPrecoLaranja(14.90);
        mercado01.setQuantidadeLaranjaVendidaPorAno(55_000);
        mercado01.setPrecoMaca(8.90);
        mercado01.setQuantidadeMacaVendidaPorAno(35_000);

        Mercado mercado02 = new Mercado();
        mercado02.setNome("Unidade de Joinville");
        mercado02.setPrecoLaranja(13.90);
        mercado02.setQuantidadeLaranjaVendidaPorAno(54_000);
        mercado02.setPrecoMaca(7.90);
        mercado02.setQuantidadeMacaVendidaPorAno(34_000);

        Mercado mercado03 = new Mercado();
        mercado03.setNome("Unidade de Florianópolis");
        mercado03.setPrecoLaranja(12.90);
        mercado03.setQuantidadeLaranjaVendidaPorAno(53_000);
        mercado03.setPrecoMaca(6.90);
        mercado03.setQuantidadeMacaVendidaPorAno(33_000);

        System.out.println(mercado01);
        System.out.println(mercado02);
        System.out.println(mercado03);
    }
}