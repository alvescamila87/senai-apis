import org.junit.jupiter.api.Test;
import org.senai.Conta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaTest {

    @Test
    public void test_when_sacar_negativo() {
        Conta conta = new Conta();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(-500.00);
        });
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    public void test_when_sacar_valor_maior() {
        Conta conta = new Conta();
        conta.depositar(1000.00);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(1002.00);
        });
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    public void test_when_sacar_ok() {
        Conta conta = new Conta();
        conta.depositar(1000.00);
        conta.sacar(450.00);
        assertEquals(550.00, conta.getSaldo());
    }

    @Test
    public void test_when_depositar_negativo() {
        Conta conta = new Conta();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.depositar(-500.00);
        });
        assertEquals("Valor negativo não permitido", exception.getMessage());
    }


    @Test
    public void test_when_depositar_ok() {
        Conta conta = new Conta();
        conta.depositar(1000.00);
        assertEquals(1000.00, conta.getSaldo());
    }

    @Test
    public void test_when_transferir_negativo() {
        Conta conta1 = new Conta();
        conta1.depositar(1000.00);

        Conta conta2 = new Conta();
        conta2.setTitular("Camila");
        conta2.getSaldo();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta1.transferir(conta2, -50.00);
        });
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    public void test_when_transferir_valor_maior() {
        Conta conta1 = new Conta();
        conta1.depositar(1000.00);

        Conta conta2 = new Conta();
        conta2.setTitular("Camila");
        conta2.getSaldo();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta1.transferir(conta2, 1050.00);
        });
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    public void test_when_transferir_ok() {
        Conta conta1 = new Conta();
        conta1.depositar(1000.00);

        Conta conta2 = new Conta();
        conta2.setTitular("Camila");
        conta2.getSaldo();

        conta1.transferir(conta2, 350.00);

        assertEquals(650.00, conta1.getSaldo());
        assertEquals(350.00, conta2.getSaldo());

    }

    @Test
    public void test_when_conta_titular_null() {
        Conta conta1 = new Conta();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta1.setTitular(null);
        });
        assertEquals("O nome não pode ser vazio ou nulo", exception.getMessage());
    }

    @Test
    public void test_when_conta_titular_string_vazia() {
        Conta conta1 = new Conta();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta1.setTitular("");
        });
        assertEquals("O nome não pode ser vazio ou nulo", exception.getMessage());
    }

}
