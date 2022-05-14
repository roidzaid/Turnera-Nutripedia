package com.ItRoid.Turnera.services;

import com.ItRoid.Turnera.entities.FeriadosEntity;

import java.util.List;

public interface  FeriadosService <T>{

    void crearFeriado(FeriadosEntity feriadosEntity);

    List<FeriadosEntity> listarFeriados();

    boolean buscarFeriado(String fecha);

}
