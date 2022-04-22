package com.ItRoid.Turnera.services;

import com.ItRoid.Turnera.models.AsignarTurnoModel;
import com.ItRoid.Turnera.models.TurnoAsignadoModel;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

public interface TurnosService<T>{

    void asignarTurno(AsignarTurnoModel asignarTurnoModel) throws ParseException;

    List<TurnoAsignadoModel> turnosDisponibles(String fecha, Long idConfiguracionturno) throws Exception;

    List<TurnoAsignadoModel> misTurnos(String dni_Paciente) throws Exception;

    List<TurnoAsignadoModel> agenda(Long idProfesional) throws Exception;

    void cancelarTurno(Long idTurnoAsignado) throws Exception;

    TurnoAsignadoModel buscarTurno(Long idTurnoAsignado) throws Exception;




}
