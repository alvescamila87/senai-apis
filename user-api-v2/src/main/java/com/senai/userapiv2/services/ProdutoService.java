package com.senai.userapiv2.services;

import com.senai.userapiv2.dtos.ProdutoListaDTO;
import com.senai.userapiv2.dtos.ProdutoRequestDTO;
import com.senai.userapiv2.dtos.ProdutoResponseDTO;
import com.senai.userapiv2.models.ProdutoModel;
import com.senai.userapiv2.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<ProdutoListaDTO> listarProdutos() {
        List<ProdutoListaDTO> listaProdutosDTO = new ArrayList<>();

        List<ProdutoModel> listaProdutosModel = repository.findAll();

        for(ProdutoModel produtoModel: listaProdutosModel) {
//            ProdutoListaDTO produtoRequestDTO = new ProdutoListaDTO();
//            produtoRequestDTO.setId(produtoModel.getId());
//            produtoRequestDTO.setNome(produtoModel.getDescricao());
//            produtoRequestDTO.setPreco(produtoModel.getPreco());
//            produtoRequestDTO.setQuantidadeEstoque(produtoModel.getQuantidadeEstoque());

//            listaProdutosDTO.add(produtoRequestDTO);

            ProdutoListaDTO produtoRequestDTO = ProdutoListaDTO.builder()
                    .id(produtoModel.getId())
                    .nome(produtoModel.getNome())
                    .preco(produtoModel.getPreco())
                    .quantidadeEstoque(produtoModel.getQuantidadeEstoque())
                    .build();

            listaProdutosDTO.add(produtoRequestDTO);
        }

        return listaProdutosDTO;

    }

    public Boolean cadastrarProduto(ProdutoRequestDTO produtoRequestDTO) {

        Boolean resultado = validaDuplicidadeNomeProduto(produtoRequestDTO.getNome());

        if(resultado) {
            return false;
        }

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome(produtoRequestDTO.getNome());
        produtoModel.setDescricao(produtoRequestDTO.getDescricao());
        produtoModel.setPreco(produtoRequestDTO.getPreco());
        produtoModel.setQuantidadeEstoque(produtoRequestDTO.getQuantidadeEstoque());

        repository.save(produtoModel);

        return true;
    }

    public Boolean validaDuplicidadeNomeProduto(String nomeProduto) {

        Optional<ProdutoModel> produtoModel = repository.findByNome(nomeProduto);

        if(produtoModel.isPresent()) {
            return true;
        }

        return false;
    }


}
