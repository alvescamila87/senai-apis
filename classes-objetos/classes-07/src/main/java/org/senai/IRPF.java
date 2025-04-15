package org.senai;

public class IRPF {

    private String nome;
    private String cpf;
    private String uf;
    private Double rendaAnual;

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

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public Double calcularImposto(Double rendaAnual) {
        Double valorImposto = 0.0;

        if(rendaAnual < 0) {
            return null;
        }

        if(rendaAnual >= 0 && rendaAnual <= 4_000 ){
            return valorImposto;
        }

        if(rendaAnual > 4_000 && rendaAnual <= 9_000) {
            return valorImposto = rendaAnual * (5.8 /100);
        }

        if(rendaAnual > 9_000 && rendaAnual <= 25_000) {
            return valorImposto = rendaAnual * (15 / 100);
        }

        if(rendaAnual > 25_000 && rendaAnual <= 35_000) {
            return valorImposto = rendaAnual * (15 / 100);
        }

        if(rendaAnual > 35_000) {
            return valorImposto = rendaAnual * (15 / 100);
        }

        return valorImposto;
    }

    @Override
    public String toString() {
        return "IRPF {" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", uf='" + uf + '\'' +
                ", rendaAnual=" + rendaAnual +
                '}';
    }
}
