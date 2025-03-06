package com.senai.user_database.services;

import com.senai.user_database.dtos.ListaUsuarioDTO;
import com.senai.user_database.dtos.MensagemDTO;
import com.senai.user_database.dtos.RequisicaoDTO;
import com.senai.user_database.dtos.RespostaDTO;
import com.senai.user_database.models.Usuario;
import com.senai.user_database.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public MensagemDTO adicionarUsuario(RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = new MensagemDTO();

        if(requisicaoDTO == null) {
            mensagemDTO.setSucesso(false);
            mensagemDTO.setMensagem("ERRO ao cadastrar usuário. Contate o suporte.");
            return mensagemDTO;
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(requisicaoDTO.getNome());
        novoUsuario.setLogin(requisicaoDTO.getLogin());
        novoUsuario.setSenha(requisicaoDTO.getSenha());
        mensagemDTO.setMensagem("Usuário cadastrado com sucesso");
        mensagemDTO.setSucesso(true);

        repository.save(novoUsuario);

        return mensagemDTO;
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public RespostaDTO buscarUsuarioPorId(Long id, RequisicaoDTO requisicaoDTO) {
        RespostaDTO respostaDTO = new
    }
}
