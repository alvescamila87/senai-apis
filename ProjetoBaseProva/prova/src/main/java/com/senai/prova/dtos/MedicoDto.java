package com.senai.prova.dtos;

import com.senai.prova.models.MedicoModel;
import lombok.Data;

@Data
public class MedicoDto {
    
    private Long id;
    
    private String nome;
    
    private String especialidade;

    public MedicoDto() {
    }

    public MedicoDto(Long id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(java.lang.String especialidade) {
        this.especialidade = especialidade;
    }

    public static MedicoDto of(MedicoModel medicoModel) {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setId(medicoModel.getId());
        medicoDto.setEspecialidade(medicoModel.getEspecialidade());
        medicoDto.setNome(medicoModel.getNome());

        return medicoDto;
    }
}
