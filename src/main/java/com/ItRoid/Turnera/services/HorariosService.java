package com.ItRoid.Turnera.services;

import com.ItRoid.Turnera.models.ConfiguracionTurnoModel;
import com.ItRoid.Turnera.models.DiasDisponiblesModel;
import com.ItRoid.Turnera.models.HorariosModel;

import java.util.List;

public interface HorariosService <T>{

    void borrarHorario (Long idHorario) throws Exception;
    void modificarHorario (Long idHorario, HorariosModel horariosModel) throws Exception;

    List<String> buscarConfiguracionTurnos(Long idHorario) throws Exception;
    List<DiasDisponiblesModel> BuscarHorarios (Long idConsultorio, String tipoTurno) throws Exception;

    List<String> buscarTiposDeTurno(Long idProfesional) throws Exception;

    ConfiguracionTurnoModel buscarConfiguracionDeTurno(Long idConfiguracionTurno) throws Exception;
}
