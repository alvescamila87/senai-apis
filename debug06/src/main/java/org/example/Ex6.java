package org.example;

public class Ex5 {
	// Teste o codigo na main em outra classe
	private String nome;
	private String cpf;
	private String uf;
	private double rendaAnual;

	public Ex5(String nome, String cpf, String uf, double rendaAnual) {
		setNome(nome);
		setCpf(cpf);
		setUf(uf);
		setRendaAnual(rendaAnual);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(double rendaAnual) {
		if (rendaAnual <= 0) {
			rendaAnual = 0;
		}
		this.rendaAnual = rendaAnual;
	}

	public double calcularImposto() {
		double aliquota;

		if (rendaAnual < 4001) {
			aliquota = 0.0;
		} else if (rendaAnual <= 9000) {
			aliquota = 0.058;
		} else if (rendaAnual <= 25000) {
			aliquota = 0.15;
		} else if (rendaAnual <= 35000) {
			aliquota = 0.275;
		} else {
			aliquota = 0.30;
		}

		return rendaAnual * aliquota;
	}

}
