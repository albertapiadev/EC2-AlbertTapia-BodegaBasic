package com.tapia.bodega.service;

import com.tapia.bodega.dto.request.UsuarioDtoRequest;
import com.tapia.bodega.dto.response.UsuarioDtoResponse;

import java.util.List;

public interface UsuarioService {

    public void guardarUsuario(UsuarioDtoRequest usuario);
    public void editarUsuario(UsuarioDtoRequest usuario);
    public void eliminarUsuario(Integer id);
    public List<UsuarioDtoResponse> listarUsuarios();
    public UsuarioDtoResponse obtenerUsuarioId(Integer id);

}
