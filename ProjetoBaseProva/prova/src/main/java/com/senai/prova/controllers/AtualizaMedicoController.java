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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atualizarmedico")
public class AtualizaMedicoController {
    
    @Autowired
    MedicoService service;
    
    @GetMapping("/{id}")
    public String obtemAtualizacaoMedico(@PathVariable Long id, Model model, HttpServletRequest request){
        
        //--Fazer: Validar sessão
        UsuarioSessaoDto usuarioSessaoDto = ControleSessao.obter(request);
        if(usuarioSessaoDto.getId() == 0) {
            return "redirect:/login";
        }

        MedicoDto medicoDto = service.obterMedicoPorId(id);
        model.addAttribute("medicoDto", medicoDto);
        
        //--Fazer: buscar do MedicoService os dados do médico no Dto pelo "id"
        //model.addAttribute("medicoDto", medicoDto);

        return "atualizarmedico";
    }
    
}
