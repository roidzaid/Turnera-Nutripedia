package com.ItRoid.Turnera.services;


import com.ItRoid.Turnera.models.HorariosModel;
import com.ItRoid.Turnera.models.ProfesionalModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
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


}
