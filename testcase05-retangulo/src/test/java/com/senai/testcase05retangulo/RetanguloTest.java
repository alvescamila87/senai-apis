package com.senai.testcase05retangulo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class RetanguloTest {

	@Test
	void calcular_area_triangulo_ok() {
		Retangulo retangulo = new Retangulo(15.7, 10.5);
		//Double resultado = retangulo.calcularArea(15.7, 10.5);
		Double resultado = retangulo.calcularArea(15.7, 10.5);
		assertEquals(164.85, resultado, 0.1);
	}

	@Test
	void calcular_area_triangulo_negativo() {
		Retangulo retangulo = new Retangulo();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			retangulo.calcularArea(-2.20, -3.70);
		});

		assertEquals("Valor inválido", exception.getMessage());
	}

	@Test
	void calcular_perimetro_triangulo_ok() {
		Retangulo retangulo = new Retangulo();
		Double resultado = retangulo.calcularPerimetro(3.75, 7.25);
		assertEquals(22, resultado, 0.1);
	}

	@Test
	void calcular_perimetro_triangulo_negativo() {
		Retangulo retangulo = new Retangulo(-2.20, -3.70);
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			retangulo.calcularPerimetro(retangulo);
		});

		assertEquals("Valor inválido", exception.getMessage());
	}
}
