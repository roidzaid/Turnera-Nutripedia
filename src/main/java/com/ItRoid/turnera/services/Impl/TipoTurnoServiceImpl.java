package com.ItRoid.turnera.services.Impl;

import com.ItRoid.turnera.entities.TipoTurnoEntity;
import com.ItRoid.turnera.models.TipoTurnoModel;
import com.ItRoid.turnera.repositories.TipoTurnoRespository;
import com.ItRoid.turnera.services.TipoTurnoService;
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
