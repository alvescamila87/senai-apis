package com.senai.usuario.models;


import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {

    private String id;
    private String nome;
    private List<UsuarioModel> listaUsuarios = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<UsuarioModel> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<UsuarioModel> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
