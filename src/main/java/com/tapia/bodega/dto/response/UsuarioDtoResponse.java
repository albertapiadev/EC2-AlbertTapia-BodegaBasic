package com.tapia.bodega.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDtoResponse {

    private Integer idUsuarioDto;
    private String usuarioDto;
    private String passwordDto;
    private String rolDto;

}
