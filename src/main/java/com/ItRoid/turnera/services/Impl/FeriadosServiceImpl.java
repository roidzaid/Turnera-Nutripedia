package com.ItRoid.turnera.services.Impl;

import com.ItRoid.turnera.entities.FeriadosEntity;
import com.ItRoid.turnera.repositories.FeriadosRepository;
import com.ItRoid.turnera.services.FeriadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeriadosServiceImpl implements FeriadosService {

    @Autowired
    private FeriadosRepository feriadosRepository;

    @Override
    public void crearFeriado(FeriadosEntity feriadosEntity) {

        this.feriadosRepository.save(feriadosEntity);

    }

    @Override
    public List<FeriadosEntity> listarFeriados() {

        List<FeriadosEntity> feriados = this.feriadosRepository.findAll();

        return feriados;

    }

    @Override
    public boolean buscarFeriado(String fecha) {

        List<FeriadosEntity> feriados = this.feriadosRepository.findAll();

        boolean esFeriado = false;

        for (int i=0;i<feriados.size();i++) {

            if(feriados.get(i).getFecha().equals(fecha)){
                esFeriado = true;
            }

        }

        return esFeriado;
    }
}
