package com.tapia.bodega.service;

import com.tapia.bodega.dto.request.ClienteDtoRequest;
import com.tapia.bodega.dto.response.ClienteDtoResponse;
import com.tapia.bodega.model.Cliente;
import com.tapia.bodega.repository.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    public ClienteRespository repository;

    @Override
    public void guardarCliente(ClienteDtoRequest cliente) {

        Cliente c = new Cliente();
        c.setIdCliente(cliente.getIdClienteDto());
        c.setNombre(cliente.getNombreDto());
        c.setDireccion(cliente.getDireccionDto());
        c.setDni(cliente.getDniDto());

        repository.save(c);
    }

    @Override
    public void editarCliente(ClienteDtoRequest cliente) {

        Cliente c = new Cliente();
        c.setIdCliente(cliente.getIdClienteDto());
        c.setNombre(cliente.getNombreDto());
        c.setDireccion(cliente.getDireccionDto());
        c.setDni(cliente.getDniDto());

        repository.saveAndFlush(c);

    }

    @Override
    public void eliminarCliente(Integer id) {

        repository.deleteById(id);

    }

    @Override
    public List<ClienteDtoResponse> listarClientes() {

        List<ClienteDtoResponse> lista = new ArrayList<ClienteDtoResponse>(0);
        ClienteDtoResponse c = null;

        for(Cliente cliente :repository.findAll()){
            c = new ClienteDtoResponse();
            c.setIdClienteDto(cliente.getIdCliente());
            c.setNombreDto(cliente.getNombre());
            c.setDireccionDto(cliente.getDireccion());
            c.setDniDto(cliente.getDni());

            lista.add(c);
        }

        return lista;
    }

    @Override
    public ClienteDtoResponse obtenerClienteId(Integer id) {

        Cliente cliente = repository.findById(id).orElse(null);
        ClienteDtoResponse c = new ClienteDtoResponse();

        c.setIdClienteDto(cliente.getIdCliente());
        c.setNombreDto(cliente.getNombre());
        c.setDireccionDto(cliente.getDireccion());
        c.setDniDto(cliente.getDni());

        return c;
    }
}
