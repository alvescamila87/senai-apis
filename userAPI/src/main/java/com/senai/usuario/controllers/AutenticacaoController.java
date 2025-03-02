package com.senai.usuario.controllers;

import com.senai.usuario.dtos.AutenticacaoDTO;
import com.senai.usuario.dtos.MensagemDTO;
import com.senai.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<MensagemDTO> userAuthentication(@RequestBody AutenticacaoDTO autenticacaoDTO) {
        MensagemDTO mensagemDTO = service.autenticarUsuario(autenticacaoDTO);

        if(mensagemDTO.isStatusSucesso()) {
            return ResponseEntity.ok().body(mensagemDTO);
        }
        return ResponseEntity.status(404).body(mensagemDTO);
    }
}
