package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.entities.EspecialidadEntity;
import com.ItRoid.Turnera.entities.TipoTurnoEntity;
import com.ItRoid.Turnera.models.EspecialidadModel;
import com.ItRoid.Turnera.models.TipoTurnoModel;
import com.ItRoid.Turnera.repositories.EspecialidadRespository;
import com.ItRoid.Turnera.repositories.TipoTurnoRespository;
import com.ItRoid.Turnera.services.EspecialidadService;
import com.ItRoid.Turnera.services.TipoTurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoTurnoServiceImpl implements TipoTurnoService {

    @Autowired
    private TipoTurnoRespository tipoTurnoRespository;

    @Override
    public List<TipoTurnoModel> buscarTodos() {

        List<TipoTurnoEntity> tipoTurnoEntities = this.tipoTurnoRespository.findAll();

        List<TipoTurnoModel> list = tipoTurnoEntities
                .stream()
                .map((e) -> new TipoTurnoModel(
                        e.getTipoTurno()))
                .collect(Collectors.toList());

        return list;
    }
}
