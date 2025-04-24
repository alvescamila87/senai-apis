package com.senai.userapiv2.services;

import com.senai.userapiv2.dtos.ProdutoListaDTO;
import com.senai.userapiv2.models.ProdutoModel;
import com.senai.userapiv2.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<ProdutoListaDTO> listarProdutos() {
        List<ProdutoListaDTO> listaProdutosDTO = new ArrayList<>();

        List<ProdutoModel> listaProdutosModel = repository.findAll();

        for(ProdutoModel produtoModel: listaProdutosModel) {
            ProdutoListaDTO produtoRequestDTO = new ProdutoListaDTO();
            produtoRequestDTO.setId(produtoModel.getId());
            produtoRequestDTO.setNome(produtoModel.getDescricao());
            produtoRequestDTO.setPreco(produtoModel.getPreco());
            produtoRequestDTO.setQuantidadeEstoque(produtoModel.getQuantidadeEstoque());

            listaProdutosDTO.add(produtoRequestDTO);
        }

        return listaProdutosDTO;

    }
}
