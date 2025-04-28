package com.senai.userapiv2.controllers.produto;

import com.senai.userapiv2.dtos.produto.ProdutoListaDTO;
import com.senai.userapiv2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ListaProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public String obterListaProduto(Model model) {

        List<ProdutoListaDTO> produtoListaDTO = service.listarProdutos();
        model.addAttribute("produtoListaDTO", produtoListaDTO);

        return "productlist";
    }

//    @GetMapping
//    public String obterUserList(
//            @RequestParam(value = "user_list_filter", required = false) Long userId,
//            Model model) {
//
//        if (userId != null) {
//            // Se um ID foi fornecido, busca só esse usuário
//            List<UsuarioDTO> listUsersDTO = new ArrayList<>();
//
//            UsuarioDTO usuario = service.buscarUsuarioPorId3(userId);
//            if (usuario != null) {
//                listUsersDTO.add(usuario);
//            }
//
//            model.addAttribute("listUsersDTO", listUsersDTO);
//        } else {
//            // Caso contrário, busca todos
//            List<UsuarioDTO> listUsersDTO = service.listarUsuarios();
//            model.addAttribute("listUsersDTO", listUsersDTO);
//        }
//
//        return "userlist";
//    }
}
