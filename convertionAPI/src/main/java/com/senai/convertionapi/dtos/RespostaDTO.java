package com.senai.convertionapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaDTO {

    private Integer valorOriginal;
    private String tipoConversao;
    private Integer valorConvertido;
    private String erro;

    public RespostaDTO() {
        valorConvertido = 0;
    }

    public Integer getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(Integer valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public String getTipoConversao() {
        return tipoConversao;
    }

    public void setTipoConversao(String tipoConversao) {
        this.tipoConversao = tipoConversao;
    }

    public Integer getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(Integer valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
