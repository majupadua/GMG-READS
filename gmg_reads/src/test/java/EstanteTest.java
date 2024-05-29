import com.gmg.model.Livro;
import com.gmg.model.Estante;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EstanteTest {

    private Estante estante;
    private Livro livro1;
    private Livro livro2;

    @Before
    public void setUp() {
        estante = new Estante();
        livro1 = new Livro("Dom Casmurro", "Machado de Assis", 29.90, 10);
        livro2 = new Livro("Harry Potter", "J.K. Rowling", 35.50, 5);
    }

    @Test
    public void testAdicionarCategoria() {
        estante.adicionarCategoria("Favoritos");
        HashMap<String, ArrayList<Livro>> categorias = estante.getCategorias();
        assertTrue(categorias.containsKey("Favoritos"));
    }

    @Test
    public void testAdicionarLivro() {
        estante.adicionarLivro("Lidos", livro1);
        estante.adicionarLivro("Lendo", livro2);
    }

    @Test
    public void testAdicionarLivroCategoriaNaoExistente() {
        estante.adicionarLivro("Ficção", livro1);
        ArrayList<Livro> ficcao = estante.buscarLivrosNaCategoria("Ficção");
        assertEquals(0, ficcao.size());
    }

    @Test
    public void testBuscarLivrosNaCategoria() {
        estante.adicionarLivro("Lidos", livro1);
        estante.adicionarLivro("Lidos", livro2);
        ArrayList<Livro> lidos = estante.buscarLivrosNaCategoria("Lidos");
        assertEquals(0, lidos.size());
    }

    @Test
    public void testBuscarLivrosCategoriaNaoExistente() {
        ArrayList<Livro> naoExistente = estante.buscarLivrosNaCategoria("NaoExistente");
        assertEquals(0, naoExistente.size());
    }
}
