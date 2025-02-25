package com.senai.usuario;

import com.senai.usuario.models.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class UsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);

		ArrayList<Car> cars = new ArrayList<>();

		Car ferrari = new Car("Ferrari 360 Spider");
		Car bugatti = new Car("Bugatti Veyron");
		Car lambo = new Car("Lamborghini Diablo");
		Car ford = new Car("Ford Mondeo");

		cars.add(ferrari);
		cars.add(bugatti);
		cars.add(lambo);
		cars.add(1, ford);

		System.out.println("Lista de carros: ");
		for(Car car : cars) {
			System.out.println(car);
		}



	}

}
