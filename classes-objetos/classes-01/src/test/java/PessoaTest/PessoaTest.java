package PessoaTest;

import org.junit.jupiter.api.Test;
import org.senai.pessoa.Pessoa;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PessoaTest {

    static final String NOME = "JOÃO";
    static final char SEXO = 'M';
    static final LocalDate DATA_NASCIMENTO = LocalDate.of(1962, 2, 14);
    static final String ESTADO_CIVIL = "Solteiro";

    /*
    // Usando o formato ISO 8601 (YYYY-MM-DD):
    static final LocalDate DATA_NASCIMENTO_ISO = LocalDate.parse("1986-02-14");

    // Se a sua string estiver em outro formato, use DateTimeFormatter:
    static final String DATA_NASCIMENTO_STRING = "14/02/1986";
    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final LocalDate DATA_NASCIMENTO = LocalDate.parse(DATA_NASCIMENTO_STRING, FORMATTER);
     */

    @Test
    public void when_pessoaCadastrada() {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(NOME);
        pessoa.setSexo(SEXO);
        pessoa.setDataNascimento(DATA_NASCIMENTO);
        pessoa.setEstadoCivil(ESTADO_CIVIL);

        assertEquals(NOME, pessoa.getNome());
        assertEquals(SEXO, pessoa.getSexo());
        assertEquals(DATA_NASCIMENTO, pessoa.getDataNascimento());
        assertEquals(ESTADO_CIVIL, pessoa.getEstadoCivil());

    }

    @Test
    void when_PessoaNomeIsNull() {
        Pessoa pessoa = new Pessoa();

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            pessoa.setNome(null);
        });
        assertEquals("Valor nulo", exception.getMessage());

    }

    @Test
    void when_PessoaNomeIsEmpty() {
        Pessoa pessoa = new Pessoa();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pessoa.setNome("");
        });

        assertEquals("Valor inválido", exception.getMessage());
    }

    @Test
    void when_PessoaNomeIsBlank() {
        Pessoa pessoa = new Pessoa();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pessoa.setNome("       ");
        });

        assertEquals("Valor inválido", exception.getMessage());
    }

    @Test
    void when_PessoaSexoIsNull() {
        Pessoa pessoa = new Pessoa();

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            pessoa.setSexo(null);
        });
        assertEquals("Valor nulo", exception.getMessage());

    }

    @Test
    void when_PessoaSexoIsEmpty() {
        Pessoa pessoa = new Pessoa();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pessoa.setSexo('1');
        });

        assertEquals("Valor inválido", exception.getMessage());
    }

    @Test
    void when_PessoaSexoIsBlank() {
        Pessoa pessoa = new Pessoa();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pessoa.setSexo(' ');
        });

        assertEquals("Valor inválido", exception.getMessage());

        IllegalArgumentException tabEexception = assertThrows(IllegalArgumentException.class, () -> {
            pessoa.setSexo('\t');
        });

        assertEquals("Valor inválido", tabEexception.getMessage());
    }

    @Test
    void when_PessoaDataNascimentoIsNull() {
        Pessoa pessoa = new Pessoa();

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            pessoa.setDataNascimento(null);
        });
        assertEquals("Valor nulo", exception.getMessage());

    }

    @Test
    void when_PessoaDataNascimentoIsAfterFromNow() {
        Pessoa pessoa = new Pessoa();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pessoa.setDataNascimento(LocalDate.of(2026, 12,13));
        });

        assertEquals("A data de nascimento não pode ser no futuro.", exception.getMessage());
    }

    @Test
    void when_PessoaEstadoCivilIsNull() {
        Pessoa pessoa = new Pessoa();

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            pessoa.setEstadoCivil(null);
        });
        assertEquals("Valor nulo", exception.getMessage());

    }

    @Test
    void when_PessoaEstadoCivilIsEmpty() {
        Pessoa pessoa = new Pessoa();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pessoa.setEstadoCivil("");
        });

        assertEquals("Valor inválido", exception.getMessage());
    }

    @Test
    void when_PessoaEstadoCivilIsBlank() {
        Pessoa pessoa = new Pessoa();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pessoa.setEstadoCivil("       ");
        });

        assertEquals("Valor inválido", exception.getMessage());
    }

}
