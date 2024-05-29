
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.gmg.model.Carrinho;
import com.gmg.model.Livro;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class CarrinhoTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Carrinho carrinho;

    @Before
    public void setUp() {
        carrinho = new Carrinho();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAtualizarEstoque() {
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        Livro livro2 = new Livro("Harry Potter", "J.K. Rowling", 35.50, 5);
        carrinho.adicionarLivroCarrinho(livro1);
        carrinho.adicionarLivroCarrinho(livro2);
        carrinho.atualizarEstoque();
        assertEquals(9, livro1.getEstoque());
        assertEquals(4, livro2.getEstoque());
    }

    @Test
    public void testTotalCarrinho() {
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        Livro livro2 = new Livro("Harry Potter", "J.K. Rowling", 35.50, 5);
        carrinho.adicionarLivroCarrinho(livro1);
        carrinho.adicionarLivroCarrinho(livro2);
        double expectedTotal = 29.90 + 35.50;
        assertEquals(expectedTotal, carrinho.totalCarrinho(), 0.001);
    }

    @Test
    public void testAdicionarLivroCarrinho() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        carrinho.adicionarLivroCarrinho(livro);
        assertEquals(1, carrinho.getLivros().size());
        assertEquals(livro, carrinho.getLivros().get(0));
    }

    @Test
    public void testGetLivros() {
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        Livro livro2 = new Livro("Harry Potter", "J.K. Rowling", 35.50, 5);
        carrinho.adicionarLivroCarrinho(livro1);
        carrinho.adicionarLivroCarrinho(livro2);
        assertEquals(2, carrinho.getLivros().size());
        assertEquals(livro1, carrinho.getLivros().get(0));
        assertEquals(livro2, carrinho.getLivros().get(1));
    }

    // Restaurar System.out para o estado original após os testes
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
