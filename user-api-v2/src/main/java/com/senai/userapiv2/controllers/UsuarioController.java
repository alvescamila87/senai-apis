package com.senai.userapiv2.controllers;

import com.senai.userapiv2.dtos.MensagemDTO;
import com.senai.userapiv2.dtos.RequisicaoDTO;
import com.senai.userapiv2.dtos.ResponseDTO;
import com.senai.userapiv2.dtos.UsuarioDTO;
import com.senai.userapiv2.services.UsuarioService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/crud")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("/usuario")
    public ResponseEntity<MensagemDTO> adicionarUsuario(@RequestBody RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = service.adicionarUsuario(requisicaoDTO);

        if(mensagemDTO.getSucesso()) {
            return ResponseEntity.status(201).body(mensagemDTO);
        }
        return ResponseEntity.badRequest().body(mensagemDTO);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> listaUsuarios = service.listarUsuarios();

        return ResponseEntity.ok().body(listaUsuarios);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<ResponseDTO> buscarUsuarioPorId(@PathVariable Long id){
        ResponseDTO responseDTO = service.buscarUsuarioPorId(id);

        return ResponseEntity.ok().body(responseDTO);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<MensagemDTO> atualizarUsuario(@PathVariable Long id, @RequestBody RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = service.atualizarUsuario(id, requisicaoDTO);

        if(mensagemDTO.getSucesso()) {
            return ResponseEntity.ok().body(mensagemDTO);
        }
        return  ResponseEntity.status(404).body(mensagemDTO);
    }


}
