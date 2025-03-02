package com.senai.usuario.services;

import com.senai.usuario.dtos.*;
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

        if(validacaoDuplicidadeId(requisicaoDTO.getId())) {
            mensagemDTO.setStatusSucesso(false);
            mensagemDTO.setMensagem("ERRO: ID " + requisicaoDTO.getId() + " já cadastrado! Tente outro...");
            return mensagemDTO;
        }

        if(validacaoDuplicidadeLogin(requisicaoDTO.getLogin())) {
            mensagemDTO.setStatusSucesso(false);
            mensagemDTO.setMensagem("ERRO: Login " + requisicaoDTO.getLogin() + " já cadastrado. Tente outro...");
            return mensagemDTO;
        }

        usuarioModel.setId(requisicaoDTO.getId());
        usuarioModel.setNome(requisicaoDTO.getNome());
        usuarioModel.setLogin(requisicaoDTO.getLogin());
        usuarioModel.setSenha(requisicaoDTO.getSenha());

        listaUsuariosBancoDados.add(usuarioModel);
        mensagemDTO.setMensagem("Usuário " + requisicaoDTO.getNome() + " cadastrado com sucesso!");
        mensagemDTO.setStatusSucesso(true);

        return mensagemDTO;
    }


    public MensagemDTO atualizarUsuario(Integer id, RequisicaoDTO requisicaoDTO) {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setMensagem("ERRO: Erro ao atualizar usuário.");
        mensagemDTO.setStatusSucesso(false);

        for(UsuarioModel usuarioModel : listaUsuariosBancoDados) {

            if(usuarioModel.getId().equals(id)) {

                if(!usuarioModel.getLogin().equals(requisicaoDTO.getLogin()) && validacaoDuplicidadeLogin(requisicaoDTO.getLogin())) {
                    mensagemDTO.setStatusSucesso(false);
                    mensagemDTO.setMensagem("ERRO: Login " + requisicaoDTO.getLogin() + " já cadastrado. Tente outro...");
                    return mensagemDTO;
                }

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

    public MensagemDTO autenticarUsuario(AutenticacaoDTO autenticacaoDTO) {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setMensagem("ERRO: Erro ao realizar autenticação do usuário. Login ou senha não incorretos ou inexistentes.");
        mensagemDTO.setStatusSucesso(false);

        for(UsuarioModel usuarioModel : listaUsuariosBancoDados) {
            if(autenticacaoDTO.getLogin().equals(usuarioModel.getLogin()) && autenticacaoDTO.getSenha().equals(usuarioModel.getSenha())) {
                mensagemDTO.setStatusSucesso(true);
                mensagemDTO.setMensagem("Usuário autenticado com sucesso!");
            }
        }

        return mensagemDTO;
    }

    private boolean validacaoDuplicidadeId(Integer id) {
        for(UsuarioModel usuarioModel : listaUsuariosBancoDados) {
            if(id.equals(usuarioModel.getId())) {
                return true;
            }
        }
        return false;
    }

    private boolean validacaoDuplicidadeLogin(String login) {
        for(UsuarioModel usuarioModel : listaUsuariosBancoDados) {
            if(login.equals(usuarioModel.getLogin())) {
                return true;
            }
        }
        return false;
    }
}
