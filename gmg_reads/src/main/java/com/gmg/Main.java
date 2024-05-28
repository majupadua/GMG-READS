package com.gmg;

import java.util.ArrayList;
import java.util.Scanner;

import com.gmg.model.Livro;
import com.gmg.model.Cliente;
import com.gmg.model.Pedido;
import com.gmg.model.Estante;
import com.gmg.model.Carrinho;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Livro> livros = new ArrayList<>();
    public static Estante estante; // Instância da estante
    public static Cliente cliente; // Instância da estante
    public static Carrinho carrinho = new Carrinho(); // Instância do carrinho
    public static ArrayList<Pedido> pedidos = new ArrayList<>(); // Lista de pedidos

    public static void main(String[] args) {
        lerBancoDeDados();
        estante = new Estante();
        cliente = new Cliente("Gabriella");
        // Loop to continuously display the menu
        while (true) {
            exibirMenuPrincipal();
        }
    }

    // Método para exibir o menu principal
    public static void exibirMenuPrincipal() {
        System.out.println();
        System.out.println("Bem-vindo ao GMG READS!");
        System.out.println("1. Exibir banco de dados");
        System.out.println("2. Realizar Pedido");
        System.out.println("3. Visualizar Carrinho");
        System.out.println("4. Adicionar Livro na Estante");
        System.out.println("5. Visualizar Livros na Estante");
        System.out.println("6. Visualizar Pedidos");
        System.out.println("7. Cancelar Pedido");
        System.out.println("8. Visualizar créditos");
        System.out.println("9. Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                exibirBancoDeDados();
                break;
            case 2:
                realizarPedido();
                break;
            case 3:
                carrinho.listarLivrosNoCarrinho();
                System.out.println("Total: " + carrinho.totalCarrinho());
                System.out.print("Deseja finalizar o pedido (F) ou continuar comprando (C)? ");
                String escolha = scanner.nextLine();
                if (escolha.equalsIgnoreCase("F")) {
                    finalizarPedido();
                }
                break;
            case 4:
                adicionarLivroNaEstante();
                break;
            case 5:
                visualizarLivrosNaEstante();
                break;
            case 6:
                visualizarPedidos();
                break;
            case 7:
                cancelarPedido();
                break;
            case 8:
                visualizarCreditos();
                break;
            case 9:
                System.out.println("Obrigado por utilizar o GMG READS!");
                System.exit(0); // Encerrar o programa
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
    }

    // Método para ler banco de dados
    public static void lerBancoDeDados() {
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        Livro livro2 = new Livro("O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", 49.99, 15);
        Livro livro3 = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 39.90, 20);
        Livro livro4 = new Livro("1984", "George Orwell", 34.90, 12);
        Livro livro5 = new Livro("Cem Anos de Solidão", "Gabriel García Márquez", 44.90, 18);
        Livro livro6 = new Livro("O Alquimista", "Paulo Coelho", 29.90, 25);
        Livro livro7 = new Livro("A Culpa é das Estrelas", "John Green", 35.90, 30);
        Livro livro8 = new Livro("Orgulho e Preconceito", "Jane Austen", 27.90, 22);
        Livro livro9 = new Livro("O Hobbit", "J.R.R. Tolkien", 39.99, 14);
        Livro livro10 = new Livro("Moby Dick", "Herman Melville", 45.90, 8);
        Livro livro11 = new Livro("A Menina que Roubava Livros", "Markus Zusak", 37.90, 17);
        Livro livro12 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 19.90, 40);
        Livro livro13 = new Livro("O Nome da Rosa", "Umberto Eco", 49.90, 12);
        Livro livro14 = new Livro("A Divina Comédia", "Dante Alighieri", 54.90, 5);
        Livro livro15 = new Livro("A Guerra dos Tronos", "George R.R. Martin", 59.90, 10);


        // Adicionando os livros ao banco de dados
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);    
        livros.add(livro4); 
        livros.add(livro5); 
        livros.add(livro6); 
        livros.add(livro7); 
        livros.add(livro8); 
        livros.add(livro9); 
        livros.add(livro10); 
        livros.add(livro11); 
        livros.add(livro12); 
        livros.add(livro13); 
        livros.add(livro14); 
        livros.add(livro15); 
    }

    // Método para exibir o banco de dados completo
    public static void exibirBancoDeDados() {
        if (livros.isEmpty()) {
            System.out.println("O banco de dados está vazio. Por favor, leia o banco de dados primeiro.");
        } else {
            System.out.println("Banco de Dados:");
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Preço: " + livro.getPreco());
                System.out.println("Estoque: " + livro.getEstoque());
                System.out.println();
            }
        }
    }

    // Método para adicionar um livro à estante
    public static void adicionarLivroNaEstante() {
        if (livros.isEmpty()) {
            System.out.println("O banco de dados está vazio. Por favor, leia o banco de dados primeiro.");
            return;
        }

        System.out.print("Digite o título do livro que deseja procurar: ");
        String titulo = scanner.nextLine();

        Livro livroEncontrado = procurarLivro(titulo);
        if (livroEncontrado != null) {
            exibirDetalhesLivro(livroEncontrado);
            System.out.print("Deseja adicionar este livro à estante? (S/N): ");
            String escolha = scanner.nextLine();
            if (escolha.equalsIgnoreCase("S")) {
                adicionarLivroAEstante(livroEncontrado);
            }
        } else {
            System.out.println("Livro não encontrado no banco de dados.");
        }
    }

    // Método para procurar um livro na base de dados
    public static Livro procurarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    // Método para exibir detalhes do livro encontrado
    public static void exibirDetalhesLivro(Livro livro) {
        System.out.println("Detalhes do Livro:");
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Preço: " + livro.getPreco());
        System.out.println("Estoque: " + livro.getEstoque());
    }

    //Método para menu das estantes
    public static String menuEstante(){
        System.out.println("Escolha a estante para visualizar os livros:");
        System.out.println("1. Já Lidos");
        System.out.println("2. Leituras Atuais");
        System.out.println("3. Leituras Futuras");
        System.out.print("Escolha uma estante: ");
        int escolhaEstante = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        String categoria;
        switch (escolhaEstante) {
            case 1:
                categoria = "Já Lidos";
                return categoria;
            case 2:
                categoria = "Leituras Atuais";
                return categoria;
            case 3:
                categoria = "Leituras Futuras";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }
    }

    // Método para adicionar o livro à estante
    public static void adicionarLivroAEstante(Livro livro) {
        menuEstante();

        estante.adicionarLivro(categoria, livro);
        System.out.println("Livro adicionado à estante com sucesso na categoria: " + categoria);
    }

    // Método para visualizar os livros na estante
    public static void visualizarLivrosNaEstante() {
        menuEstante();

        ArrayList<Livro> livrosNaEstante = estante.buscarLivrosNaCategoria(categoria);
        if (!livrosNaEstante.isEmpty()) {
            System.out.println("Livros na estante '" + categoria + "':");
            for (Livro livro : livrosNaEstante) {
                System.out.println("- " + livro.getTitulo());
            }
        } else {
            System.out.println("Nenhum livro encontrado nesta estante.");
        }
    }

    

}