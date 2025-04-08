package org.senai;

import org.senai.pessoa.Pessoa;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                PESSOA
                """);

        Pessoa pessoa01 = new Pessoa();
        pessoa01.setNome("Rei Davi");
        pessoa01.setSexo('M');
        pessoa01.setDataNascimento(LocalDate.of(1986, 10, 20));
        pessoa01.setEstadoCivil("Casado");

        System.out.println(pessoa01);

        Pessoa pessoa02 = new Pessoa();
        pessoa02.setNome("João Batista");
        pessoa02.setSexo('M');
        pessoa02.setDataNascimento(LocalDate.of(1987,12,13));
        pessoa02.setEstadoCivil("Solteiro");

        System.out.println(pessoa02);

    }
}