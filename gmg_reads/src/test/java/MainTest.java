import com.gmg.Main;
// import com.gmg.model.Livro;

import org.junit.Test;

// import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testLerBancoDeDados() {
        Main.lerBancoDeDados();
        assertFalse(Main.livros.isEmpty());
    }

    @Test
    public void testExibirBancoDeDados() {
        Main.lerBancoDeDados();
        assertNotNull(Main.livros);
        assertTrue(Main.livros.size() > 0);
    }

    // Similar tests for other methods

    // @Test
    // public void testProcurarLivro() {
    //     Main.lerBancoDeDados();
    //     Livro livroEncontrado = Main.procurarLivro("x");
    //     assertNotNull(livroEncontrado);
    //     assertEquals("x", livroEncontrado.getTitulo());
    // }

}
