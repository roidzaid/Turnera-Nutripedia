package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.entities.ValorConsultaEntity;
import com.ItRoid.Turnera.models.TipoTurnoModel;
import com.ItRoid.Turnera.models.ValorConsultaModel;
import com.ItRoid.Turnera.repositories.ValorConsultaRepository;
import com.ItRoid.Turnera.services.ValorConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValorConsultaServiceImpl implements ValorConsultaService {

    @Autowired
    private ValorConsultaRepository valorConsultaRepository;


    @Override
    public ValorConsultaModel crearValorConsulta(ValorConsultaModel valorConsultaModel) {

        ValorConsultaEntity valorConsultaEntity = new ValorConsultaEntity(
                valorConsultaModel.getIdProfesional(),
                valorConsultaModel.getTipoConsulta(),
                valorConsultaModel.getValorConsulta(),
                valorConsultaModel.getValorDeSeña()
        );

        this.valorConsultaRepository.save(valorConsultaEntity);

        return valorConsultaModel;

    }

    @Override
    public List<ValorConsultaModel> buscarAll(Long idProfesional) {

        List<ValorConsultaEntity> valorConsultaEntityList = this.valorConsultaRepository.findByIdProfesional(idProfesional);

        List<ValorConsultaModel> list = valorConsultaEntityList
                .stream()
                .map((e) -> new ValorConsultaModel(
                        e.getIdValorConsulta(),
                        e.getIdProfesional(),
                        e.getTipoConsulta(),
                        e.getValorConsulta(),
                        e.getValorDeSeña()))
                .collect(Collectors.toList());

        return list;

    }

    @Override
    public ValorConsultaModel buscarValorconsulta(Long idValorConsulta) {

        ValorConsultaEntity valorConsultaEntity = this.valorConsultaRepository.findByIdValorConsulta(idValorConsulta);

        ValorConsultaModel valorConsultaModel = new ValorConsultaModel(
                valorConsultaEntity.getIdValorConsulta(),
                valorConsultaEntity.getIdProfesional(),
                valorConsultaEntity.getTipoConsulta(),
                valorConsultaEntity.getValorConsulta(),
                valorConsultaEntity.getValorDeSeña()
        );

        return valorConsultaModel;

    }

    @Override
    public ValorConsultaModel buscarValorconsulta(Long idProfesional, String tipo_consulta) {

        ValorConsultaEntity valorConsultaEntity = this.valorConsultaRepository.findByIdValorConsulta(idProfesional, tipo_consulta);

        if (valorConsultaEntity == null){

            valorConsultaEntity = this.valorConsultaRepository.findPrimerValor(idProfesional);

        }

        ValorConsultaModel valorConsultaModel = new ValorConsultaModel(
                valorConsultaEntity.getIdValorConsulta(),
                valorConsultaEntity.getIdProfesional(),
                valorConsultaEntity.getTipoConsulta(),
                valorConsultaEntity.getValorConsulta(),
                valorConsultaEntity.getValorDeSeña()
        );

        return valorConsultaModel;
    }

    @Override
    public ValorConsultaModel modifValorConsuta(Long idValorConsulta, ValorConsultaModel valorConsultaModel) {

        ValorConsultaEntity valorConsultaEntity = this.valorConsultaRepository.findByIdValorConsulta(idValorConsulta);

        valorConsultaEntity.setTipoConsulta(valorConsultaModel.getTipoConsulta());
        valorConsultaEntity.setValorConsulta(valorConsultaModel.getValorConsulta());
        valorConsultaEntity.setValorDeSeña(valorConsultaModel.getValorDeSeña());

        this.valorConsultaRepository.save(valorConsultaEntity);

        return valorConsultaModel;

    }

    @Override
    public void deleteValorConsulta(Long idValorConsulta) {

        ValorConsultaEntity valorConsultaEntity = this.valorConsultaRepository.findByIdValorConsulta(idValorConsulta);

        this.valorConsultaRepository.delete(valorConsultaEntity);

    }
}
