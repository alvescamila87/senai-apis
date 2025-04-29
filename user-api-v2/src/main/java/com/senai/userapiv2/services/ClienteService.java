package com.senai.userapiv2.services;

import com.senai.userapiv2.dtos.cliente.ClienteListaDTO;
import com.senai.userapiv2.dtos.cliente.ClienteRequestDTO;
import com.senai.userapiv2.models.ClienteModel;
import com.senai.userapiv2.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public List<ClienteListaDTO> listarClientes() {
        List<ClienteListaDTO> listaClientesDTO = new ArrayList<>();

        List<ClienteModel> listaClienteModel = repository.findAll();

        for(ClienteModel model : listaClienteModel) {
            ClienteListaDTO clienteDTO = new ClienteListaDTO();
            clienteDTO.setId(model.getId());
            clienteDTO.setNome(model.getNome());
            clienteDTO.setDataNascimento(model.getDataNascimento());
            clienteDTO.setEmail(model.getEmail());
            clienteDTO.setAtivo(model.getAtivo());

            listaClientesDTO.add(clienteDTO);
        }

        return listaClientesDTO;
    }

    public Boolean cadastrarCliente(ClienteRequestDTO clienteRequestDTO) {
        ClienteRequestDTO novoClienteDTO = new ClienteRequestDTO();

        if(clienteRequestDTO != null) {
            ClienteModel novoClienteModel = new ClienteModel();
            novoClienteModel.setNome(clienteRequestDTO.getNome());
            novoClienteModel.setCpf(clienteRequestDTO.getCpf());
            novoClienteModel.setDataNascimento(clienteRequestDTO.getDataNascimento());
            novoClienteModel.setTelefone(clienteRequestDTO.getTelefone());
            novoClienteModel.setEmail(clienteRequestDTO.getEmail());
            novoClienteModel.setAtivo(true);

            repository.save(novoClienteModel);
            return true;

        }

        return false;
    }
}
