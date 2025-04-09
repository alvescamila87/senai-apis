package org.senai;

import org.senai.produto.Produto;

public class Main {
    public static void main(String[] args) {

        Produto produto01 = new Produto();
        produto01.setNome("Caderno");
        produto01.setDescricao("Carderno espiral grande");
        produto01.setValorUnitario(20.90);
        produto01.setDesconto(10);

        Produto produto02 = new Produto();
        produto02.setNome("Caneta");
        produto02.setDescricao("Caneta Marca texto");
        produto02.setValorUnitario(15.90);
        produto02.setDesconto(5);

        Produto produto03 = new Produto();
        produto03.setNome("Lapiseira");
        produto03.setDescricao("Lapiseira pentel");
        produto03.setValorUnitario(50.90);
        produto03.setDesconto(2);

        System.out.println(produto01);
        System.out.println(produto02);
        System.out.println(produto03);

    }
}