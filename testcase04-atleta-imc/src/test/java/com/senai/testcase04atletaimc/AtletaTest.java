package com.senai.testcase04atletaimc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AtletaTest {

	@Test
	void when_classificar_categoria_ok() {
		Atleta atleta = new Atleta();
		assertEquals("Atleta pré-mirim", atleta.classificarCategoria(6));
		assertEquals("Atleta mirim", atleta.classificarCategoria(8));
		assertEquals("Atleta intantil", atleta.classificarCategoria(12));
		assertEquals("Atleta infanto-juvenil", atleta.classificarCategoria(15));
		assertEquals("Atleta juvenil", atleta.classificarCategoria(19));
		assertEquals("Atleta adulto", atleta.classificarCategoria(22));
	}

	@Test
	void when_classificar_categoria_exception_sem_classificacao() {
		Atleta atleta = new Atleta();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			atleta.classificarCategoria(3);
		});

		assertEquals("ERRO: Atleta sem idade para entrar na classificação", exception.getMessage());
	}

	@Test
	void when_classificar_categoria_exception_idade_inexsistente() {
		Atleta atleta = new Atleta();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			atleta.classificarCategoria(-1);
		});

		assertEquals("ERRO: Idade inexistente", exception.getMessage());
	}

	@Test
	void when_calcular_imc_ok() {
		Atleta atleta = new Atleta();
		assertEquals("IMC: Magreza", atleta.calcularIMC(23.0, 1.63)); // 8,65
		assertEquals("IMC: Saudável", atleta.calcularIMC(63.0, 1.63)); // 23,71
		assertEquals("IMC: Sobrepeso", atleta.calcularIMC(75.0, 1.63)); // 28,22
		assertEquals("IMC: Obesidade - Grau I", atleta.calcularIMC(85.0, 1.63)); // 31,99
		assertEquals("IMC: Obesidade - Grau II (severa)", atleta.calcularIMC(99.0, 1.63));  // 37,26
		assertEquals("IMC: Obesidade - Grau III (mórbida)", atleta.calcularIMC(115.0, 1.63)); // 43,28
	}

	@Test
	void when_calcular_imc_exception() {
		Atleta atleta = new Atleta();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			atleta.calcularIMC(-2.0, 1.0);
		});

		assertEquals("ERRO: IMC inexistente", exception.getMessage());
	}

}
