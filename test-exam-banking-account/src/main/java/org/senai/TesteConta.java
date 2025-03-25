package org.senai;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteConta {

	@Test
	void testeSacar() {
		Conta c1 = new Conta("Jobson", 1000);
		c1.sacar(200);
		assertEquals(800, c1.getSaldo());
	}

	@Test
	void testeSacar2() {
		Conta c1 = new Conta("Jobson", 1000);

		assertThrows(IllegalArgumentException.class, () -> {
			c1.sacar(1100);
		});
	}

	@Test
	void testeDepositar() {
		Conta c1 = new Conta("Jobson", 1000);
		c1.depositar(200);
		assertEquals(1200, c1.getSaldo());
	}

	@Test
	void testeTransferir() {
		Conta c1 = new Conta("Jobson", 1000);
		Conta c2 = new Conta("Cleber", 1500);
		c1.transferir(c2, 200);
		assertEquals(800, c1.getSaldo());
	}

	@Test
	void testeTransferir2() {
		Conta c1 = new Conta("Jobson", 1000);
		Conta c2 = new Conta("Cleber", 1500);
		c1.transferir(c2, 200);
		assertEquals(1700, c2.getSaldo());
	}

	@Test
	void testeTransferir3() {
		Conta c1 = new Conta("Jobson", 1000);
		Conta c2 = new Conta("Cleber", 1500);
		assertThrows(IllegalArgumentException.class, () -> {
			c1.transferir(c2, 1100);
		});
	}

	@Test
	void testeNome() {
		Conta c1 = new Conta("Jobson", 1000);
		assertEquals("Jobson", c1.getNome());
	}

	@Test
	void testeNome2() {
		assertThrows(IllegalArgumentException.class, () -> {
			Conta c1 = new Conta("   ", 1000);
			;
		});
	}

}
