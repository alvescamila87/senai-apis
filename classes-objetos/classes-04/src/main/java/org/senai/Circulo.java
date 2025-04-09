package org.senai;

public class Circulo {

    private Double raio;

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "raio=" + raio +
                " area=" + calcularArea(raio) +
                '}';
    }

    public Double calcularArea(Double raio) {
        Double resultado = (raio * raio) * Math.PI;
        return  resultado;
    }
}
