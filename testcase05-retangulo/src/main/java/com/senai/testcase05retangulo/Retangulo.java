package com.senai.testcase05retangulo;

import java.util.ArrayList;
import java.util.List;

public class Retangulo {

    private Double altura;
    private Double largura;
    public static List<Retangulo> listaRetangulos = new ArrayList<>(); //sem getter e setters

    public Retangulo(Double altura, Double largura) {
        setAltura(altura);
        setLargura(largura);
        listaRetangulos.add(this);
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

    public Double calcularArea(Double alturaRetangulo, Double larguraRetangulo) {
        if(alturaRetangulo < 0 || larguraRetangulo < 0){
            throw new IllegalArgumentException("Valor invalido.");
        }
        return alturaRetangulo * larguraRetangulo;
    }

    public Double calcularPerimetro(Double alturaRetangulo, Double larguraRetangulo) {
        if(alturaRetangulo < 0 || larguraRetangulo < 0){
            throw new IllegalArgumentException("Valor invalido.");
        }
        return 2 * (alturaRetangulo + larguraRetangulo);
    }
}
