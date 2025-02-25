import org.junit.Test;
import org.senai.Calculadora;

import static org.junit.Assert.assertEquals;

public class TesteCalculadora {

    @Test
    public void testeSoma() {
        Calculadora calc = new Calculadora();
        int resultado = calc.soma(5,2);
        assertEquals(7, resultado);
    }
}
