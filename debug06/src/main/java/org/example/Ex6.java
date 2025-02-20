package org.example;

public class Ex6 {
	// Teste o codigo na main em outra classe
	private String nome;
	private String descricao;
	private double preco;
	private double peso;
	private int estoque;

	public Ex6(String nome, String descricao, double preco, double peso, int estoque) {
		setNome(nome);
		setDescricao(descricao);
		setPreco(preco);
		setPeso(peso);
		setEstoque(estoque);
	}

	public void adicionarEstoque(int quantidade) {
		this.estoque += quantidade;
	}

	public void adicionarEstoque() {
		this.estoque++;
	}

	public void venderProduto(int quantidade) {
		if (quantidade > 0 && quantidade <= this.estoque) {
			this.estoque -= quantidade;
		} else {
			System.err.println("Quantidade informada para venda é SUPERIOR à quantidade existente no estoque.");
		}
	}

	public void aplicarPromocao(double porcentagemDesconto) {
		double desconto = this.preco * (porcentagemDesconto/100);
		this.preco = this.preco - desconto;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

}