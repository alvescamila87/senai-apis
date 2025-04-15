package org.senai;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<IRPF> listaContribuintes = new ArrayList<>();

        IRPF contribuinte01 = new IRPF();
        contribuinte01.setNome("Zebedeu Abraão");
        contribuinte01.setCpf("953.694.630-00");
        contribuinte01.setUf("SC");
        contribuinte01.setRendaAnual(150_000.98);

        IRPF contribuinte02 = new IRPF();
        contribuinte02.setNome("Sara Raquel");
        contribuinte02.setCpf("252.249.430-94");
        contribuinte02.setUf("RJ");
        contribuinte02.setRendaAnual(220_000.75);

        IRPF contribuinte03 = new IRPF();
        contribuinte03.setNome("Elias Samuel");
        contribuinte03.setCpf("908.096.820-01");
        contribuinte03.setUf("MG");
        contribuinte03.setRendaAnual(55_000.20);

        IRPF contribuinte04 = new IRPF();
        contribuinte04.setNome("Ester Rute");
        contribuinte04.setCpf("306.868.920-11");
        contribuinte04.setUf("RS");
        contribuinte04.setRendaAnual(310_000.90);

        IRPF contribuinte05 = new IRPF();
        contribuinte05.setNome("Noé Daniel");
        contribuinte05.setCpf("971.098.610-40");
        contribuinte05.setUf("SP");
        contribuinte05.setRendaAnual(110_000.15);

        listaContribuintes.add(contribuinte01);
        listaContribuintes.add(contribuinte02);
        listaContribuintes.add(contribuinte03);
        listaContribuintes.add(contribuinte04);
        listaContribuintes.add(contribuinte05);

        System.out.println(listaContribuintes);

        //a) Quem mais paga imposto
        String nomeMaiorPagadorImposto = "";
        Double maiorPagadorImposto = Double.MIN_VALUE;

        for(IRPF contribuinte : listaContribuintes) {
            //var rendaAnual = contribuinte.getRendaAnual();

            double valorContribuicao = contribuinte.calcularImposto(contribuinte.getRendaAnual());

            if(valorContribuicao > maiorPagadorImposto) {
                maiorPagadorImposto = valorContribuicao;
                nomeMaiorPagadorImposto = contribuinte.getNome();
            }

        }

        System.out.println("O maior pagador de impostos é:  " + nomeMaiorPagadorImposto + " pagando R$ " + maiorPagadorImposto + " por ano.");



    }
}