package org.senai;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Aeronave> listaAeronaves = new ArrayList<>();

        Aeronave a1 = new Aeronave();
        a1.setModelo("Boing 737");
        a1.setQuantidadePassageiros(189);
        a1.setVelocidadeMaxima(828.01);
        a1.setCapacidadeCombustivel(21_320.01);
        a1.setConsumoCombustivel(2900.90);

        Aeronave a2 = new Aeronave();
        a2.setModelo("Airbus A320");
        a2.setQuantidadePassageiros(829);
        a2.setVelocidadeMaxima(455.01);
        a2.setCapacidadeCombustivel(23_860.01);
        a2.setConsumoCombustivel(3200.90);

        Aeronave a3 = new Aeronave();
        a3.setModelo("Boeing 777");
        a3.setQuantidadePassageiros(301);
        a3.setVelocidadeMaxima(905.01);
        a3.setCapacidadeCombustivel(171_170.01);
        a3.setConsumoCombustivel(8000.90);

        Aeronave a4 = new Aeronave();
        a4.setModelo("Airbus A350");
        a4.setQuantidadePassageiros(280);
        a4.setCapacidadeCombustivel(138_000.01);
        a4.setVelocidadeMaxima(903.01);
        a4.setConsumoCombustivel(3900.90);

        listaAeronaves.add(a1);
        listaAeronaves.add(a2);
        listaAeronaves.add(a3);
        listaAeronaves.add(a4);

        System.out.println(listaAeronaves);

        //a) Qual das aeronaves pode ficar no ar por mais tempo?
        String modeloAeronaveMaisTempoAr = "";
        Double maisTempoNoAr = Double.MIN_VALUE;
        //Double maiorDistanciaMaxima = Double.MAX_VALUE;
        //Double maiorDistanciaMaxima = Double.MAX_VALUE;

        for (Aeronave a : listaAeronaves) {
            final var tempoNoAr = a.obterQtdTempoDeVoo(a.getCapacidadeCombustivel(), a.getConsumoCombustivel());

            if(tempoNoAr > maisTempoNoAr) {
                maisTempoNoAr = tempoNoAr;
                modeloAeronaveMaisTempoAr = a.getModelo();
            }
        }

        System.out.println("Aeronave com mais tempo no ar: " + modeloAeronaveMaisTempoAr + " com " + maisTempoNoAr + " km / por minuto.");

        //b) Qual aeronave leva o maior número de passageiros?
        String modeloAeronaveQtdPassageiros = "";
        Integer maiorQtdPassageiros = Integer.MIN_VALUE;


        for (Aeronave a : listaAeronaves) {
            final var qtdPassageiros = a.getQuantidadePassageiros();

            if(qtdPassageiros > maisTempoNoAr) {
                maiorQtdPassageiros = qtdPassageiros;
                modeloAeronaveQtdPassageiros = a.getModelo();
            }
        }

        System.out.println("Aeronave com maior capacidade de passageiros: " + modeloAeronaveQtdPassageiros + " com capacidade de " + maiorQtdPassageiros + " passageiros.");


        //c) Considerando que os aviões estão em velocidade máxima, qual deles consegue voar mais
        //longe?
        String modeloAeronaveMaiorDistancia = "";
        Double maiorDistanciaAeronaves = Double.MIN_VALUE;


        for (Aeronave a : listaAeronaves) {
            Double tempoNoAr =  a.obterQtdTempoDeVoo(a.getCapacidadeCombustivel(), a.getConsumoCombustivel());
            Double maiorDistancia = a.obterDistanciaMaxima(tempoNoAr, a.getVelocidadeMaxima());
            if(maiorDistancia > maiorDistanciaAeronaves) {
                maiorDistanciaAeronaves = maiorDistancia;
                modeloAeronaveMaiorDistancia = a.getModelo();
            }
        }

        System.out.println("Aeronave que consegue voar mais longe é: " + modeloAeronaveMaiorDistancia + " com capacidade de " + maiorDistanciaAeronaves + " km.");

    }
}