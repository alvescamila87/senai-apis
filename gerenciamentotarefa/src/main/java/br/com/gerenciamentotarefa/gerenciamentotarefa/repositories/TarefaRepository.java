package br.com.gerenciamentotarefa.gerenciamentotarefa.repositories;

import br.com.gerenciamentotarefa.gerenciamentotarefa.entities.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {
}
