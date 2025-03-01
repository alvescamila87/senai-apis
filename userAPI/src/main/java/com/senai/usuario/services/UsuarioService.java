package com.senai.usuario.services;

import com.senai.usuario.dtos.ListaUsuariosDTO;
import com.senai.usuario.dtos.MensagemDTO;
import com.senai.usuario.dtos.RequisicaoDTO;
import com.senai.usuario.dtos.ResponseDTO;
import com.senai.usuario.models.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<UsuarioModel> listaUsuariosBancoDados = new ArrayList<>();

    public List<ListaUsuariosDTO> listarUsuarios() {
        List<ListaUsuariosDTO> listaDeUsuarios = new ArrayList<>();

        for (UsuarioModel usuarioModel : this.listaUsuariosBancoDados) {
            ListaUsuariosDTO listaUsuariosDTO = new ListaUsuariosDTO();
            listaUsuariosDTO.setId(usuarioModel.getId());
            listaUsuariosDTO.setNome(usuarioModel.getNome());
            listaUsuariosDTO.setLogin(usuarioModel.getLogin());
            listaDeUsuarios.add(listaUsuariosDTO);
        }

        return listaDeUsuarios;
    }

    public ResponseDTO buscarUsuarioPorId(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();

        for(UsuarioModel usuarioModel : listaUsuariosBancoDados) {
            if(usuarioModel.getId().equals(id)) {
                responseDTO.setId(usuarioModel.getId());
                responseDTO.setNome(usuarioModel.getNome());
                responseDTO.setLogin(usuarioModel.getLogin());
                responseDTO.setSenha(usuarioModel.getSenha());
            }
        }

        return responseDTO;
    }

    public MensagemDTO adicionarUsuario(RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = new MensagemDTO();

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(requisicaoDTO.getId());
        usuarioModel.setNome(requisicaoDTO.getNome());
        usuarioModel.setLogin(requisicaoDTO.getLogin());
        usuarioModel.setSenha(requisicaoDTO.getSenha());

        listaUsuariosBancoDados.add(usuarioModel);
        mensagemDTO.setMensagem("Usuário " + requisicaoDTO.getNome() + " cadastrado com sucesso!");

        return mensagemDTO;
    }


    public MensagemDTO atualizarUsuario(Integer id, RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setMensagem("ERRO: Erro ao atualizar usuário.");
        mensagemDTO.setStatusSucesso(false);

        for(UsuarioModel usuarioModel : listaUsuariosBancoDados) {
            if(usuarioModel.getId().equals(id)) {
                usuarioModel.setNome(requisicaoDTO.getNome());
                usuarioModel.setLogin(requisicaoDTO.getLogin());
                usuarioModel.setSenha(requisicaoDTO.getSenha());
                mensagemDTO.setStatusSucesso(true);
                mensagemDTO.setMensagem("Usuário atualizado com sucesso!");
            }
        }

        return mensagemDTO;
    }

    public MensagemDTO removerUsuarioPorId(Integer id) {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setMensagem("[ERRO]: Usuário não encontrado.");
        mensagemDTO.setStatusSucesso(false);

        UsuarioModel usuarioPesquisado = new UsuarioModel();
        usuarioPesquisado.setId(0);

        for (UsuarioModel usuarioModel : listaUsuariosBancoDados) {
            if (usuarioModel.getId().equals(id)) {
                usuarioPesquisado = usuarioModel;
            }
        }

        if (usuarioPesquisado.getId() != 0) {
            listaUsuariosBancoDados.remove(usuarioPesquisado);
            mensagemDTO.setStatusSucesso(true);
            mensagemDTO.setMensagem("Usuário excluído com sucesso!");
        }

        return mensagemDTO;
    }
}
