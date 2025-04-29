package com.senai.userapiv2.controllers.cliente;

import com.senai.userapiv2.dtos.cliente.ClienteRequestDTO;
import com.senai.userapiv2.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addclient")
public class CadastroClienteController {

    @Autowired
    ClienteService service;


    public String obterCadastroCliente(Model model) {

        ClienteRequestDTO clienteRequestDTO = new ClienteRequestDTO();
        model.addAttribute("clienteRequestDTO", clienteRequestDTO);

        return "addclient";
    }
}
