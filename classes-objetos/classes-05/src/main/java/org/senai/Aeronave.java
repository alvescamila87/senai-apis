package org.senai;

public class Aeronave {

    public String modelo;
    public Integer quantidadePassageiros;
    public Double velocidadeMaxima;
    public Double capacidadeCombustivel;
    public Double consumoCombustivel;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(Integer quantidadePassageiros) {
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public Double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(Double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public Double getCapacidadeCombustivel() {
        return capacidadeCombustivel;
    }

    public void setCapacidadeCombustivel(Double capacidadeCombustivel) {
        this.capacidadeCombustivel = capacidadeCombustivel;
    }

    public Double getConsumoCombustivel() {
        return consumoCombustivel;
    }

    public void setConsumoCombustivel(Double consumoCombustivel) {
        this.consumoCombustivel = consumoCombustivel;
    }

    public Double obterQtdTempoDeVoo(Double capacidadeCombustivel, Double consumoCombustivel) {
        if(capacidadeCombustivel < 0 || consumoCombustivel < 0) return 0.0;

        return (capacidadeCombustivel / consumoCombustivel) / 60; //por minuto
    }

    public Double obterDistanciaMaxima(Double tempoNoAr, Double velocidadeMaxima) {
        if(capacidadeCombustivel < 0 || velocidadeMaxima < 0) return 0.0;

        return (tempoNoAr * velocidadeMaxima); //km/h
    }

    @Override
    public String toString() {
        return "AERONAVE {" +
                "modelo='" + modelo + '\'' +
                ", quantidadePassageiros=" + quantidadePassageiros +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", capacidadeCombustivel=" + capacidadeCombustivel +
                ", consumoCombustivel=" + consumoCombustivel +
                '}';
    }
}
