package com.ItRoid.turnera.services;

import com.ItRoid.turnera.models.*;

import java.util.List;

public interface HorariosService <T>{

    void borrarHorario (Long idHorario) throws Exception;

    HorariosModel modificarHorario (Long idHorario, HorariosModel horariosModel) throws Exception;

    List<String> buscarConfiguracionTurnos(Long idHorario) throws Exception;

    HorariosModel buscarHorariosXId(Long idHorario) throws Exception;

    List<DiasDisponiblesModel> BuscarHorarios (Long idProfesional, String tipoTurno) throws Exception;

    List<DiasAtencionModel> BuscarHorarios (Long idProfesional) throws Exception;

    List<DiasAtencionModel> BuscarHorariosParaTarjeta (Long idProfesional) throws Exception;

    List<String> buscarTiposDeTurno(Long idProfesional) throws Exception;

    ConfiguracionTurnoModel buscarConfiguracionDeTurno(Long idConfiguracionTurno) throws Exception;

    boolean esEventual(Long idProfesional, String fecha, String tipoTurno);
}
