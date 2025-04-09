package com.senai.userapiv2.controllers;

import com.senai.userapiv2.dtos.AutenticacaoDTO;
import com.senai.userapiv2.dtos.MensagemDTO;
import com.senai.userapiv2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    UsuarioService service;

    @PostMapping("/login1")
    public ResponseEntity<MensagemDTO> autenticarUsuario(@RequestBody AutenticacaoDTO autenticacaoDTO) {
        MensagemDTO mensagemDTO = service.autenticarUsuario(autenticacaoDTO);

        if(mensagemDTO.getSucesso()) {
            return ResponseEntity.status(201).body(mensagemDTO);
        }
        return ResponseEntity.status(401).body(mensagemDTO);
    }

    @PostMapping("/login2")
    public String autenticarUsuario2(@ModelAttribute("loginDTO")  AutenticacaoDTO autenticacaoDTO) {

        System.out.println(autenticacaoDTO.getLogin() + " " + autenticacaoDTO.getSenha());

        return "redirect:/auth";
    }

    @GetMapping
    public String obterLogin(Model model) {
        AutenticacaoDTO autenticacaoDTO = new AutenticacaoDTO();
        model.addAttribute("loginDTO", autenticacaoDTO);

        return "login";
    }
}
