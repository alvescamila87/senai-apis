package com.senai.testcase02booleanmethod;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ValidationNumberTest {

	@Test
	void checkPar_ok() {
		ValidationNumber validationNumber = new ValidationNumber();
		boolean result = validationNumber.checkNumber(2);
        assertTrue(result, "O número 2 é par, deve retornar true.");
	}


	@Test
	void checkImpar_ok() {
		ValidationNumber validationNumber = new ValidationNumber();
		boolean result = validationNumber.checkNumber(3);
        assertFalse(result, "O número 3 é ímpar, deve retornar false.");
	}

	@Test
	void check_zero_like_par() {
		ValidationNumber validationNumber = new ValidationNumber();
		boolean result = validationNumber.checkNumber(0);
		assertTrue(result, "O número 2 é par, deve retornar true.");
	}

}
