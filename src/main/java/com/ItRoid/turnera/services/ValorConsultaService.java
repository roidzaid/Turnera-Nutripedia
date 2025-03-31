package com.ItRoid.turnera.services;

import com.ItRoid.turnera.models.ValorConsultaModel;

import java.util.List;

public interface ValorConsultaService <T>{

    ValorConsultaModel crearValorConsulta (ValorConsultaModel valorConsultaModel);

    List<ValorConsultaModel> buscarAll (Long idProfesional);

    ValorConsultaModel buscarValorconsulta (Long idValorConsulta);

    ValorConsultaModel buscarValorconsulta (Long idProfesional, String tipo_consulta);

    ValorConsultaModel modifValorConsuta (Long idValorConsulta, ValorConsultaModel valorConsultaModel);

    void deleteValorConsulta (Long idValorConsulta);
}
