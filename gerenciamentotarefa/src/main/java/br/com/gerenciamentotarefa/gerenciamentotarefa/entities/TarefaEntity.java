package br.com.gerenciamentotarefa.gerenciamentotarefa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tarefaId;

    @Column(name = "tarefa_descricao", nullable = false)
    private String tarefaDescricao;

    @Column(name = "tarefa_setor", nullable = false)
    private String tarefaSetor;

    @Column(name = "tarefa_prioridade", nullable = false)
    private String tarefaPrioridade;

    @Column(name = "tarefa_status", nullable = false)
    private String tarefaStatus;

    @Column(name = "tarefa_data", nullable = false)
    private LocalDate tarefaData;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;
}
