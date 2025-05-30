package com.senai.prova.controllers;

import com.senai.prova.dtos.LoginDto;
import com.senai.prova.dtos.UsuarioSessaoDto;
import com.senai.prova.services.UsuarioService;
import com.senai.prova.session.ControleSessao;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    UsuarioService service;
    
    @GetMapping
    public String obterLogin(Model model,  HttpServletRequest request){

        UsuarioSessaoDto usuarioSessaoDto = ControleSessao.obter(request);
        if(usuarioSessaoDto.getId() != 0L){
            ControleSessao.encerrar(request);
        }

        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        
        return "login";
    }
    
    
    @PostMapping
    public String autenticarLogin(@ModelAttribute("loginDto") LoginDto loginDto, HttpServletRequest request){
        System.out.println(loginDto.getEmail());
        System.out.println(loginDto.getSenha());
        UsuarioSessaoDto usuarioSessaoDto = service.realizarLogin(loginDto);

        ControleSessao.registrar(request, usuarioSessaoDto);

        if(usuarioSessaoDto.getId() != 0L) {
            return "redirect:/listamedico";
        }

        return "redirect:/login?erro";
    }
}
