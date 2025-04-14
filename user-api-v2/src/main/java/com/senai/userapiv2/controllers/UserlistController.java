package com.senai.userapiv2.controllers;

import com.senai.userapiv2.dtos.UsuarioDTO;
import com.senai.userapiv2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/userlist")
public class UserlistController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterUserList(Model model) {

        List<UsuarioDTO> listUsersDTO = service.listarUsuarios();
        model.addAttribute("listUsersDTO", listUsersDTO);

        return "userlist";
    }
}
