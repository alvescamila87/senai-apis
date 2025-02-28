package com.senai.usuario.services;

import com.senai.usuario.dtos.MensagemDTO;
import com.senai.usuario.dtos.RequisicaoDTO;
import com.senai.usuario.models.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<UsuarioModel> listaUsuario = new ArrayList<>();

    public MensagemDTO adicionarUsuario(RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = new MensagemDTO();

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(requisicaoDTO.getId());
        usuarioModel.setNome(requisicaoDTO.getNome());
        usuarioModel.setLogin(requisicaoDTO.getLogin());
        usuarioModel.setSenha(requisicaoDTO.getSenha());

        listaUsuario.add(usuarioModel);
        mensagemDTO.setMensagem("Usuário " + requisicaoDTO.getNome() + " cadastrado com sucesso!");

        return mensagemDTO;
    }

    public List<ListaUsuarioDTO> listaUsuarios() {
        List<ListaUsuarioDTO> listaUsuarios = new ArrayList<>();
        return
    }


}
