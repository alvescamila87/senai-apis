package org.senai.mercado;

public class Mercado {

    private String nome;
    private Integer quantidadeMacaVendidaPorAno;
    private Double precoMaca;
    private Integer quantidadeLaranjaVendidaPorAno;
    private Double precoLaranja;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeMacaVendidaPorAno() {
        return quantidadeMacaVendidaPorAno;
    }

    public void setQuantidadeMacaVendidaPorAno(Integer quantidadeMacaVendidaPorAno) {
        this.quantidadeMacaVendidaPorAno = quantidadeMacaVendidaPorAno;
    }

    public Double getPrecoMaca() {
        return precoMaca;
    }

    public void setPrecoMaca(Double precoMaca) {
        this.precoMaca = precoMaca;
    }

    public Integer getQuantidadeLaranjaVendidaPorAno() {
        return quantidadeLaranjaVendidaPorAno;
    }

    public void setQuantidadeLaranjaVendidaPorAno(Integer quantidadeLaranjaVendidaPorAno) {
        this.quantidadeLaranjaVendidaPorAno = quantidadeLaranjaVendidaPorAno;
    }

    public Double getPrecoLaranja() {
        return precoLaranja;
    }

    public void setPrecoLaranja(Double precoLaranja) {
        this.precoLaranja = precoLaranja;
    }

    @Override
    public String toString() {
        return "Mercado{" +
                "nome='" + nome + '\'' +
                ", quantidadeMacaVendidaPorAno=" + quantidadeMacaVendidaPorAno +
                ", precoMaca=" + precoMaca +
                ", quantidadeLaranjaVendidaPorAno=" + quantidadeLaranjaVendidaPorAno +
                ", precoLaranja=" + precoLaranja +
                '}';
    }
}
