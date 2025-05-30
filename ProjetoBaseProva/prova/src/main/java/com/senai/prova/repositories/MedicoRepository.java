package com.senai.prova.repositories;

import com.senai.prova.models.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {
    
}
