package com.senai.userapiv2.services;

import com.senai.userapiv2.dtos.*;
import com.senai.userapiv2.models.UsuarioModel;
import com.senai.userapiv2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();

        List<UsuarioModel> listaUsuarioModel = repository.findAll();

        for(UsuarioModel usuarioModel : listaUsuarioModel) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuarioModel.getId());
            usuarioDTO.setNome(usuarioModel.getNome());
            usuarioDTO.setLogin(usuarioModel.getLogin());
            usuarioDTO.setSenha(usuarioModel.getSenha());

            listaUsuariosDTO.add(usuarioDTO);
        }

        return listaUsuariosDTO;
    }

    public ResponseDTO buscarUsuarioPorId(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();

        Optional<UsuarioModel> usuarioModelIdPesquisado = repository.findById(id);

        if(usuarioModelIdPesquisado.isEmpty()) {
            return responseDTO;
        }

        UsuarioModel usuarioModel = usuarioModelIdPesquisado.get();

        responseDTO.setNome(usuarioModel.getNome());
        responseDTO.setLogin(usuarioModel.getLogin());
        responseDTO.setSenha(usuarioModel.getSenha());

        return responseDTO;
    }

    public MensagemDTO atualizarUsuario(Long id, RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = new MensagemDTO();

        Optional<UsuarioModel> usuarioModelIdPesquisado = repository.findById(id);

        if(usuarioModelIdPesquisado.isEmpty()) {
            mensagemDTO.setMensagem("[ERRO] Usuário não encontrado.");
            mensagemDTO.setSucesso(false);
            return mensagemDTO;
        }

        UsuarioModel usuarioModel = usuarioModelIdPesquisado.get();
        usuarioModel.setNome(requisicaoDTO.getNome());
        usuarioModel.setLogin(requisicaoDTO.getLogin());
        usuarioModel.setSenha(requisicaoDTO.getSenha());

        repository.save(usuarioModel);
        mensagemDTO.setMensagem("Usuário atualizado com sucesso!");
        mensagemDTO.setSucesso(true);

        return mensagemDTO;
    }

    public MensagemDTO deletarUsuario(Long id) {
        MensagemDTO mensagemDTO = new MensagemDTO();

        Optional<UsuarioModel> usuarioModelIdPesquisado = repository.findById(id);

        if(usuarioModelIdPesquisado.isEmpty()) {
            mensagemDTO.setSucesso(false);
            mensagemDTO.setMensagem("[ERRO] Usuário não encontrado");
            return mensagemDTO;
        }

        UsuarioModel usuarioModel = usuarioModelIdPesquisado.get();
        repository.delete(usuarioModel);

        mensagemDTO.setMensagem("Usuário excluído com sucesso!");
        mensagemDTO.setSucesso(true);

        return mensagemDTO;
    }

    public MensagemDTO autenticarUsuario(AutenticacaoDTO autenticacaoDTO) {
        MensagemDTO mensagemDTO = new MensagemDTO();

        List<UsuarioModel> listaUsuariosModel = repository.findAll();

        for(UsuarioModel usuarioModel : listaUsuariosModel) {
            if(usuarioModel.getLogin().equals(autenticacaoDTO.getLogin()) && usuarioModel.getSenha().equals(autenticacaoDTO.getSenha())) {
                mensagemDTO.setMensagem("Usuário autenticado com sucesso!");
                mensagemDTO.setSucesso(true);
                return mensagemDTO;
            }
            mensagemDTO.setMensagem("[ERRO] Erro ao realizar autenticação do usuário. Login ou senha não incorretos ou inexistentes.");
            mensagemDTO.setSucesso(false);
            return mensagemDTO;
        }


        return mensagemDTO;
    }
}
