package org.senai.pessoa;

import java.time.LocalDate;

public class Pessoa {

    String nome;
    Character sexo;
    LocalDate dataNascimento;
    String estadoCivil;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null) {
            throw new NullPointerException("Valor nulo");
        }
        if(nome.isEmpty() || nome.isBlank()) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.nome = nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        if(sexo == null) {
            throw new NullPointerException("Valor nulo");
        }
        if(Character.isDigit(sexo) || Character.isWhitespace(sexo)) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.sexo = Character.toUpperCase(sexo);
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if(dataNascimento == null) {
            throw new NullPointerException("Valor nulo");
        }
        if(dataNascimento.isAfter((LocalDate.now()))) {
            throw new IllegalArgumentException("A data de nascimento não pode ser no futuro.");
        }
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        if(estadoCivil == null) {
            throw new NullPointerException("Valor nulo");
        }
        if(estadoCivil.isEmpty() || estadoCivil.isBlank()) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }
}
