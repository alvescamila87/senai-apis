package com.senai.user_database.services;

import com.senai.user_database.dtos.ConsultaUsuarioDTO;
import com.senai.user_database.dtos.MensagemDTO;
import com.senai.user_database.dtos.RequisicaoDTO;
import com.senai.user_database.dtos.RespostaDTO;
import com.senai.user_database.models.UsuarioModel;
import com.senai.user_database.repositories.UsuarioRepository;
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

        if(requisicaoDTO == null) {
            mensagemDTO.setSucesso(false);
            mensagemDTO.setMensagem("ERRO ao cadastrar usuário. Contate o suporte.");
            return mensagemDTO;
        }

        UsuarioModel novoUsuarioModel = new UsuarioModel();
        novoUsuarioModel.setNome(requisicaoDTO.getNome());
        novoUsuarioModel.setLogin(requisicaoDTO.getLogin());
        novoUsuarioModel.setSenha(requisicaoDTO.getSenha());
        mensagemDTO.setMensagem("Usuário cadastrado com sucesso");
        mensagemDTO.setSucesso(true);

        repository.save(novoUsuarioModel);

        return mensagemDTO;
    }

    /* Opção 1 2 Opção 2
    public List<ListaUsuarioDTO> listarUsuarios() {

        return repository.findAll();
    }
     */

    /**
     * Opção 3
     */

    public List<ConsultaUsuarioDTO> listarUsuarios() {
        //declara o dto de retorno
        List<ConsultaUsuarioDTO> listaConsultaUsuarioDTO = new ArrayList<>();

        //busca usuarioModel do repository através do findAll
        List<UsuarioModel> usuarioModelRepository = repository.findAll();

        for(UsuarioModel usuarioModel : usuarioModelRepository) {
            // converter usuário model para usuario dto
            ConsultaUsuarioDTO consultaUsuarioDTO = new ConsultaUsuarioDTO();
            consultaUsuarioDTO.setId(usuarioModel.getId());
            consultaUsuarioDTO.setNome(usuarioModel.getNome());
            consultaUsuarioDTO.setLogin(usuarioModel.getLogin());

            //adicionar o dto convertido à lista de retorno (que também é um dto)
            listaConsultaUsuarioDTO.add(consultaUsuarioDTO);
        }

        return listaConsultaUsuarioDTO;
    }

    public RespostaDTO buscarUsuarioPorId(Long id) {
        RespostaDTO respostaDTO = new RespostaDTO();

        Optional<UsuarioModel> usuarioIdPesquisado = repository.findById(id);

        if(usuarioIdPesquisado.isPresent()) {
            respostaDTO.setId(usuarioIdPesquisado.get().getId());
            respostaDTO.setNome(usuarioIdPesquisado.get().getNome());
            respostaDTO.setLogin(usuarioIdPesquisado.get().getLogin());
            respostaDTO.setSenha(usuarioIdPesquisado.get().getSenha());
        }

        return respostaDTO;
    }

    public MensagemDTO atualizarUsuario(Long id, RequisicaoDTO requisicaoDTO){
        MensagemDTO mensagemDTO = new MensagemDTO();

        Optional<UsuarioModel> usuarioModelIdPesquisado = repository.findById(id);

        if(usuarioModelIdPesquisado.isEmpty()) {
            mensagemDTO.setMensagem("ERRO ao atualizar usuário.");
            mensagemDTO.setSucesso(false);
            return mensagemDTO;
        }

        UsuarioModel usuarioModel = usuarioModelIdPesquisado.get();
        usuarioModel.setNome(requisicaoDTO.getNome());
        usuarioModel.setNome(requisicaoDTO.getNome());
        usuarioModel.setSenha(requisicaoDTO.getSenha());

        mensagemDTO.setMensagem("Usuário atualizado com sucesso!");
        mensagemDTO.setSucesso(true);

        repository.save(usuarioModel);

        return mensagemDTO;
    }

    public MensagemDTO deletarUsuario(Long id) {
        MensagemDTO mensagemDTO = new MensagemDTO();

        Optional<UsuarioModel> usuarioModelIdPesquisado = repository.findById(id);

        if(usuarioModelIdPesquisado.isEmpty()) {
            mensagemDTO.setMensagem("Erro ao deletar usuário.");
            mensagemDTO.setSucesso(false);
            return mensagemDTO;
        }

        repository.delete(usuarioModelIdPesquisado.get());
        mensagemDTO.setMensagem("Usuário excluído com sucesso.");
        mensagemDTO.setSucesso(true);

        return mensagemDTO;
    }
}
