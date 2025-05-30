package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.dtos.UsuarioSessaoDto;
import com.senai.prova.services.MedicoService;
import com.senai.prova.session.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastramedico")
public class CadastraMedicoController {
   
    @Autowired
    MedicoService medicoService;
    
    @GetMapping
    public String obtemCadastroMedico(Model model, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessaoDTO = ControleSessao.obter(request);
        if(usuarioSessaoDTO.getId() == 0){
            return "redirect:/login";
        }

        MedicoDto medicoDto = new MedicoDto();
        model.addAttribute("medicoDto", medicoDto);
        
        return "cadastramedico";
    }
}
