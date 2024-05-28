package com.gmg.model;
import java.io.Serializable;

public class Livro implements Serializable {
    private String titulo;
    private String autor;
    private double preco;
    private int estoque;

    public Livro(String titulo, String autor, double preco, int estoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.estoque = estoque;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}

