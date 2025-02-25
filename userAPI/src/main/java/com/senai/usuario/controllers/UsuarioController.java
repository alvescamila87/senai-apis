package com.senai.usuario.controllers;

import com.senai.usuario.dtos.UsuarioDTO;
import com.senai.usuario.models.UsuarioModel;
import com.senai.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioModel> createUser(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioModel newUser = service.createUser(usuarioDTO);

        return ResponseEntity.ok().body(newUser);
    }
}
