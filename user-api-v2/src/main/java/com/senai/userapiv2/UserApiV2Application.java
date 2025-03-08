package com.senai.userapiv2;

import com.senai.userapiv2.models.UsuarioModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiV2Application {

	public static void main(String[] args) {
		SpringApplication.run(UserApiV2Application.class, args);

		UsuarioModel usuarioModel = new UsuarioModel(1L,"Camila", "alves", "123");
		System.out.println(usuarioModel.getId());
		System.out.println(usuarioModel.getNome());
		System.out.println(usuarioModel.getLogin());
		System.out.println(usuarioModel.getSenha());
	}

}
