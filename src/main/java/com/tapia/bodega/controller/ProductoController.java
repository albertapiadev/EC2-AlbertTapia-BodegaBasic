package com.tapia.bodega.controller;

import com.tapia.bodega.dto.request.ProductoDtoRequest;
import com.tapia.bodega.dto.response.ProductoDtoResponse;
import com.tapia.bodega.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<ProductoDtoResponse>> listarProductos() {
        return new ResponseEntity<List<ProductoDtoResponse>>(service.listarProductos(), HttpStatus.CREATED);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardar(@RequestBody ProductoDtoRequest producto) {
        service.guardarProducto(producto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ProductoDtoResponse> listarPorId(@PathVariable Integer id) {
        ProductoDtoResponse c = service.obtenerProductoId(id);
        if (c!=null)
            return new ResponseEntity<ProductoDtoResponse>(c, HttpStatus.OK);
        return new ResponseEntity<ProductoDtoResponse>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar")
    public ResponseEntity<Void> editar(@RequestBody ProductoDtoRequest producto) {
        ProductoDtoResponse c = service.obtenerProductoId(producto.getIdProductoDto());
        if (c!=null) {
            service.editarProducto(producto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ProductoDtoResponse c = service.obtenerProductoId(id);
        if (c!=null) {
            service.eliminarProducto(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
