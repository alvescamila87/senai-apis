package br.com.gerenciamentotarefa.gerenciamentotarefa.services;

import br.com.gerenciamentotarefa.gerenciamentotarefa.dtos.TarefaDTO;
import br.com.gerenciamentotarefa.gerenciamentotarefa.entities.TarefaEntity;
import br.com.gerenciamentotarefa.gerenciamentotarefa.entities.UsuarioEntity;
import br.com.gerenciamentotarefa.gerenciamentotarefa.repositories.TarefaRepository;
import br.com.gerenciamentotarefa.gerenciamentotarefa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<TarefaEntity> listaTarefas() {

        /*
        List<TarefaDTO> listaTarefasDTO = new ArrayList<>();

        List<TarefaEntity> listaTarefaEntity = repository.findAll();

        for(TarefaEntity tarefaEntity : listaTarefaEntity) {
            listaTarefasDTO.add(TarefaDTO.of(tarefaEntity));
        }
        */
        return repository.findAll();

    }

    public void adicionarTarefa(TarefaDTO tarefaDTO) {

        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(tarefaDTO.getUsuarioId());

        if(usuarioEntityOptional.isPresent()) {

            TarefaEntity tarefaEntity = new TarefaEntity();
            tarefaEntity.setTarefaDescricao(tarefaDTO.getDescricao());
            tarefaEntity.setTarefaSetor(tarefaDTO.getSetor());
            tarefaEntity.setUsuario(usuarioEntityOptional.get());
            tarefaEntity.setTarefaPrioridade(tarefaDTO.getPrioridade());
            tarefaEntity.setTarefaStatus("afazer");
            tarefaEntity.setTarefaData(LocalDate.now());

            repository.save(tarefaEntity);
        }
    }

    public void atualizarTarefa(Long id, TarefaDTO tarefaDTO) {

        Optional<TarefaEntity> tarefaEntityOptional = repository.findById(id);

        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(tarefaDTO.getUsuarioId());

        if(tarefaEntityOptional.isPresent()) {
            TarefaEntity tarefaEntity = tarefaEntityOptional.get();
            tarefaEntity.setTarefaDescricao(tarefaDTO.getDescricao());
            tarefaEntity.setTarefaSetor(tarefaDTO.getSetor());
            tarefaEntity.setUsuario(usuarioEntityOptional.get());
            tarefaEntity.setTarefaPrioridade(tarefaDTO.getPrioridade());

            repository.save(tarefaEntity);
        }
    }


    public TarefaDTO obterTarefaPorId(Long id) {

        Optional<TarefaEntity> tarefaEntityOptional = repository.findById(id);

        if(tarefaEntityOptional.isPresent()) {
            return TarefaDTO.of(tarefaEntityOptional.get());
        }

        return null;
    }

    public void deletarTarefa(Long id) {

        Optional<TarefaEntity> tarefaEntityOptional = repository.findById(id);

        if(tarefaEntityOptional.isPresent()) {
            repository.delete(tarefaEntityOptional.get());
        }
    }

    public void atualizarStatus(Long id, String status) {

        Optional<TarefaEntity> tarefaEntityOptional = repository.findById(id);

        if(tarefaEntityOptional.isPresent()) {
            TarefaEntity tarefaEntity = tarefaEntityOptional.get();
            tarefaEntity.setTarefaStatus(status);

            repository.save(tarefaEntity);
        }
    }
}
