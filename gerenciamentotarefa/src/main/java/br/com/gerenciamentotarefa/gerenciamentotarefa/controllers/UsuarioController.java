package br.com.gerenciamentotarefa.gerenciamentotarefa.controllers;

import br.com.gerenciamentotarefa.gerenciamentotarefa.dtos.UsuarioDTO;
import br.com.gerenciamentotarefa.gerenciamentotarefa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/usuariocadastro")
    public String obterUsuario(Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        model.addAttribute("usuarioDTO", usuarioDTO);

        return "usuariocadastro";
    }

    @PostMapping("/usuario")
    public String adicionar(Model model, @ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO) {
        service.adicionarUsuario(usuarioDTO);
        return "redirect:/usuariocadastro";
    }
}
