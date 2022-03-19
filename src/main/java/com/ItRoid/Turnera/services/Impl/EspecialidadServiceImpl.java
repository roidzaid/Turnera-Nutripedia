package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.entities.EspecialidadEntity;
import com.ItRoid.Turnera.entities.ProfesionalEntity;
import com.ItRoid.Turnera.models.EspecialidadModel;
import com.ItRoid.Turnera.models.ProfesionalModel;
import com.ItRoid.Turnera.repositories.EspecialidadRespository;
import com.ItRoid.Turnera.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRespository especialidadRespository;

    @Override
    public List<EspecialidadModel> buscarTodas() {

        List<EspecialidadEntity> especialidadEntities = this.especialidadRespository.findAll();

        List<EspecialidadModel> list = especialidadEntities
                .stream()
                .map((e) -> new EspecialidadModel(
                        e.getEspecialidad()))
                .collect(Collectors.toList());

        return list;

    }
}
