package com.senai.prova.services;

import com.senai.prova.dtos.LoginDto;
import com.senai.prova.dtos.UsuarioSessaoDto;
import com.senai.prova.models.UsuarioModel;
import com.senai.prova.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
   
    @Autowired
    UsuarioRepository repository;
    
    public UsuarioSessaoDto realizarLogin(LoginDto loginDto){

        UsuarioSessaoDto usuarioSessaoDto = new UsuarioSessaoDto();

        Optional<UsuarioModel> usuarioModelOptional = repository.findByEmail(loginDto.getEmail());

        if(usuarioModelOptional.isPresent()) {

            if(usuarioModelOptional.get().getSenha().equals(loginDto.getSenha())) {
                usuarioSessaoDto.setId(usuarioModelOptional.get().getId());
                usuarioSessaoDto.setNome(usuarioModelOptional.get().getNome());
            }
        }

        return usuarioSessaoDto;
    }

}
