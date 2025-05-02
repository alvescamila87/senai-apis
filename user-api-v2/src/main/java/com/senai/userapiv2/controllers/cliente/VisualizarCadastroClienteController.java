package com.senai.userapiv2.controllers.cliente;

import com.senai.userapiv2.dtos.cliente.ClienteDTO;
import com.senai.userapiv2.dtos.cliente.ClienteRequestDTO;
import com.senai.userapiv2.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view-client")
public class VisualizarCadastroClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("{id}")
    public String obterVisualizarCadastroCliente(@PathVariable Long id, Model model) {

        ClienteDTO visualizarClienteDTO = service.buscarClientePorId(id);

        model.addAttribute("viewClientDTO", visualizarClienteDTO);

        return "viewclient";
    }
}
