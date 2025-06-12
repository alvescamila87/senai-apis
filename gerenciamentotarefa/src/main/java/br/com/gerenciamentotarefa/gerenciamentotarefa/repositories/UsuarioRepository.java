package br.com.gerenciamentotarefa.gerenciamentotarefa.repositories;

import br.com.gerenciamentotarefa.gerenciamentotarefa.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
