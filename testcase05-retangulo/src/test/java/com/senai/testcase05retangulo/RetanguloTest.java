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
		Double resultado = retangulo.calcularArea();
		assertEquals(164.85, resultado, 0.1);
	}

	@Test
	void calcular_area_triangulo_negativo() {
		Retangulo retangulo = new Retangulo(-2.20, -3.70);
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			retangulo.calcularArea();
		});

		assertEquals("Valores negativos inválidos.", exception.getMessage());
	}

	@Test
	void calcular_perimetro_triangulo_ok() {
		Retangulo retangulo = new Retangulo(3.75, 7.25);
		Double resultado = retangulo.calcularPerimetro();
		assertEquals(22, resultado, 0.1);
	}

	@Test
	void calcular_perimetro_triangulo_negativo() {
		Retangulo retangulo = new Retangulo(-2.20, -3.70);
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			retangulo.calcularPerimetro();
		});

		assertEquals("Valores negativos inválidos.", exception.getMessage());
	}

//	@Test
//	void verifica_maior_area() {
//		Retangulo retangulo = new Retangulo(15.3, 8.72);
//		retangulo.verificarMaiorArea();
//	}

	@Test
	void verificar_maior_area() {
		Retangulo retangulo1 = new Retangulo(15.7, 10.5);
		Retangulo retangulo2 = new Retangulo(29.75, 8.69);
		Retangulo retangulo3 = new Retangulo(13.03, 35.80);

		Retangulo maiorArea = Retangulo.maiorArea();

		assertEquals(retangulo3, maiorArea);

	}

	@Test
	void verifica_maior_perimetro() {
		Retangulo retangulo1 = new Retangulo(15.7, 10.5);
		Retangulo retangulo2 = new Retangulo(29.75, 8.69);
		Retangulo retangulo3 = new Retangulo(13.03, 35.80);

		Retangulo maiorPerimetro = Retangulo.maiorPerimetro();

		assertEquals(retangulo3, maiorPerimetro);
	}

	@Test
	void verificar_maior_area_lista_vazia() {
		Retangulo.listaRetangulos.clear();

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Retangulo.maiorArea();
		});

		assertEquals("Nenhum retângulo na lista", exception.getMessage());
	}
}
