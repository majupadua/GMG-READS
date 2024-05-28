package com.gmg.model;
import java.util.ArrayList;
import java.util.HashMap;

public class Cliente {
    private String nome;
    private ArrayList<Pedido> historicoPedidos;
    private double creditos;
    private HashMap<String, ArrayList<Livro>> historicoPrateleiras;

    public Cliente(String nome) {
        this.nome = nome;
        this.historicoPedidos = new ArrayList<>();
        this.creditos = 0.0;
        this.historicoPrateleiras = new HashMap<>();
    }

    // Métodos para adicionar e visualizar histórico de pedidos
    public void adicionarPedido(Pedido pedido) {
        historicoPedidos.add(pedido);
    }

    public ArrayList<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }

    // Métodos para adicionar e visualizar créditos
    public void adicionarCreditos(double valor) {
        creditos += valor;
    }

    public double getCreditos() {
        return creditos;
    }

    // Métodos para adicionar e visualizar histórico de prateleiras
    public void adicionarPrateleira(String categoria, ArrayList<Livro> livros) {
        historicoPrateleiras.put(categoria, livros);
    }

    public HashMap<String, ArrayList<Livro>> getHistoricoPrateleiras() {
        return historicoPrateleiras;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
} 
