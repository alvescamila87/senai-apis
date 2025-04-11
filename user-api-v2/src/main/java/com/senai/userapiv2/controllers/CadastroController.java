package com.senai.userapiv2.controllers;

import com.senai.userapiv2.dtos.MensagemDTO;
import com.senai.userapiv2.dtos.RequisicaoDTO;
import com.senai.userapiv2.dtos.ResponseDTO;
import com.senai.userapiv2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class CadastroController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterCadastro(Model model) {

        RequisicaoDTO signup = new RequisicaoDTO();
        model.addAttribute("signup", signup);

        return "signup";
    }

    @PostMapping
    public String cadastrarUsuario(@ModelAttribute ("signup") RequisicaoDTO requisicaoDTO) {

        MensagemDTO mensagemDTO = service.adicionarUsuario(requisicaoDTO);

        if(mensagemDTO.getSucesso()) {
            return "redirect:/login";
        }

        return "redirect:/login?error";
    }
}
