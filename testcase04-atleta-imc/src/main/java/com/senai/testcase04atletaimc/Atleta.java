package com.senai.testcase04atletaimc;

public class Atleta {

    private Integer idade;
    private Double altura;
    private Double peso;

    public String classificarCategoria(Integer idade) {
        if (idade >= 0 && idade <=4) {
            throw new IllegalArgumentException("ERRO: Atleta sem idade para entrar na classificação");
        } else if(idade >= 5 && idade <= 7) {
            return "Atleta pré-mirim";
        } else if(idade >= 8 && idade <= 10) {
            return "Atleta mirim";
        } else if(idade >= 11 && idade <= 13) {
            return "Atleta intantil";
        } else if(idade >= 14 && idade <= 17) {
            return "Atleta infanto-juvenil";
        } else if(idade >= 18 && idade <= 20) {
            return "Atleta juvenil";
        } else if (idade >= 21) {
            return "Atleta adulto";
        } else {
            throw new IllegalArgumentException("ERRO: Idade inexistente");
        }
    }
    
    public String calcularIMC(Double pesoAtleta, Double alturaAtleta) {
        double IMC = pesoAtleta / (alturaAtleta * alturaAtleta);
        
        if(IMC >= 0 && IMC < 18.5 ) {
            return "IMC: Magreza";
        } else if(IMC >= 18.5 && IMC <= 24.9) {
            return "IMC: Saudável";
        } else if (IMC >= 25 && IMC <= 29.9) {
            return "IMC: Sobrepeso";
        } else if (IMC >= 30 && IMC <= 34.9) {
            return "IMC: Obesidade - Grau I";
        } else if (IMC >= 35.5 && IMC <= 39.9) {
            return "IMC: Obesidade - Grau II (severa)";
        } else if (IMC >= 40) {
            return "IMC: Obesidade - Grau III (mórbida)";
        } else {
            throw new IllegalArgumentException("ERRO: IMC inexistente");
        }
    }
}
