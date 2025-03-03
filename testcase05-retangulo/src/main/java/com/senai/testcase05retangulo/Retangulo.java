package com.senai.testcase05retangulo;

public class Retangulo {

    private Double altura;
    private Double largura;

    public Double calcularArea(Double alturaRetangulo, Double larguraRetangulo) {
        if(alturaRetangulo < 0 || larguraRetangulo < 0){
            throw new IllegalArgumentException("Valor invalido.");
        }
        return alturaRetangulo * larguraRetangulo;
    }

    public Double calcularPerimetro(Double alturaRetangulo, Double larguraRetangulo) {
        return 2 * (alturaRetangulo + larguraRetangulo);
    }
}
