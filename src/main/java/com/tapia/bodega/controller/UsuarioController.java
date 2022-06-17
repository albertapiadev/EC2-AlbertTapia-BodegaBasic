package com.tapia.bodega.controller;

import com.tapia.bodega.dto.request.UsuarioDtoRequest;
import com.tapia.bodega.dto.response.UsuarioDtoResponse;
import com.tapia.bodega.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDtoResponse>> listarUsuarios() {
        return new ResponseEntity<List<UsuarioDtoResponse>>(service.listarUsuarios(), HttpStatus.CREATED);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardar(@RequestBody UsuarioDtoRequest usuario) {
        service.guardarUsuario(usuario);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioDtoResponse> listarPorId(@PathVariable Integer id) {
        UsuarioDtoResponse u = service.obtenerUsuarioId(id);
        if (u!=null)
            return new ResponseEntity<UsuarioDtoResponse>(u, HttpStatus.OK);
        return new ResponseEntity<UsuarioDtoResponse>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar")
    public ResponseEntity<Void> editar(@RequestBody UsuarioDtoRequest usuario) {
        UsuarioDtoResponse u = service.obtenerUsuarioId(usuario.getIdUsuarioDto());
        if (u!=null) {
            service.editarUsuario(usuario);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        UsuarioDtoResponse u = service.obtenerUsuarioId(id);
        if (u!=null) {
            service.eliminarUsuario(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }



}
