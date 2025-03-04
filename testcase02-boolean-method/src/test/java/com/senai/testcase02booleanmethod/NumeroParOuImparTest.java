package com.senai.testcase02booleanmethod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumeroParOuImparTest {

	@Test
	void checkPar_ok() {
		NumeroParOuImpar n = new NumeroParOuImpar();
		//assertEquals(true, n.verificaNumero(4));
		assertTrue(n.verificaNumero(4));
	}

	@Test
	void checkImpar_ok() {
		NumeroParOuImpar n = new NumeroParOuImpar();
		//assertEquals(false, n.verificaNumero(3));
		assertFalse(n.verificaNumero(3));
	}

}
