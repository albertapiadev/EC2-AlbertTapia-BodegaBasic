package com.tapia.bodega.service;

import com.tapia.bodega.dto.request.ClienteDtoRequest;
import com.tapia.bodega.dto.response.ClienteDtoResponse;

import java.util.List;

public interface ClienteService {

    public void guardarCliente(ClienteDtoRequest cliente);
    public void editarCliente(ClienteDtoRequest cliente);
    public void eliminarCliente(Integer id);
    public List<ClienteDtoResponse> listarClientes();
    public ClienteDtoResponse obtenerClienteId(Integer id);
}
