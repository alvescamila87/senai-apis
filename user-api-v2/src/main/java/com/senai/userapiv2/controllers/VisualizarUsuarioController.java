package com.senai.userapiv2.controllers;

import com.senai.userapiv2.dtos.UsuarioCadastroDTO;
import com.senai.userapiv2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/viewuser")
public class VisualizarUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterVisualizacaoUsuario(Model model, @PathVariable Long id) {
        UsuarioCadastroDTO visualizarUsuarioDTO = service.buscarUsuarioPorId2(id);
        model.addAttribute("viewuserDTO", visualizarUsuarioDTO);

        return "viewuser";
    }
}
