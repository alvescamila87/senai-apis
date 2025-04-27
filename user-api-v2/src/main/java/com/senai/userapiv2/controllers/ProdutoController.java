package com.senai.userapiv2.controllers;

import com.senai.userapiv2.dtos.MensagemDTO;
import com.senai.userapiv2.dtos.ProdutoListaDTO;
import com.senai.userapiv2.dtos.ProdutoRequestDTO;
import com.senai.userapiv2.dtos.ProdutoDTO;
import com.senai.userapiv2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/crud/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/produtos")
    public List<ProdutoListaDTO> listarProdutos() {
        return service.listarProdutos();
    }

    @PostMapping
    public Boolean cadastrarProduto(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        return service.cadastrarProduto(produtoRequestDTO);
    }

    @PutMapping("/{id}")
    public Boolean atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        return service.atualizarProduto(id, produtoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> deletarProduto(@PathVariable Long id) {
        MensagemDTO mensagemDTO = service.deletarProduto(id);

        if(!mensagemDTO.getSucesso()) {
            return ResponseEntity.status(404).body(mensagemDTO);
        }

        return ResponseEntity.ok().body(mensagemDTO);
    }

}
