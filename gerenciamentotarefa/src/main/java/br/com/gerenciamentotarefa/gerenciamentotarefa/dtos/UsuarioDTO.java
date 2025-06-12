package br.com.gerenciamentotarefa.gerenciamentotarefa.dtos;

import br.com.gerenciamentotarefa.gerenciamentotarefa.entities.UsuarioEntity;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;

    public static  UsuarioDTO of(UsuarioEntity usuarioEntity) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioEntity.getUsuarioId());
        usuarioDTO.setNome(usuarioEntity.getUsuarioNome());
        usuarioDTO.setEmail(usuarioEntity.getUsuarioEmail());

        return usuarioDTO;
    }
}
