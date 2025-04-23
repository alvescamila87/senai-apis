import org.junit.jupiter.api.Test;
import org.senai.Livro;

import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    @Test
    void quando_tituloEmBranco() {
        Livro livro = new Livro();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            livro.setTitulo("");
        });

        assertEquals("Valor inválido", e.getMessage());
    }

    @Test
    void quando_livroJaEstiverEmprestado() {
        Livro livro01 = new Livro();
        livro01.setEmprestado(true);


        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            livro01.emprestarLivro();
        });

        assertEquals("Livro não disponível", e.getMessage());

    }
}
