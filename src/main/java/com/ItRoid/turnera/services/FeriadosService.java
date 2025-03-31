package com.ItRoid.turnera.services;

import com.ItRoid.turnera.entities.FeriadosEntity;

import java.util.List;

public interface  FeriadosService <T>{

    void crearFeriado(FeriadosEntity feriadosEntity);

    List<FeriadosEntity> listarFeriados();

    boolean buscarFeriado(String fecha);

}
