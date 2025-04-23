package org.senai;

public class Livro {

    private String titulo;
    private Boolean emprestado;

    public String getTitulo() {
        return titulo;
    }

    public Boolean getEmprestado() {
        return emprestado;
    }

    public void setTitulo(String titulo) {
        if(titulo == null || titulo.isEmpty() || titulo.isBlank()) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.titulo = titulo;
    }

    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void emprestarLivro() {
            if(emprestado) {
                throw new IllegalArgumentException("Livro não disponível");
            }
            setEmprestado(true);
    }
}
