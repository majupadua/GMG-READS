import org.junit.Test;
import static org.junit.Assert.*;

import com.gmg.model.Livro;

public class LivroTest {

    @Test
    public void testGetTitulo() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        assertEquals("Dom Casmurro", livro.getTitulo());
    }

    @Test
    public void testGetAutor() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        assertEquals("Machado de Assis", livro.getAutor());
    }

    @Test
    public void testGetPreco() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        assertEquals(29.90, livro.getPreco(), 0.001);
    }

    @Test
    public void testGetEstoque() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        assertEquals(10, livro.getEstoque());
    }

    @Test
    public void testSetEstoque() {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        livro.setEstoque(15);
        assertEquals(15, livro.getEstoque());
    }
}
