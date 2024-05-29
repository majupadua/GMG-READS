import com.gmg.model.Livro;
import com.gmg.model.Pedido;
import com.gmg.model.Cliente;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

public class ClienteTest {

    private Cliente cliente;
    private Pedido pedido1;
    private Pedido pedido2;
    private Livro livro1;
    private Livro livro2;

    @Before
    public void setUp() {
        cliente = new Cliente("João");
        pedido1 = new Pedido();
        pedido2 = new Pedido();
        livro1 = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        livro2 = new Livro("Harry Potter", "J.K. Rowling", 35.50, 5);
    }

    @Test
    public void testAdicionarPedido() {
        cliente.adicionarPedido(pedido1);
        cliente.adicionarPedido(pedido2);
        ArrayList<Pedido> historicoPedidos = cliente.getHistoricoPedidos();
        assertTrue(historicoPedidos.contains(pedido1));
        assertTrue(historicoPedidos.contains(pedido2));
        assertEquals(2, historicoPedidos.size());
    }

    @Test
    public void testAdicionarCreditos() {
        cliente.adicionarCreditos(50.0);
        cliente.adicionarCreditos(25.0);
        assertEquals(75.0, cliente.getCreditos(), 0.001);
    }

    @Test
    public void testAdicionarPrateleira() {
        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        livros.add(livro2);
        cliente.adicionarPrateleira("Favoritos", livros);
        HashMap<String, ArrayList<Livro>> historicoPrateleiras = cliente.getHistoricoPrateleiras();
        assertTrue(historicoPrateleiras.containsKey("Favoritos"));
        assertTrue(historicoPrateleiras.get("Favoritos").contains(livro1));
        assertTrue(historicoPrateleiras.get("Favoritos").contains(livro2));
    }

    @Test
    public void testGetHistoricoPedidos() {
        cliente.adicionarPedido(pedido1);
        cliente.adicionarPedido(pedido2);
        ArrayList<Pedido> historicoPedidos = cliente.getHistoricoPedidos();
        assertEquals(2, historicoPedidos.size());
        assertTrue(historicoPedidos.contains(pedido1));
        assertTrue(historicoPedidos.contains(pedido2));
    }

    @Test
    public void testGetCreditos() {
        cliente.adicionarCreditos(100.0);
        assertEquals(100.0, cliente.getCreditos(), 0.001);
    }

    @Test
    public void testGetHistoricoPrateleiras() {
        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        cliente.adicionarPrateleira("Lidos", livros);
        HashMap<String, ArrayList<Livro>> historicoPrateleiras = cliente.getHistoricoPrateleiras();
        assertTrue(historicoPrateleiras.containsKey("Lidos"));
        assertTrue(historicoPrateleiras.get("Lidos").contains(livro1));
    }

    @Test
    public void testGetNome() {
        assertEquals("João", cliente.getNome());
    }

    @Test
    public void testSetNome() {
        cliente.setNome("Maria");
        assertEquals("Maria", cliente.getNome());
    }
}
