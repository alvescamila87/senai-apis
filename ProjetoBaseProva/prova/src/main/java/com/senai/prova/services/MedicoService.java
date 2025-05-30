package com.senai.prova.services;

import com.senai.prova.dtos.MedicoDto;
import com.senai.prova.exception.InvalidOperationException;
import com.senai.prova.models.MedicoModel;
import com.senai.prova.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
   
    @Autowired
    MedicoRepository repository;

    public List<MedicoDto> listarMedicos() {
        List<MedicoDto> listaMedicosDTO = new ArrayList<>();

        List<MedicoModel> listaMedicoModel = repository.findAll();

        for(MedicoModel medicoModel: listaMedicoModel) {
            MedicoDto medicoDto = new MedicoDto();
            medicoDto.setId(medicoModel.getId());
            medicoDto.setNome(medicoModel.getNome());
            medicoDto.setEspecialidade(medicoModel.getEspecialidade());

            listaMedicosDTO.add(medicoDto);
        }

        return listaMedicosDTO;
    }

    public MedicoDto obterMedicoPorId(Long id) {
        Optional<MedicoModel> medicoModelOptional = repository.findById(id);

        if(medicoModelOptional.isEmpty()) {
            throw new InvalidOperationException("Médico não encontrado");
        }

        return MedicoDto.of(medicoModelOptional.get());
    }

    public void adicionarMedico(MedicoDto medicoDto) {

        MedicoModel novoMedico = new MedicoModel();
        novoMedico.setNome(medicoDto.getNome());
        novoMedico.setEspecialidade(medicoDto.getEspecialidade());

        repository.save(novoMedico);
    }

    public void atualizarMedico(Long id, MedicoDto medicoDto) {

        MedicoDto atualizarMedico = new MedicoDto();

        Optional<MedicoModel> atualizarMedicoModel = repository.findById(id);

        if(atualizarMedicoModel.isEmpty()) {
            throw new InvalidOperationException("Médico não encontrado");
        }

        MedicoModel medicoModel = atualizarMedicoModel.get();
        medicoModel.setNome(medicoDto.getNome());
        medicoModel.setEspecialidade(medicoModel.getEspecialidade());

        repository.save(medicoModel);
    }

    public Boolean deletarMedico(Long id) {
        Optional<MedicoModel> medicoModelOptional = repository.findById(id);

        if(medicoModelOptional.isEmpty()) {
            throw new InvalidOperationException("Médico não encontrado");
        }

        repository.delete(medicoModelOptional.get());
        return true;
    }
    
}
