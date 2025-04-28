package com.senai.userapiv2.controllers.produto;

import com.senai.userapiv2.dtos.produto.ProdutoDTO;
import com.senai.userapiv2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/view-product")
public class VisualizarCadastroProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/{id}")
    public String obterVisualizarProduto(@PathVariable Long id, Model model) {

        ProdutoDTO visualizarProdutoDTO = service.buscarProdutoPorId(id);

        model.addAttribute("viewProductDTO", visualizarProdutoDTO);

        return "viewproduct";
    }

}
