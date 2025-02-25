package com.senai.usuario.services;

import com.senai.usuario.dtos.UsuarioDTO;
import com.senai.usuario.models.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    public UsuarioModel createUser(UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioModel = new UsuarioModel();

        if(usuarioDTO != null) {
            usuarioModel.setId(usuarioModel.getId());
            usuarioModel.setNome(usuarioDTO.getNome());
            return usuarioModel;
        }

        return null;

    }

    public List<UsuarioModel> listaUsuarios(UsuarioDTO usuarioDTO) {
        UsuarioModel newUser = createUser(usuarioDTO);

        List<UsuarioModel> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(newUser);

        return  listaUsuarios;
    }
}
