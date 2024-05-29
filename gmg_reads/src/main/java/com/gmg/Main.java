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

    // Método para ler arquivo binário do banco de dados
    public static void lerBancoDeDados() {
        Livro livro1 = new Livro("x", "Machado de Assis", 29.90, 10);
        Livro livro2 = new Livro("y", "J.R.R. Tolkien", 49.99, 15);
        Livro livro3 = new Livro("z", "J.K. Rowling", 39.90, 20);

        // Adicionando os livros ao banco de dados
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);    
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

    // Método para adicionar o livro à estante
    public static void adicionarLivroAEstante(Livro livro) {
        System.out.println("Escolha a estante para adicionar o livro:");
        System.out.println("1. Lidos");
        System.out.println("2. Lendo");
        System.out.println("3. Quero Ler");
        System.out.print("Escolha uma estante: ");
        int escolhaEstante = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        String categoria;
        switch (escolhaEstante) {
            case 1:
                categoria = "Lidos";
                break;
            case 2:
                categoria = "Lendo";
                break;
            case 3:
                categoria = "Quero Ler";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        estante.adicionarLivro(categoria, livro);
        System.out.println("Livro adicionado à estante com sucesso na categoria: " + categoria);
    }

    // Método para visualizar os livros na estante
    public static void visualizarLivrosNaEstante() {
        System.out.println("Escolha a estante para visualizar os livros:");
        System.out.println("1. Lidos");
        System.out.println("2. Lendo");
        System.out.println("3. Quero Ler");
        System.out.print("Escolha uma estante: ");
        int escolhaEstante = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        String categoria;
        switch (escolhaEstante) {
            case 1:
                categoria = "Lidos";
                break;
            case 2:
                categoria = "Lendo";
                break;
            case 3:
                categoria = "Quero Ler";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

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

    // Método para realizar um pedido
    public static void realizarPedido() {
        System.out.print("Digite o título do livro que deseja procurar: ");
        String titulo = scanner.nextLine();

        Livro livroEncontrado = procurarLivro(titulo);
        if (livroEncontrado != null) {
            exibirDetalhesLivro(livroEncontrado);
            System.out.print("Deseja adicionar este livro ao carrinho? (S/N): ");
            String escolha = scanner.nextLine();
            if (escolha.equalsIgnoreCase("S")) {
                carrinho.adicionarLivroCarrinho(livroEncontrado); // Adicionando o livro ao carrinho
            }
        } else {
            System.out.println("Livro não encontrado no banco de dados.");
        }
    }

    // Método para finalizar o pedido
    public static void finalizarPedido() {
        if (carrinho.getLivros().isEmpty()) {
            System.out.println("Não é possível finalizar um pedido sem itens no carrinho.");
            return;
        }

        Pedido pedido = new Pedido();
        pedido.adicionarCarrinhoFinalizado(carrinho);
        pedidos.add(pedido);

        System.out.println("Pedido finalizado com sucesso!");
        carrinho.atualizarEstoque();
        carrinho = new Carrinho();

        metodoPagamento(); // Chamar o método de pagamento após finalizar o pedido
    }

    // Método para visualizar os pedidos passados
    public static void visualizarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido passado encontrado.");
        } else {
            System.out.println("\nPedidos Passados:");
            for (Pedido pedido : pedidos) {
                System.out.println("ID do Pedido: " + pedido.getId());
                System.out.println("Preço Total: " + pedido.getPrecoTotal());
                System.out.println("Status: " + pedido.getStatus());
                System.out.println("Livros Comprados:");
                for (Livro livro : pedido.getLivrosComprados()) {
                    System.out.println(" - " + livro.getTitulo());
                }
                System.out.println();
            }
        }
    }

    // Método para cancelar um pedido em andamento
    public static void cancelarPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido feito.");
            return;
        }
    
        visualizarPedidos();
    
        System.out.print("Digite o ID do pedido que deseja cancelar: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
    
        System.out.print("Digite o nome do livro que deseja cancelar: ");
        String nomeLivro = scanner.nextLine();
    
        Pedido pedidoCancelado = null;
        Livro livroCancelado = null;
    
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idPedido && pedido.getStatus().equalsIgnoreCase("Em andamento")) {
                pedidoCancelado = pedido;
                for (Livro livro : pedido.getLivrosComprados()) {
                    if (livro.getTitulo().equalsIgnoreCase(nomeLivro)) {
                        livroCancelado = livro;
                        break;
                    }
                }
                break;
            }
        }
    
        if (pedidoCancelado != null && livroCancelado != null) {
            double valorCredito = livroCancelado.getPreco();
            livroCancelado.setEstoque(livroCancelado.getEstoque() + 1); // Incrementar estoque do livro cancelado
            cliente.adicionarCreditos(valorCredito);
            pedidoCancelado.getLivrosComprados().remove(livroCancelado); // Remover livro do pedido
            pedidoCancelado.setPrecoTotal(pedidoCancelado.getPrecoTotal() - valorCredito); // Atualizar preço total do pedido
    
            // Verificar se o pedido ficou vazio após o cancelamento do livro
            if (pedidoCancelado.getLivrosComprados().isEmpty()) {
                pedidos.remove(pedidoCancelado);
            }
    
            System.out.println("Livro \"" + nomeLivro + "\" do pedido com ID " + idPedido + " cancelado com sucesso!");
            System.out.println("Você recebeu " + valorCredito + " créditos por este cancelamento.");
        } else {
            System.out.println("Pedido não encontrado, não está em andamento ou livro não encontrado no pedido.");
        }
    }
    
    public static void visualizarCreditos() {
        System.out.println("Créditos acumulados: " + cliente.getCreditos());
    }

    // Método para o método de pagamento
    public static void metodoPagamento() {
        Pedido ultimoPedido = pedidos.get(pedidos.size() - 1);
        double total = ultimoPedido.getPrecoTotal();
        double creditosDisponiveis = ultimoPedido.getCreditosAcumulados(); // Usando créditos acumulados

        System.out.println("Total do pedido: " + total);
        System.out.println("Créditos disponíveis: " + creditosDisponiveis);

        if (creditosDisponiveis > 0) {
            System.out.print("Deseja utilizar seus créditos? (S/N): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                if (creditosDisponiveis >= total) {
                    System.out.println("Pedido pago com créditos.");
                    creditosDisponiveis -= total;
                    total = 0;
                    ultimoPedido.setCreditosAcumulados(creditosDisponiveis);
                } else {
                    System.out.println("Valor dos créditos aplicado ao total do pedido.");
                    total -= creditosDisponiveis;
                    ultimoPedido.setCreditosAcumulados(0);

                }
            }
        }

        while (total > 0) {
            if (creditosDisponiveis != 0)
                System.out.println("Restante a pagar: " + total);
            System.out.println("Escolha o método de pagamento:");
            System.out.println("1. Cartão de Crédito");
            System.out.println("2. Cartão de Débito");
            System.out.println("3. PIX");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (escolha) {
                case 1:
                    System.out.println(
                    "Pagamento com Cartão de Crédito aprovado. Mandamos um email com as informações do pedido.");
                    total = 0;
                    break;
                case 2:
                    System.out.println(
                    "Pagamento com Cartão de Débito aprovado. Mandamos um email com as informações do pedido.");
                    total = 0;
                    break;
                case 3:
                    System.out.println("Pagamento com PIX aprovado. Mandamos um email com as informações do pedido.");
                    total = 0;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha um método de pagamento válido.");
            }
        }
    }

}