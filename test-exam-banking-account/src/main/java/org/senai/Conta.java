package org.senai;

public class Conta {

	private String nome;
	private double saldo;

	public Conta(String nome, double saldo) {
		setNome(nome);
		setSaldo(saldo);
	}

	public void sacar(double qtd) {

		if (qtd > saldo) {
			throw new IllegalArgumentException("Saldo insuficiente");
		}
		setSaldo(getSaldo() - qtd);
	}
	
	public void depositar(double qtd) {
		setSaldo(getSaldo() + qtd);
	}
	
	public void transferir(Conta outra, double qtd) {
		if(qtd > saldo) {
			throw new IllegalArgumentException("Saldo insuficiente");
		}
		outra.setSaldo(outra.getSaldo() + qtd);
		setSaldo(saldo - qtd);
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome inválido");
		}
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
