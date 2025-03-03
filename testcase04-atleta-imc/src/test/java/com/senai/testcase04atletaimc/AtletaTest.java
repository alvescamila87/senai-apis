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
		assertThrows(IllegalArgumentException.class, () -> {
			atleta.classificarCategoria(3);
		});
	}

	@Test
	void when_classificar_categoria_exception_idade_inexsistente() {
		Atleta atleta = new Atleta();
		assertThrows(IllegalArgumentException.class, () -> {
			atleta.classificarCategoria(-1);
		});
	}

}
