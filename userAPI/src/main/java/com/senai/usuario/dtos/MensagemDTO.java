package com.senai.usuario.dtos;

public class MensagemDTO {

    private String mensagem;
    private boolean statusSucesso;

    public MensagemDTO() {
        this.statusSucesso = true;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isStatusSucesso() {
        return statusSucesso;
    }

    public void setStatusSucesso(boolean statusSucesso) {
        this.statusSucesso = statusSucesso;
    }
}
