package com.senai.userapiv2.controllers.produto;

import com.senai.userapiv2.dtos.produto.ProdutoDTO;
import com.senai.userapiv2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/update-product")
public class AtualizarCadastroProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/{id}")
    public String obterAtualizarProduto(@PathVariable Long id, Model model) {

        ProdutoDTO atualizarProdutoDTO = service.buscarProdutoPorId(id);

        model.addAttribute("updateProductDTO", atualizarProdutoDTO);

        return "updateproduct";
    }

    @PostMapping("/{id}")
    public String atualizarProduto(@PathVariable Long id, @ModelAttribute("updateProductDTO") ProdutoDTO produtoDTO) {

        Boolean resultado = service.atualizarProduto(id, produtoDTO);

        if(!resultado) {
            return "redirect:/produtos?error";
        }

        return "redirect:/produtos";
    }

}
