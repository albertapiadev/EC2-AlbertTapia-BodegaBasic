package com.tapia.bodega.service;

import com.tapia.bodega.dto.request.UsuarioDtoRequest;
import com.tapia.bodega.dto.response.UsuarioDtoResponse;
import com.tapia.bodega.model.Usuario;
import com.tapia.bodega.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    public UsuarioRepository repository;

    @Override
    public void guardarUsuario(UsuarioDtoRequest usuario) {

        Usuario u = new Usuario();
        u.setIdUsuario(usuario.getIdUsuarioDto());
        u.setUsuario(usuario.getUsuarioDto());
        u.setPassword(usuario.getPasswordDto());
        u.setRol(usuario.getRolDto());

        repository.save(u);

    }

    @Override
    public void editarUsuario(UsuarioDtoRequest usuario) {

        Usuario u = new Usuario();
        u.setIdUsuario(usuario.getIdUsuarioDto());
        u.setUsuario(usuario.getUsuarioDto());
        u.setPassword(usuario.getPasswordDto());
        u.setRol(usuario.getRolDto());

        repository.saveAndFlush(u);

    }

    @Override
    public void eliminarUsuario(Integer id) {

        repository.deleteById(id);

    }

    @Override
    public List<UsuarioDtoResponse> listarUsuarios() {

        List<UsuarioDtoResponse> lista = new ArrayList<UsuarioDtoResponse>(0);
        UsuarioDtoResponse u = null;

        for(Usuario usuario : repository.findAll()) {
            u = new UsuarioDtoResponse();
            u.setIdUsuarioDto(usuario.getIdUsuario());
            u.setUsuarioDto(usuario.getUsuario());
            u.setPasswordDto(usuario.getPassword());
            u.setRolDto(usuario.getRol());
            lista.add(u);
        }

        return lista;
    }

    @Override
    public UsuarioDtoResponse obtenerUsuarioId(Integer id) {

        Usuario usuario = repository.findById(id).orElse(null);
        UsuarioDtoResponse u = new UsuarioDtoResponse();

        u.setIdUsuarioDto(usuario.getIdUsuario());
        u.setUsuarioDto(usuario.getUsuario());
        u.setPasswordDto(usuario.getPassword());
        u.setRolDto(usuario.getRol());

        return u;
    }
}
