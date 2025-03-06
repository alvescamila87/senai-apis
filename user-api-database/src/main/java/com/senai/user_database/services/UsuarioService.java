package com.senai.user_database.services;

import com.senai.user_database.dtos.ListaUsuarioDTO;
import com.senai.user_database.dtos.MensagemDTO;
import com.senai.user_database.dtos.RequisicaoDTO;
import com.senai.user_database.dtos.RespostaDTO;
import com.senai.user_database.models.Usuario;
import com.senai.user_database.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


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

    public RespostaDTO buscarUsuarioPorId(Long id) {
        RespostaDTO respostaDTO = new RespostaDTO();

        Optional<Usuario> usuarioIdPesquisado = repository.findById(id);

        if(usuarioIdPesquisado.isPresent()) {
            respostaDTO.setId(usuarioIdPesquisado.get().getId());
            respostaDTO.setNome(usuarioIdPesquisado.get().getNome());
            respostaDTO.setLogin(usuarioIdPesquisado.get().getLogin());
            respostaDTO.setSenha(usuarioIdPesquisado.get().getSenha());
        } else {
            return null;
        }

        return respostaDTO;

    }
}
