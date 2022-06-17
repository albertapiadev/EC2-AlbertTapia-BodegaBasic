package com.tapia.bodega.service;

import com.tapia.bodega.dto.request.ProductoDtoRequest;
import com.tapia.bodega.dto.response.ProductoDtoResponse;
import com.tapia.bodega.model.Producto;
import com.tapia.bodega.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    public ProductoRepository repository;

    @Override
    public void guardarProducto(ProductoDtoRequest producto) {

        Producto p = new Producto();
        p.setIdProducto(producto.getIdProductoDto());
        p.setProducto(producto.getProductoDto());
        p.setDescripcion(producto.getDescripcionDto());
        p.setPrecio(producto.getPrecioDto());
        p.setStock(producto.getStockDto());

        repository.save(p);

    }

    @Override
    public void editarProducto(ProductoDtoRequest producto) {

        Producto p = new Producto();
        p.setIdProducto(producto.getIdProductoDto());
        p.setProducto(producto.getProductoDto());
        p.setDescripcion(producto.getDescripcionDto());
        p.setPrecio(producto.getPrecioDto());
        p.setStock(producto.getStockDto());

        repository.saveAndFlush(p);

    }

    @Override
    public void eliminarProducto(Integer id) {

        repository.deleteById(id);

    }

    @Override
    public List<ProductoDtoResponse> listarProductos() {

        List<ProductoDtoResponse> lista = new ArrayList<ProductoDtoResponse>(0);
        ProductoDtoResponse p = null;

        for(Producto producto :repository.findAll()){
            p = new ProductoDtoResponse();
            p.setIdProductoDto(producto.getIdProducto());
            p.setProductoDto(producto.getProducto());
            p.setDescripcionDto(producto.getDescripcion());
            p.setPrecioDto(producto.getPrecio());
            p.setStockDto(producto.getStock());

            lista.add(p);
        }

        return lista;
    }

    @Override
    public ProductoDtoResponse obtenerProductoId(Integer id) {

        Producto producto = repository.findById(id).orElse(null);
        ProductoDtoResponse p = new ProductoDtoResponse();

        p.setIdProductoDto(producto.getIdProducto());
        p.setProductoDto(producto.getProducto());
        p.setDescripcionDto(producto.getDescripcion());
        p.setPrecioDto(producto.getPrecio());
        p.setStockDto(producto.getStock());

        return p;
    }
}
