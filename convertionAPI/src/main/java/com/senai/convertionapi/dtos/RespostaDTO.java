package com.senai.convertionapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaDTO {

    private Double valorOriginal;
    private String tipoConversao;
    private Double valorConvertido;
    private String erro;

    public RespostaDTO() {
        valorConvertido = 0.0;
    }

    public Double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(Double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public String getTipoConversao() {
        return tipoConversao;
    }

    public void setTipoConversao(String tipoConversao) {
        this.tipoConversao = tipoConversao;
    }

    public Double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(Double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
