package com.tapia.bodega.service;

import com.tapia.bodega.dto.request.BodegaDtoRequest;
import com.tapia.bodega.dto.response.BodegaDtoResponse;
import com.tapia.bodega.model.Bodega;
import com.tapia.bodega.repository.BodegaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BodegaServiceImpl implements BodegaService {

    @Autowired
    public BodegaRepository repository;


    @Override
    public void guardarBodega(BodegaDtoRequest bodega) {

        Bodega b = new Bodega();
        b.setIdBodega(bodega.getIdBodegaDto());
        b.setNombre(bodega.getNombreDto());
        b.setDireccion(bodega.getDireccionDto());

        repository.save(b);

    }

    @Override
    public void editarBodega(BodegaDtoRequest bodega) {

        Bodega b = new Bodega();
        b.setIdBodega(bodega.getIdBodegaDto());
        b.setNombre(bodega.getNombreDto());
        b.setDireccion(bodega.getDireccionDto());

        repository.saveAndFlush(b);

    }

    @Override
    public void eliminarBodega(Integer id) {

        repository.deleteById(id);

    }

    @Override
    public List<BodegaDtoResponse> listarBodegas() {

        List<BodegaDtoResponse> lista = new ArrayList<BodegaDtoResponse>(0);
        BodegaDtoResponse b = null;

        for(Bodega bodega :repository.findAll()){
            b = new BodegaDtoResponse();
            b.setIdBodegaDto(bodega.getIdBodega());
            b.setNombreDto(bodega.getNombre());
            b.setDireccionDto(bodega.getDireccion());

            lista.add(b);
        }

        return lista;

    }

    @Override
    public BodegaDtoResponse obtenerBodegaId(Integer id) {

        Bodega bodega = repository.findById(id).orElse(null);
        BodegaDtoResponse b = new BodegaDtoResponse();

        b.setIdBodegaDto(bodega.getIdBodega());
        b.setNombreDto(bodega.getNombre());
        b.setDireccionDto(bodega.getDireccion());

        return b;

    }
}


