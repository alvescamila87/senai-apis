package com.senai.convertionapi.controllers;

import com.senai.convertionapi.dtos.RequisicaoDTO;
import com.senai.convertionapi.dtos.RespostaDTO;
import com.senai.convertionapi.services.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class ConversorController {

    @Autowired
    private ConversorService service;

    @PostMapping
    public ResponseEntity<RespostaDTO> realizarConversao(@RequestBody RequisicaoDTO dto) {

        RespostaDTO respostaDTO = service.converterPorTipo(dto);

        if(respostaDTO.getErro() == null) {
            return ResponseEntity.ok().body(respostaDTO);
        }

        return ResponseEntity.badRequest().body(respostaDTO);
    }

}
