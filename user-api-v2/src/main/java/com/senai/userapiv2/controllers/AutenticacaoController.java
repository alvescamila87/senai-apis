package com.senai.userapiv2.controllers;

import com.senai.userapiv2.dtos.AutenticacaoDTO;
import com.senai.userapiv2.dtos.MensagemDTO;
import com.senai.userapiv2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<MensagemDTO> autenticarUsuario(@RequestBody AutenticacaoDTO autenticacaoDTO) {
        MensagemDTO mensagemDTO = service.autenticarUsuario(autenticacaoDTO);

        if(mensagemDTO.getSucesso()) {
            return ResponseEntity.status(201).body(mensagemDTO);
        }
        return ResponseEntity.status(401).body(mensagemDTO);
    }

    @PostMapping("/login2")
    public ResponseEntity<MensagemDTO> autenticarUsuario2(@RequestBody AutenticacaoDTO autenticacaoDTO) {
        MensagemDTO mensagemDTO = service.autenticarUsuario2(autenticacaoDTO);

        if(mensagemDTO.getSucesso()) {
            return ResponseEntity.status(201).body(mensagemDTO);
        }
        return ResponseEntity.status(401).body(mensagemDTO);
    }

    @GetMapping
    public String obterLogin() {
        return "login";
    }
}
