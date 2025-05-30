package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.dtos.UsuarioSessaoDto;
import com.senai.prova.services.MedicoService;
import java.util.ArrayList;
import java.util.List;

import com.senai.prova.session.ControleSessao;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listamedico")
public class ListaMedicoController {
      
    @Autowired
    MedicoService service;
        
    @GetMapping
    public String exibeAlteraMedico(Model model, HttpServletRequest request){
        
        //--Fazer: Validar sessão        
        UsuarioSessaoDto usuarioSessaoDto = ControleSessao.obter(request);
        if(usuarioSessaoDto.getId() == 0) {
            return "redirect:/login";
        }

        List<MedicoDto> listaMedicosDTO = service.listarMedicos();
        model.addAttribute("listaMedicosDTO", listaMedicosDTO);


        //--Fazer: Buscar do MedicoService uma lista de Medicos na variável "ListaMedicoDto"
        
        model.addAttribute("listaMedicosDTO", listaMedicosDTO);
        
        return "listamedico";
    }
}

