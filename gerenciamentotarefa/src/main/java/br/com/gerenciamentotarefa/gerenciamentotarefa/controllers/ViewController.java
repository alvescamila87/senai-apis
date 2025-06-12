package br.com.gerenciamentotarefa.gerenciamentotarefa.controllers;

import br.com.gerenciamentotarefa.gerenciamentotarefa.dtos.TarefaDTO;
import br.com.gerenciamentotarefa.gerenciamentotarefa.dtos.UsuarioDTO;
import br.com.gerenciamentotarefa.gerenciamentotarefa.services.TarefaService;
import br.com.gerenciamentotarefa.gerenciamentotarefa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ViewController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TarefaService tarefaService;


    @GetMapping
    public String index(Model model) {
        return "redirect:/tarefagerenciar";
    }

//    @GetMapping("/usuariocadastro")
//    public String cadastrarUsuario(Model model){
//        model.addAttribute("usuarioDTO", new UsuarioDTO());
//        return "usuariocadastro";
//    }

    @GetMapping("/tarefacadastro")
    public String cadastrarTarefa(Model model){
        TarefaDTO tarefaDTO = new TarefaDTO();
        model.addAttribute("tarefaDTO", new TarefaDTO());
        model.addAttribute("usuarios",usuarioService.listarUsuarios());
        return "tarefacadastro";
    }

    @GetMapping("/tarefagerenciar")
    public String tarefaGerenciar(Model model){

        model.addAttribute("tarefas", tarefaService.listaTarefas());
        return "tarefagerenciar";
    }

    @GetMapping("/tarefaatualiza/{id}")
    public String tarefaGerenciar(Model model, @PathVariable Long id){

        TarefaDTO tarefaDTO = tarefaService.obterTarefaPorId(id);

        if (tarefaDTO.getId()==0){
            return "redirect:/tarefagerenciar";
        }

        model.addAttribute("tarefaId", tarefaDTO.getId());
        model.addAttribute("usuarioSelecionado", tarefaDTO.getUsuario().getUsuarioId());
        model.addAttribute("prioridadeSelecionada", tarefaDTO.getPrioridade());
        model.addAttribute("usuarios",usuarioService.listarUsuarios());
        model.addAttribute("tarefaDTO", tarefaDTO);

        return "tarefaatualiza";
    }
}
