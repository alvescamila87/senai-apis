package br.com.gerenciamentotarefa.gerenciamentotarefa.dtos;

import br.com.gerenciamentotarefa.gerenciamentotarefa.entities.TarefaEntity;
import br.com.gerenciamentotarefa.gerenciamentotarefa.entities.UsuarioEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TarefaDTO {

    private Long id;

    private String descricao;

    private String setor;

    private Long usuarioId;

    private UsuarioEntity usuario;

    private String prioridade;

    private String status;

    public static TarefaDTO of(TarefaEntity tarefaEntity) {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setId(tarefaEntity.getTarefaId());
        tarefaDTO.setDescricao(tarefaEntity.getTarefaDescricao());
        tarefaDTO.setSetor(tarefaEntity.getTarefaSetor());
        tarefaDTO.setUsuario(tarefaEntity.getUsuario());
        tarefaDTO.setUsuarioId(tarefaEntity.getUsuario().getUsuarioId());
        tarefaDTO.setPrioridade(tarefaEntity.getTarefaPrioridade());
        tarefaDTO.setStatus(tarefaEntity.getTarefaStatus());

        return tarefaDTO;
    }
}
