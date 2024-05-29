import com.gmg.model.Livro;
import com.gmg.model.Pedido;
import com.gmg.model.Carrinho;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PedidoTest {

    private Pedido pedido;
    private Livro livro1;
    private Livro livro2;
    private Carrinho carrinho;

    @Before
    public void setUp() {
        pedido = new Pedido();
        livro1 = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        livro2 = new Livro("Harry Potter", "J.K. Rowling", 35.50, 5);
        carrinho = new Carrinho();
        carrinho.adicionarLivroCarrinho(livro1);
        carrinho.adicionarLivroCarrinho(livro2);
    }

    @Test
    public void testAdicionarCarrinhoFinalizado() {
        pedido.adicionarCarrinhoFinalizado(carrinho);
        ArrayList<Livro> livrosComprados = pedido.getLivrosComprados();
        assertEquals(2, livrosComprados.size());
        assertTrue(livrosComprados.contains(livro1));
        assertTrue(livrosComprados.contains(livro2));
        assertEquals(65.40, pedido.getPrecoTotal(), 0.001);
    }

    @Test
    public void testDevolverEstoque() {
        pedido.adicionarCarrinhoFinalizado(carrinho);
        pedido.devolverEstoque();
        assertEquals(11, livro1.getEstoque());
        assertEquals(6, livro2.getEstoque());
    }

    @Test
    public void testCalcularPrecoTotal() {
        pedido.adicionarCarrinhoFinalizado(carrinho);
        assertEquals(65.40, pedido.getPrecoTotal(), 0.001);
        pedido.setCreditos(20.0);
        pedido.adicionarCarrinhoFinalizado(new Carrinho()); // Recalcular o preço total após definir os créditos
        assertEquals(45.40, pedido.getPrecoTotal(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        pedido.setCreditos(15.0);
        pedido.setCreditosAcumulados(30.0);
        assertEquals(15.0, pedido.getCreditos(), 0.001);
        assertEquals(30.0, pedido.getCreditosAcumulados(), 0.001);
        pedido.setStatus("Finalizado");
        assertEquals("Finalizado", pedido.getStatus());
        ArrayList<Carrinho> carrinhos = new ArrayList<>();
        Carrinho carrinho = new Carrinho();
        carrinhos.add(carrinho);
        pedido.setCarrinhosFinalizados(carrinhos);
        assertEquals(carrinhos, pedido.getCarrinhosFinalizados());
    }

    // @Test
    // public void testGetId() {
    //     int id = pedido.getId();
    //     assertEquals(3, id);
    // }

    // @Test
    // public void testMultiplePedidosUniqueIds() {
    //     Pedido pedido2 = new Pedido();
    //     Pedido pedido3 = new Pedido();
    //     assertEquals(7, pedido2.getId());
    //     assertEquals(8, pedido3.getId());
    // }

    @Test
    public void testSetPrecoTotal() {
        pedido.setPrecoTotal(100.0);
        assertEquals(100.0, pedido.getPrecoTotal(), 0.001);
    }

    @Test
    public void testSetLivrosComprados() {
        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        livros.add(livro2);
        pedido.setLivrosComprados(livros);
        assertEquals(livros, pedido.getLivrosComprados());
    }
}
