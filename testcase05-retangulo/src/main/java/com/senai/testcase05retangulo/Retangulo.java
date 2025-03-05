package com.senai.testcase05retangulo;

import java.util.ArrayList;
import java.util.List;

public class Retangulo {

    private Double altura;
    private Double largura;
    public static List<Retangulo> listaRetangulos = new ArrayList<>(); //sem getter e sem setter

    public Retangulo(Double altura, Double largura) {
        if(altura < 0 || largura < 0) {
            throw new IllegalArgumentException("Valores negativos inválidos.");
        }
        setAltura(altura);
        setLargura(largura);
        listaRetangulos.add(this); //Não colocar como parâmetro de construtor
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

//    public Double calcularArea(Double alturaRetangulo, Double larguraRetangulo) {
//        if(alturaRetangulo < 0 || larguraRetangulo < 0){
//            throw new IllegalArgumentException("Valor invalido.");
//        }
//        return alturaRetangulo * larguraRetangulo;
//    }
//
//    public Double calcularPerimetro(Double alturaRetangulo, Double larguraRetangulo) {
//        if(alturaRetangulo < 0 || larguraRetangulo < 0){
//            throw new IllegalArgumentException("Valor invalido.");
//        }
//        return 2 * (alturaRetangulo + larguraRetangulo);
//    }

   public Double calcularArea() {
        return altura * largura;
    }

    public Double calcularPerimetro() {
        return 2 * (altura + largura);
    }

    public Double verificarMaiorArea() {
        Double retanguloMaiorArea = Double.MIN_VALUE;

        for(Retangulo retangulo : listaRetangulos) {
            Double resultado = retangulo.calcularArea();
            if(resultado > retanguloMaiorArea) {
                retanguloMaiorArea = resultado;
            }
        }
        System.out.println("Retângulo com maior área: " + retanguloMaiorArea);
        return retanguloMaiorArea;
    }

    public Double verificarMaiorPerimetro() {
        Double retanguloMaiorPerimetro = Double.MIN_VALUE;

        for(Retangulo retangulo : listaRetangulos) {
            Double resultado = retangulo.calcularPerimetro();
            if(resultado > retanguloMaiorPerimetro) {
                retanguloMaiorPerimetro = resultado;
            }
        }
        System.out.println("Retângulo com maior perímetro: " + retanguloMaiorPerimetro);
        return retanguloMaiorPerimetro;
    }

}
