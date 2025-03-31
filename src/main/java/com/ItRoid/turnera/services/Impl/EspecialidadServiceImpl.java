package com.ItRoid.turnera.services.Impl;

import com.ItRoid.turnera.entities.EspecialidadEntity;
import com.ItRoid.turnera.models.EspecialidadModel;
import com.ItRoid.turnera.repositories.EspecialidadRespository;
import com.ItRoid.turnera.services.EspecialidadService;
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
                        e.getIdEspecialidad(),
                        e.getEspecialidad()))
                .collect(Collectors.toList());

        return list;

    }

    @Override
    public void crearEspecialidad(EspecialidadModel especialidadModel) throws Exception {

        EspecialidadEntity especialidadEntity = this.especialidadRespository.findByIdEspecialidad(especialidadModel.getEspecialidad());

        if (especialidadEntity == null) {
            EspecialidadEntity e = new EspecialidadEntity(
                    especialidadModel.getEspecialidad()
            );

            this.especialidadRespository.save(e);

        }else{
        throw new Exception("Ya fue dada de alta " + especialidadEntity.getEspecialidad());
    }

    }

    @Override
    public void eliminarEspecialidad(Long idEspecialidad) throws Exception {

        EspecialidadEntity especialidadEntity = this.especialidadRespository.findByIdEspecialidad(idEspecialidad);

        if (especialidadEntity != null) {

            this.especialidadRespository.delete(especialidadEntity);

        }else{
            throw new Exception("No existe especialidad " + idEspecialidad);
        }

    }

    @Override
    public EspecialidadModel buscarEspecialidad(Long idEspecialidad) throws Exception {

        EspecialidadEntity especialidadEntity = this.especialidadRespository.findByIdEspecialidad(idEspecialidad);

        if (especialidadEntity != null) {

            EspecialidadModel especialidadModel = new EspecialidadModel(
                    especialidadEntity.getIdEspecialidad(),
                    especialidadEntity.getEspecialidad());

            return especialidadModel;

        }else{
            throw new Exception("No existe especialidad " + idEspecialidad);
        }
    }

    @Override
    public void modificarEspecialidad(Long idEspecialidad, EspecialidadModel especialidadModel) throws Exception {

        EspecialidadEntity especialidadEntity = this.especialidadRespository.findByIdEspecialidad(idEspecialidad);

        if (especialidadEntity == null) {
            especialidadEntity.setEspecialidad(especialidadModel.getEspecialidad());

            this.especialidadRespository.save(especialidadEntity);

        }else{
            throw new Exception("No existe especialidad " + especialidadEntity.getEspecialidad());
        }
    }
}
