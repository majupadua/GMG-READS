package com.gmg.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Estante {
    private HashMap<String, ArrayList<Livro>> categorias;

    public Estante() {
        this.categorias = new HashMap<>();
        adicionarCategoria("Já Lidos");
        adicionarCategoria("Leituras Atuais");
        adicionarCategoria("Leituras Futuras");
    }

    // Método para adicionar uma nova categoria na estante
    public void adicionarCategoria(String categoria) {
        categorias.put(categoria, new ArrayList<>());
    }

    // Método para adicionar um livro a uma categoria específica da estante
    public void adicionarLivro(String categoria, Livro livro) {
        if (categorias.containsKey(categoria)) {
            categorias.get(categoria).add(livro);
        } else {
            System.out.println("Categoria não encontrada.");
        }
    }

    // Método para buscar e retornar os livros de uma categoria específica
    public ArrayList<Livro> buscarLivrosNaCategoria(String categoria) {
        return categorias.getOrDefault(categoria, new ArrayList<>());
    }

    // Getters e Setters
    public HashMap<String, ArrayList<Livro>> getCategorias() {
        return categorias;
    }
}
