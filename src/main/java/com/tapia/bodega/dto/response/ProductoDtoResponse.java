package com.tapia.bodega.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDtoResponse {

    private Integer idProductoDto;
    private String productoDto;
    private String descripcionDto;
    private String precioDto;
    private String stockDto;
}
