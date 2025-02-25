package com.senai.usuario.models;

public class Car {

    private String nome;

    public Car(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
