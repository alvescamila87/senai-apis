package com.senai.prova.controllers;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.exception.InvalidOperationException;
import com.senai.prova.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/medico")
public class MedicoController {
    
    @Autowired
    MedicoService service;

    @PostMapping
    public String cadastraMedico(@ModelAttribute("medicoDto")MedicoDto medicoDto){

        service.adicionarMedico(medicoDto);
        return "redirect:/listamedico";
    }


    @PostMapping("/{id}")
    public String atualizaMedico(@PathVariable Long id, @ModelAttribute("medicoDto") MedicoDto medicoDto, RedirectAttributes redirectAttributes){

        try {
            service.atualizarMedico(id, medicoDto);
            return "redirect:/listamedico?sucesso";
        } catch (InvalidOperationException ex){
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/atualizarmedico/" + id;
        }
        //--Chamar o service para atualizar
        //return "listamedico";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarMedico(@PathVariable Long id){

        Boolean sucesso = service.deletarMedico(id);

        if(sucesso){
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.status(404).body(false);
        }
    }

}
