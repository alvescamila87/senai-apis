import org.junit.Test;
import org.senai.Calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TesteCalculadora {

    @Test
    public void testeSomaPositivo() {
        Calculadora calc = new Calculadora();
        int resultado = calc.soma(5,2);
        assertEquals(7, resultado);
    }

    @Test
    public void testeSomaNegativo() {
        Calculadora calc = new Calculadora();
        int resultado = calc.soma(-5, 2);
        assertEquals(-3, resultado);
    }


    @Test
    public void testeDivisaoOk() {
        Calculadora calc  = new Calculadora();
        double resultado = calc.divide(10, 3);
        assertEquals(3.3, resultado, 0.1);
    }

    @Test
    public void testeDivisaoNOk() {
        Calculadora calc = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(5, 0);
        });
    }

    @Test
    public void testeSubstracao() {
        Calculadora calc = new Calculadora();
        int resultado = calc.subtracao(10, 3);
        assertEquals(7, resultado);
    }

    @Test
    public void testeMultiplicacao() {
        Calculadora calc = new Calculadora();
        int resltado = calc.multiplica(5, 2);
        assertEquals(10, resltado);
    }
}
