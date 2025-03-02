package com.senai.usuario.controllers;

import com.senai.usuario.dtos.ListaUsuariosDTO;
import com.senai.usuario.dtos.MensagemDTO;
import com.senai.usuario.dtos.RequisicaoDTO;
import com.senai.usuario.dtos.ResponseDTO;
import com.senai.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("usuario")
    public ResponseEntity<MensagemDTO> createUser(@RequestBody RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = service.adicionarUsuario(requisicaoDTO);

        if (mensagemDTO.isStatusSucesso()) {
            return ResponseEntity.ok().body(mensagemDTO);
        }
        return ResponseEntity.status(404).body(mensagemDTO);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<ResponseDTO> findUserById(@PathVariable Integer id) {
        ResponseDTO responseDTO = service.buscarUsuarioPorId(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<ListaUsuariosDTO>> findAllUsers() {
        List<ListaUsuariosDTO> listaUsuarios = service.listarUsuarios();

        return ResponseEntity.ok().body(listaUsuarios);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<MensagemDTO> updateUser(@PathVariable Integer id, @RequestBody RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = service.atualizarUsuario(id, requisicaoDTO);

        if(mensagemDTO.isStatusSucesso()) {
            return ResponseEntity.ok().body(mensagemDTO);
        }
        return ResponseEntity.status(404).body(mensagemDTO);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemDTO> deleteUser(@PathVariable Integer id) {
        MensagemDTO mensagemDTO = service.removerUsuarioPorId(id);

        if(mensagemDTO.isStatusSucesso()) {
            return ResponseEntity.ok().body(mensagemDTO);
        }

        return ResponseEntity.status(404).body(mensagemDTO);
    }
}
