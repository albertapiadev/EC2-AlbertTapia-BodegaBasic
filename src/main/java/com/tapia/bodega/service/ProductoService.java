package com.tapia.bodega.service;

import com.tapia.bodega.dto.request.ProductoDtoRequest;
import com.tapia.bodega.dto.response.ProductoDtoResponse;

import java.util.List;

public interface ProductoService {

    public void guardarProducto(ProductoDtoRequest producto);
    public void editarProducto(ProductoDtoRequest producto);
    public void eliminarProducto(Integer id);
    public List<ProductoDtoResponse> listarProductos();
    public ProductoDtoResponse obtenerProductoId(Integer id);
}
