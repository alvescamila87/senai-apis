import org.junit.jupiter.api.Test;
import org.senai.Livro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LivroTest {

    @Test
    void quando_tituloEmBranco() {
        Livro livro = new Livro();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            livro.setTitulo("");
        });

        assertEquals("Valor inválido", e.getMessage());
    }
}
