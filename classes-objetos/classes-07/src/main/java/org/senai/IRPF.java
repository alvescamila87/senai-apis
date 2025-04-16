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

    public Double calcularImposto() {
        Double valorImposto = 0.0;

        if(rendaAnual < 0) {
            return valorImposto;
        } else if(rendaAnual <= 4_000 ){
            return valorImposto;
        } else if (rendaAnual <= 9000) {
            valorImposto = rendaAnual * (5.8 /100);
        } else if(rendaAnual <= 25000) {
            valorImposto = rendaAnual * (15.0 / 100);
        } else if(rendaAnual <= 35000) {
            valorImposto = rendaAnual * (27.5 / 100);
        } else if (rendaAnual > 35000) {
            valorImposto = rendaAnual * (30.0 / 100);
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
