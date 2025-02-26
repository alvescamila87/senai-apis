package com.senai.usuario.controllers;

import com.senai.usuario.dtos.UsuarioDTO;
import com.senai.usuario.models.UsuarioModel;
import com.senai.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

//    @PostMapping
//    public ResponseEntity<UsuarioModel> createUser(@RequestBody UsuarioDTO usuarioRequestDTO) {
//        UsuarioModel newUser = service.createUser(usuarioRequestDTO);
//
//        return ResponseEntity.ok().body(newUser);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UsuarioModel>> userList() {
//        return ResponseEntity.ok().body(service.listaUsuarios());
//    }
}
