package com.senai.user_database.controllers;

import com.senai.user_database.dtos.ListaUsuarioDTO;
import com.senai.user_database.dtos.MensagemDTO;
import com.senai.user_database.dtos.RequisicaoDTO;
import com.senai.user_database.dtos.RespostaDTO;
import com.senai.user_database.models.Usuario;
import com.senai.user_database.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.ok().body(mensagemDTO);
        }
        return ResponseEntity.status(404).body(mensagemDTO);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<ListaUsuarioDTO>> listarUsuarios() {
        List<Usuario> lista = service.listarUsuarios();
        List<ListaUsuarioDTO> listaUsuarioDTOS = ListaUsuarioDTO.converterDe(lista);

        return ResponseEntity.ok().body(listaUsuarioDTOS);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<RespostaDTO> buscarUsuarioPorId(@PathVariable Long id) {
        RespostaDTO respostaDTO = service.buscarUsuarioPorId(id);

        return ResponseEntity.ok().body(respostaDTO);
    }
}
