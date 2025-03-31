package com.ItRoid.turnera.services;


import com.ItRoid.turnera.models.HorariosModel;
import com.ItRoid.turnera.models.ProfesionalModel;

import java.util.List;

public interface ProfesionalesService<T>{

    ProfesionalModel crearProfesional(ProfesionalModel paciente) throws Exception;

    ProfesionalModel buscarProfesional(String dni) throws Exception;
    List<ProfesionalModel> buscarProfesionalXNomYApe(String nombre, String apellido) throws Exception;
    List<ProfesionalModel> buscarProfesionalXEspecialidad(String especialidad) throws Exception;

    ProfesionalModel buscarProfesionalxId(Long idProfesional) throws Exception;
    ProfesionalModel buscarProfesionalxUsuario(String usuario) throws Exception;

    List<ProfesionalModel> buscarProfesionalAll() throws Exception;

    ProfesionalModel modificarProfesional(ProfesionalModel profesional, Long idProfesional) throws Exception;
    void borrarProfesional(String dni) throws Exception;

    void agregarHorarios (Long idProfesional, HorariosModel horarios) throws Exception;


    void modificarUsuario(String usuario, Long idProfesional) throws Exception;

    void profesionalON(Long idProfesional) throws Exception;

    void profesionalOFF(Long idProfesional) throws Exception;


}
