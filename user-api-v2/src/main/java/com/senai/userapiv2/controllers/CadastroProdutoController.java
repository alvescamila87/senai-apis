package com.senai.userapiv2.controllers;

import com.senai.userapiv2.dtos.ProdutoRequestDTO;
import com.senai.userapiv2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/produto")
public class CadastroProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public String obterProduto(Model model) {

        ProdutoRequestDTO cadastroProdutoDTO = new ProdutoRequestDTO();
        model.addAttribute("produtoRequestDTO", cadastroProdutoDTO);

        return "addproduct";
    }

    @PostMapping
    public String cadastrarProduto(@ModelAttribute("produtoRequestDTO") ProdutoRequestDTO produtoRequestDTO) {

        System.out.println("produtoRequestDTO " + produtoRequestDTO);
        Boolean resultado = service.cadastrarProduto(produtoRequestDTO);

        System.out.println("resultado " + resultado);

        if(!resultado) {
            return "redirect:/produtos?error";
        }

        return "redirect:/produtos";
    }

}
