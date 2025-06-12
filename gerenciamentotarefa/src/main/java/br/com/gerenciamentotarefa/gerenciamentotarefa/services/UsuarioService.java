package br.com.gerenciamentotarefa.gerenciamentotarefa.services;

import br.com.gerenciamentotarefa.gerenciamentotarefa.dtos.UsuarioDTO;
import br.com.gerenciamentotarefa.gerenciamentotarefa.entities.UsuarioEntity;
import br.com.gerenciamentotarefa.gerenciamentotarefa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();

        List<UsuarioEntity> listaUsuariosEntity = repository.findAll();

        for(UsuarioEntity usuarioEntity : listaUsuariosEntity) {
            listaUsuariosDTO.add(UsuarioDTO.of(usuarioEntity));
        }

        return  listaUsuariosDTO;

    }

    public void adicionarUsuario(UsuarioDTO usuarioDTO) {

            UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setUsuarioNome(usuarioDTO.getNome());
            usuarioEntity.setUsuarioEmail(usuarioDTO.getEmail());

            repository.save(usuarioEntity);
    }
}
