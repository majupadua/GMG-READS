package com.gmg.model;
import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Livro> livros;

    public Carrinho() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivroCarrinho(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado ao carrinho: " + livro.getTitulo());
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    // Método para listar os livros no carrinho
    public void listarLivrosNoCarrinho() {
        if (livros.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.println("Livros no carrinho:");
            for (Livro livro : livros) {
                System.out.println("- " + livro.getTitulo());
            }
        }
    }

    public double totalCarrinho() {
        double total = 0;
        for (Livro livro : livros) {
            total += livro.getPreco();
        }
        return total;
    }

    public void atualizarEstoque() {
        for (Livro livro : livros) {
            livro.setEstoque(livro.getEstoque() - 1);
        }
    }

}
