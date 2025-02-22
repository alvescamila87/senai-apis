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

//    @PostMapping
//    public ResponseEntity<RespostaDTO> realizarConversaoComprimento(@RequestBody RequisicaoDTO requisicao) {
//        RespostaDTO respostaDTO = service.converterComprimento(requisicao);
//
//        if(requisicao.getTipoConversao().equalsIgnoreCase("cm-m")){
//            return ResponseEntity.ok().body(respostaDTO);
//        }  else if(requisicao.getTipoConversao().equalsIgnoreCase("m-cm")){
//            return ResponseEntity.ok().body(respostaDTO);
//        }
//        return ResponseEntity.status(400).body(respostaDTO);
//    }

    @PostMapping
    public ResponseEntity<RespostaDTO> realizarConversao(@RequestBody RequisicaoDTO dto) {
        RespostaDTO respostaDTO = null;

//        if(dto.getTipoConversao().equalsIgnoreCase("cm-m")) {
//            respostaDTO = service.converterComprimento(dto);
//        }

        switch (dto.getTipoConversao().toLowerCase()) {
            case "cm-m":
                respostaDTO = (service.converterComprimento(dto));
                break;
            case "m-cm":
                respostaDTO = service.converterComprimento(dto);
                break;
            case "g-kg":
                respostaDTO = service.converterMassa(dto);
                break;
            case "kg-g":
                respostaDTO = service.converterMassa(dto);
                break;
            case "c-f":
                respostaDTO = service.converterTemperatura(dto);
                break;
            case "f-c":
                respostaDTO = service.converterTemperatura(dto);
                break;
            default:
                return ResponseEntity.badRequest().body(respostaDTO);

        }

        return ResponseEntity.ok().body(respostaDTO);

    }


}
