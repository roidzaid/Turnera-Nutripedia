package com.ItRoid.turnera.services;

import com.ItRoid.turnera.models.PrepagaModels;

import java.util.List;

public interface PrepagaService<T>{

    void altaPrepaga (PrepagaModels prepagaModels) throws Exception;
    void bajaPrepaga (Long IdPrepaga) throws Exception;
    List<PrepagaModels> buscarPrepaga (Long IdProfesional) throws Exception;
    PrepagaModels buscarPrepagaXId (Long IdPrepaga) throws Exception;


}
