package com.senai.user_database.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaUsuarioDTO {

    private Long id;
    private String nome;
    private String login;

    /* Opção 1 e Opção 2
    public ListaUsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
    }*/

    /**
     * Modo avançado - Opção 1
     * //    public static List<ListaUsuarioDTO> of(List<Usuario> usuarios) {
     * //        return usuarios.stream().map(ListaUsuarioDTO::new).collect(Collectors.toList());
     * //    }
     */
    /* - Opção 2
    public static List<ListaUsuarioDTO> converterDe(List<Usuario> listaUsuariosModel) {
        List<ListaUsuarioDTO> listaUsuarioDTOS = new ArrayList<>();

        for(Usuario usuario : listaUsuariosModel) {
            ListaUsuarioDTO usuarioDTO = new ListaUsuarioDTO(usuario);
            listaUsuarioDTOS.add(usuarioDTO);
        }
        return listaUsuarioDTOS;
    }
     */
}
