package com.senai.convertionapi.dtos;

import lombok.Getter;
import lombok.Setter;

public class RequisicaoDTO {

    private Double valor;
    private String tipoConversao;
    private String mensagem;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipoConversao() {
        return tipoConversao;
    }

    public void setTipoConversao(String tipoConversao) {
        this.tipoConversao = tipoConversao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
