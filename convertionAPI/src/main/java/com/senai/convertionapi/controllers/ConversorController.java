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

        if (dto.getTipoConversao().equalsIgnoreCase("cm-m")) {
            return ResponseEntity.ok().body(service.converterComprimento(dto));
        } else if (dto.getTipoConversao().equalsIgnoreCase("m-cm")) {
            return ResponseEntity.ok().body(service.converterComprimento(dto));
        } else if (dto.getTipoConversao().equalsIgnoreCase("g-kg")) {
            return ResponseEntity.ok().body(service.converterMassa(dto));
        } else if (dto.getTipoConversao().equalsIgnoreCase("kg-g")) {
            return ResponseEntity.ok().body(service.converterMassa(dto));
        } else if (dto.getTipoConversao().equalsIgnoreCase("c-f")) {
            return ResponseEntity.ok().body(service.converterTemperatura(dto));
        } else if (dto.getTipoConversao().equalsIgnoreCase("f-c")) {
            return ResponseEntity.ok().body(service.converterTemperatura(dto));
        }

        return ResponseEntity.status(400).body(service.converterComprimento(dto));
    }

}
