package com.ItRoid.Turnera.services;

import com.ItRoid.Turnera.models.AsignarTurnoModel;
import com.ItRoid.Turnera.models.TurnoAsignadoModel;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

public interface TurnosService<T>{

    TurnoAsignadoModel asignarTurno(AsignarTurnoModel asignarTurnoModel) throws ParseException;

    List<TurnoAsignadoModel> turnosDisponibles(String fecha, Long idConfiguracionturno) throws Exception;

    List<TurnoAsignadoModel> misTurnos(String dni_Paciente) throws Exception;

    List<TurnoAsignadoModel> agenda(Long idProfesional) throws Exception;

    List<TurnoAsignadoModel> agenda(Long idProfesional, String fecha) throws Exception;

    List<TurnoAsignadoModel> agendaGeneral() throws Exception;

    List<TurnoAsignadoModel> agendaGeneral(String fecha) throws Exception;

    void cancelarTurno(Long idTurnoAsignado) throws Exception;

    TurnoAsignadoModel buscarTurno(Long idTurnoAsignado) throws Exception;

    void marcarCobroSeña(Long idTurnoAsignado) throws Exception;

    void marcarEstadoSeña(Long idTurnoAsignado, String idPagaMP, String estadoPago) throws Exception;


}
