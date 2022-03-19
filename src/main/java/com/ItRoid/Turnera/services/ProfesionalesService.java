package com.ItRoid.Turnera.services;


import com.ItRoid.Turnera.models.HorariosModel;
import com.ItRoid.Turnera.models.ProfesionalModel;

import java.util.List;

public interface ProfesionalesService<T>{

    ProfesionalModel crearProfesional(ProfesionalModel paciente) throws Exception;

    ProfesionalModel buscarProfesional(String dni) throws Exception;
    List<ProfesionalModel> buscarProfesionalXNomYApe(String nombre, String apellido) throws Exception;
    List<ProfesionalModel> buscarProfesionalXEspecialidad(String especialidad) throws Exception;

    ProfesionalModel buscarProfesionalxId(Long idProfesional) throws Exception;

    List<ProfesionalModel> buscarProfesionalAll() throws Exception;

    ProfesionalModel modificarProfesional(ProfesionalModel profesional, String dni) throws Exception;
    void borrarProfesional(String dni) throws Exception;

    void agregarHorarios (String dni, HorariosModel horarios) throws Exception;

}
