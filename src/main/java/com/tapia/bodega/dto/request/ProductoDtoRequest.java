package com.tapia.bodega.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDtoRequest {

    private Integer idProductoDto;
    private String productoDto;
    private String descripcionDto;
    private String precioDto;
    private String stockDto;
}
