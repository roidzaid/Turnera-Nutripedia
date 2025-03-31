package com.ItRoid.turnera.services;

import com.ItRoid.turnera.models.EspecialidadModel;

import java.util.List;

public interface EspecialidadService <T>{

    List<EspecialidadModel> buscarTodas();
    void crearEspecialidad(EspecialidadModel especialidadModel) throws Exception;
    void eliminarEspecialidad(Long idEspecialidad) throws Exception;
    EspecialidadModel buscarEspecialidad(Long idEspecialidad) throws Exception;
    void modificarEspecialidad(Long IdEspacialidad, EspecialidadModel especialidadModel) throws Exception;


}
