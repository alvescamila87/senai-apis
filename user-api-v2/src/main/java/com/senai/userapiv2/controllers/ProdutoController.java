package com.senai.userapiv2.controllers;

import com.senai.userapiv2.dtos.ProdutoListaDTO;
import com.senai.userapiv2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public List<ProdutoListaDTO> listarProdutos() {
        List<ProdutoListaDTO> listaProdutosDTO = service.listarProdutos();

        return listaProdutosDTO;
    }
}
