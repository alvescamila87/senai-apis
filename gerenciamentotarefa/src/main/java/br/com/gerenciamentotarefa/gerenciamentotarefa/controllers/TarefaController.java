package br.com.gerenciamentotarefa.gerenciamentotarefa.controllers;

import br.com.gerenciamentotarefa.gerenciamentotarefa.dtos.TarefaDTO;
import br.com.gerenciamentotarefa.gerenciamentotarefa.services.TarefaService;
import br.com.gerenciamentotarefa.gerenciamentotarefa.services.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TarefaService tarefaService;

    @PostMapping()
    public String cadastrar(@ModelAttribute("tarefaDTO") TarefaDTO tarefaDTO){
        tarefaService.adicionarTarefa(tarefaDTO);
        return "redirect:/tarefacadastro?sucesso";

    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable("id") Long id, @ModelAttribute("tarefaDTO") TarefaDTO tarefaDTO){

        tarefaService.atualizarTarefa(id, tarefaDTO);
        return "redirect:/tarefaatualiza/" + id + "?sucesso";
    }

    @PostMapping("/status/{id}")
    public String atualizarStatus(@PathVariable("id") Long id, @RequestParam String status){

        tarefaService.atualizarStatus(id, status);
        return "redirect:/tarefagerenciar?sucesso";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        try {

           tarefaService.deletarTarefa(id);
            //-- Retorna 204 No Content para indicar que a exclusão foi bem-sucedida
            return ResponseEntity.noContent().build();

        } catch (EntityNotFoundException e) {

            // Retorna 404 Not Found se a tarefa não for encontrada
            return ResponseEntity.notFound().build();

        } catch (Exception e) {

            // Retorna 500 Internal Server Error para outros erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}
