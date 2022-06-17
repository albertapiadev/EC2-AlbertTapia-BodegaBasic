package com.tapia.bodega.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDtoRequest {

    private Integer idClienteDto;
    private String nombreDto;
    private String direccionDto;
    private String dniDto;
}
