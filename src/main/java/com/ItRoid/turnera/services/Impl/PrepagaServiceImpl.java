package com.ItRoid.turnera.services.Impl;

import com.ItRoid.turnera.entities.PrepagaEntity;
import com.ItRoid.turnera.models.PrepagaModels;
import com.ItRoid.turnera.repositories.PrepagaRepository;
import com.ItRoid.turnera.services.PrepagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrepagaServiceImpl implements PrepagaService {


    @Autowired
    private PrepagaRepository prepagaRepository;

    @Override
    public void altaPrepaga(PrepagaModels prepagaModels) throws Exception {

        PrepagaEntity prepaga = this.prepagaRepository.getByPrepagaProf(prepagaModels.getPrepaga(), prepagaModels.getIdProfesional());

        if (prepaga == null) {

            PrepagaEntity prepagaEntity = new PrepagaEntity(
                    prepagaModels.getPrepaga(),
                    prepagaModels.getIdProfesional()
            );

            this.prepagaRepository.save(prepagaEntity);

        }else{
            throw new Exception("Ya fue dada de alta la prepaga " + prepagaModels.getPrepaga() + " para el profesional " + prepagaModels.getIdProfesional());
        }
    }

    @Override
    public void bajaPrepaga(Long IdPrepaga) throws Exception {

        PrepagaEntity os = this.prepagaRepository.getById(IdPrepaga);

        if (os != null) {

            this.prepagaRepository.delete(os);

        }else{
            throw new Exception("Ya fue dada de baja la prepaga");
        }
    }

    @Override
    public List<PrepagaModels> buscarPrepaga(Long idProfesional) throws Exception {

        List<PrepagaEntity> prepaga = this.prepagaRepository.getByProfesinal(idProfesional);

        if (prepaga != null) {

            List<PrepagaModels> list = prepaga
                    .stream()
                    .map((e) -> new PrepagaModels(
                            e.getIdPrepaga(),
                            e.getPrepaga(),
                            e.getIdProfesional()))
                    .collect(Collectors.toList());

            return list;

        }else{
            throw new Exception("El profesional no tiene prepagas cargadas");
        }

    }

    @Override
    public PrepagaModels buscarPrepagaXId(Long IdPrepaga) throws Exception {

        PrepagaEntity prepaga = this.prepagaRepository.getById(IdPrepaga);

        if (prepaga != null) {

            PrepagaModels prepagaModels = new PrepagaModels(
                    prepaga.getIdPrepaga(),
                    prepaga.getPrepaga(),
                    prepaga.getIdProfesional());

            return prepagaModels;

        }else{
            throw new Exception("La relacion de prepaga profecional no existe");
        }

    }
}
