package com.senai.userapiv2.controllers.cliente;

import com.senai.userapiv2.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;
}
