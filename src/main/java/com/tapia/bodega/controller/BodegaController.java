package com.tapia.bodega.controller;

import com.tapia.bodega.dto.request.BodegaDtoRequest;
import com.tapia.bodega.dto.response.BodegaDtoResponse;
import com.tapia.bodega.service.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodega")
public class BodegaController {

    @Autowired
    private BodegaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<BodegaDtoResponse>> listarBodega(){
        return new ResponseEntity<List<BodegaDtoResponse>>(service.listarBodegas(), HttpStatus.CREATED);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardar(@RequestBody BodegaDtoRequest bodega){
        service.guardarBodega(bodega);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<BodegaDtoResponse> listarPorId(@PathVariable Integer id){
        BodegaDtoResponse b = service.obtenerBodegaId(id);
        if (b != null)
            return new ResponseEntity<BodegaDtoResponse>(b, HttpStatus.OK);
        return new ResponseEntity<BodegaDtoResponse>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar")
    public ResponseEntity<Void> editar(@RequestBody BodegaDtoRequest bodega){
        BodegaDtoResponse b = service.obtenerBodegaId(bodega.getIdBodegaDto());
        if(b != null){
            service.editarBodega(bodega);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        BodegaDtoResponse b = service.obtenerBodegaId(id);
        if (b != null) {
            service.eliminarBodega(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
