package com.senai.userapiv2.controllers.usuario;

import com.senai.userapiv2.dtos.usuario.UsuarioDTO;
import com.senai.userapiv2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/userlist")
public class UserlistController {

    @Autowired
    UsuarioService service;

//    @GetMapping
//    public String obterUserList(Model model) {
//
//        List<UsuarioDTO> listUsersDTO = service.listarUsuarios();
//        model.addAttribute("listUsersDTO", listUsersDTO);
//
//        return "userlist";
//    }

    @GetMapping
    public String obterUserList(
            @RequestParam(value = "user_list_filter", required = false) Long userId,
            Model model) {

        if (userId != null) {
            // Se um ID foi fornecido, busca só esse usuário
            List<UsuarioDTO> listUsersDTO = new ArrayList<>();

            UsuarioDTO usuario = service.buscarUsuarioPorId3(userId);
            if (usuario != null) {
                listUsersDTO.add(usuario);
            }

            model.addAttribute("listUsersDTO", listUsersDTO);
        } else {
            // Caso contrário, busca todos
            List<UsuarioDTO> listUsersDTO = service.listarUsuarios();
            model.addAttribute("listUsersDTO", listUsersDTO);
        }

        return "userlist";
    }
}
