package com.gmg.model;
import java.util.ArrayList;

public class Pedido {
    private static int proximoId = 1;
    private int id;
    private double precoTotal;
    private double creditos;
    private ArrayList<Livro> livrosComprados;
    private String status;
    private ArrayList<Carrinho> carrinhosFinalizados;
    private double creditosAcumulados = 0;

    public Pedido() {
        this.id = proximoId++;
        this.precoTotal = 0.0;
        this.creditos = 0.0;
        this.livrosComprados = new ArrayList<>();
        this.status = "Em andamento";
        this.carrinhosFinalizados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public double getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public ArrayList<Livro> getLivrosComprados() {
        return livrosComprados;
    }

    public void setLivrosComprados(ArrayList<Livro> livrosComprados) {
        this.livrosComprados = livrosComprados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Carrinho> getCarrinhosFinalizados() {
        return carrinhosFinalizados;
    }

    public void setCarrinhosFinalizados(ArrayList<Carrinho> carrinhosFinalizados) {
        this.carrinhosFinalizados = carrinhosFinalizados;
    }

    // Método para adicionar um carrinho finalizado ao pedido
    public void adicionarCarrinhoFinalizado(Carrinho carrinho) {
        carrinhosFinalizados.add(carrinho);
        livrosComprados.addAll(carrinho.getLivros()); // Adicionar os livros do carrinho aos livros comprados do pedido
        calcularPrecoTotal(); // Recalcular o preço total com base nos livros comprados
    }

    // Método para calcular o preço total do pedido
    private void calcularPrecoTotal() {
        precoTotal = 0.0;
        for (Livro livro : livrosComprados) {
            precoTotal += livro.getPreco();
        }
        // Deduzir créditos, se houver
        precoTotal -= creditos;
        // Não permitir que o total seja negativo
        if (precoTotal < 0) {
            precoTotal = 0;
        }
    }

    public void setCreditosAcumulados(double creditosAcumulados) {
        this.creditosAcumulados = creditosAcumulados;
    }

    public void devolverEstoque() {
        for (Livro livro : livrosComprados) {
            livro.setEstoque(livro.getEstoque() + 1);
        }
    }
}
