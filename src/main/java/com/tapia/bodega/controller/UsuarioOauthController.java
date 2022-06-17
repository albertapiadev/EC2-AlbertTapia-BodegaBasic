package com.tapia.bodega.controller;

import com.tapia.bodega.dto.request.UsuarioOauthDtoRequest;
import com.tapia.bodega.dto.response.UsuarioOauthDtoResponse;
import com.tapia.bodega.security.JwtUtil;
import com.tapia.bodega.security.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioOauthController {

    @Autowired
    private JwtUtil util;

    @Autowired
    private UserDetailService service;

    @PostMapping(path = "/crearToken")
    public ResponseEntity<?> crearToken(@RequestBody UsuarioOauthDtoRequest dto){

        UserDetails detail = service.loadUserByUsername(dto.getUsuario());

        return ResponseEntity.ok(new UsuarioOauthDtoResponse(util.generateToken(detail.getUsername())));
    }



}
