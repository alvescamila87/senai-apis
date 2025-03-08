package com.senai.userapiv2.services;

import com.senai.userapiv2.dtos.MensagemDTO;
import com.senai.userapiv2.dtos.RequisicaoDTO;
import com.senai.userapiv2.models.UsuarioModel;
import com.senai.userapiv2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public MensagemDTO adicionarUsuario(RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setMensagem("[ERRO] Erro ao cadastrar usuário...");
        mensagemDTO.setSucesso(false);

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(requisicaoDTO.getNome());
        usuarioModel.setLogin(requisicaoDTO.getLogin());
        usuarioModel.setSenha(requisicaoDTO.getSenha());

        mensagemDTO.setSucesso(true);
        mensagemDTO.setMensagem("Usuário cadastrado com sucesso!");
        repository.save(usuarioModel);

        return mensagemDTO;
    }

}
