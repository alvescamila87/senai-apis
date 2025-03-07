package com.senai.user_database.controllers;

import com.senai.user_database.dtos.ConsultaUsuarioDTO;
import com.senai.user_database.dtos.MensagemDTO;
import com.senai.user_database.dtos.RequisicaoDTO;
import com.senai.user_database.dtos.RespostaDTO;
import com.senai.user_database.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
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

    /* Opção 1 e Opção 2
    @GetMapping("/usuarios")
    public ResponseEntity<List<ListaUsuarioDTO>> listarUsuarios() {
        List<Usuario> lista = service.listarUsuarios();
        List<ListaUsuarioDTO> listaUsuarioDTOS = ListaUsuarioDTO.converterDe(lista);

        return ResponseEntity.ok().body(listaUsuarioDTOS);
    }
    */

    /* Opção 3
    */
    @GetMapping("/usuarios")
    public ResponseEntity<List<ConsultaUsuarioDTO>> listarUsuarios() {
        List<ConsultaUsuarioDTO> listaUsuariosDTO = service.listarUsuarios();

        return ResponseEntity.ok().body(listaUsuariosDTO);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<RespostaDTO> buscarUsuarioPorId(@PathVariable Long id) {
        RespostaDTO respostaDTO = service.buscarUsuarioPorId(id);

        return ResponseEntity.ok().body(respostaDTO);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<MensagemDTO> atualizarUsuario(@PathVariable Long id, @RequestBody RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = service.atualizarUsuario(id, requisicaoDTO);

        if(mensagemDTO.getSucesso()) {
            return ResponseEntity.ok().body(mensagemDTO);
        }
        return ResponseEntity.status(404).body(mensagemDTO);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemDTO> deletarUsuario(@PathVariable Long id) {
        MensagemDTO mensagemDTO = service.deletarUsuario(id);

        if(mensagemDTO.getSucesso()) {
            return ResponseEntity.status(204).body(mensagemDTO);
        }

        return ResponseEntity.status(404).body(mensagemDTO);
    }
}
