package org.senai;

public class Main {
    public static void main(String[] args) {
        Conta conta1 = new Conta();
        conta1.setTitular("João");

        //inicia
        System.out.println(conta1);

        //deposita valor
        conta1.depositar(1000.0);
        System.out.println(conta1);

        //saca valor
        conta1.sacar(250.0);
        System.out.println(conta1);

        //cria conta2
        Conta conta2 = new Conta();
        conta2.setTitular("Camila");
        System.out.println(conta2);

        //transferir conta 1 para conta 2
        conta1.transferir(conta2, 95.00);
        System.out.println(conta2);
        System.out.println(conta1);

    }
}