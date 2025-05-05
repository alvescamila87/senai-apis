package com.senai.usuario_database_oficial.controllers.produto;

import com.senai.usuario_database_oficial.dtos.ProdutoRequisicaoDto;
import com.senai.usuario_database_oficial.services.ProdutoService;
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
    public String obterProduto(Model model){

        ProdutoRequisicaoDto produtoRequisicaoDto = new ProdutoRequisicaoDto();
        model.addAttribute("produtoRequisicaoDto", produtoRequisicaoDto);

        return "cadastroproduto";
    }


    @PostMapping
    public String realizarCadastro(@ModelAttribute("produtoRequisicaoDto") ProdutoRequisicaoDto produtoRequisicaoDto){
        Boolean resultado = service.criarProduto(produtoRequisicaoDto);

        if(!resultado){
            return "redirect:/listaprodutos?erro";
        }

        return "redirect:/listaprodutos";
    }


}
