package com.tapia.bodega.service;

import com.tapia.bodega.dto.request.BodegaDtoRequest;
import com.tapia.bodega.dto.response.BodegaDtoResponse;

import java.util.List;

public interface BodegaService {

    public void guardarBodega(BodegaDtoRequest bodega);
    public void editarBodega(BodegaDtoRequest bodega);
    public void eliminarBodega(Integer id);
    public List<BodegaDtoResponse> listarBodegas();
    public BodegaDtoResponse obtenerBodegaId(Integer id);
}
