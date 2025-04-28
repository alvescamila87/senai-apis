package com.senai.userapiv2.controllers.usuario;

import com.senai.userapiv2.dtos.common.MensagemDTO;
import com.senai.userapiv2.dtos.usuario.RequisicaoDTO;
import com.senai.userapiv2.dtos.usuario.ResponseDTO;
import com.senai.userapiv2.dtos.usuario.UsuarioCadastroDTO;
import com.senai.userapiv2.dtos.usuario.UsuarioDTO;
import com.senai.userapiv2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemDTO> deletarUsuario(@PathVariable Long id) {
        MensagemDTO mensagemDTO = service.deletarUsuario(id);

        if(mensagemDTO.getSucesso()) {
            return ResponseEntity.ok().body(mensagemDTO);
        }
        return ResponseEntity.status(404).body(mensagemDTO);
    }

    @PostMapping("/usuario2")
    public ResponseEntity<ResponseDTO> adicionarUsuario2(@RequestBody RequisicaoDTO requisicaoDTO) {
        ResponseDTO responseDTO = service.adicionarUsuario2(requisicaoDTO);

        return ResponseEntity.ok().body(responseDTO);
    }

    @PostMapping("/usuario2/{id}")
    public String atualizarUsuario2(@PathVariable Long id, @ModelAttribute("updateUserDTO") UsuarioCadastroDTO usuarioCadastroDTO) {

        Boolean retorno = service.atualizarUsuario2(id, usuarioCadastroDTO);

        if(retorno) {
            return "redirect:/userlist";
        }

        return "redirect:/updateuser/" + id.toString() + "?error";
    }
}
