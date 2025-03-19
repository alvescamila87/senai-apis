package org.senai;

public class Conta {

    private String titular;
    private Double saldo = 0.00;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if(titular == null || titular.isBlank() || titular.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo");
        }
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    private void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CONTA {" +
                "titular: '" + titular + '\'' +
                ", saldo: R$" + saldo +
                '}';
    }

    public void sacar(Double valor) {
        if(valor > getSaldo() || valor < 0) {
            throw  new IllegalArgumentException("Saldo insuficiente");
        }

        setSaldo(getSaldo() - valor);
    }

    public void depositar(Double valor) {
        if(valor < 0) {
            throw  new IllegalArgumentException("Valor negativo não permitido");
        }
        setSaldo(getSaldo() + valor);
    }

    public void transferir(Conta contaTransferencia, Double valorTransferencia) {
        if(valorTransferencia < 0 || valorTransferencia > saldo) {
            throw  new IllegalArgumentException("Saldo insuficiente");
        }
        setSaldo(getSaldo() - valorTransferencia);
        Conta conta = contaTransferencia;
        conta.depositar(valorTransferencia);
    }


}
