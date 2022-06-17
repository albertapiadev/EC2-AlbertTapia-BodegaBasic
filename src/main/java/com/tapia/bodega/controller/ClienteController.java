package com.tapia.bodega.controller;

import com.tapia.bodega.dto.request.ClienteDtoRequest;
import com.tapia.bodega.dto.response.ClienteDtoResponse;
import com.tapia.bodega.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDtoResponse>> listarClientes() {
        return new ResponseEntity<List<ClienteDtoResponse>>(service.listarClientes(), HttpStatus.CREATED);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardar(@RequestBody ClienteDtoRequest cliente) {
        service.guardarCliente(cliente);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ClienteDtoResponse> listarPorId(@PathVariable Integer id) {
        ClienteDtoResponse c = service.obtenerClienteId(id);
        if (c!=null)
            return new ResponseEntity<ClienteDtoResponse>(c, HttpStatus.OK);
        return new ResponseEntity<ClienteDtoResponse>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar")
    public ResponseEntity<Void> editar(@RequestBody ClienteDtoRequest cliente) {
        ClienteDtoResponse c = service.obtenerClienteId(cliente.getIdClienteDto());
        if (c!=null) {
            service.editarCliente(cliente);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ClienteDtoResponse c = service.obtenerClienteId(id);
        if (c!=null) {
            service.eliminarCliente(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }



}
