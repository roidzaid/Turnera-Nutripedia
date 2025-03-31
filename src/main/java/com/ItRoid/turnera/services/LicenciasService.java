package com.ItRoid.turnera.services;

import com.ItRoid.turnera.entities.LicenciasEntity;
import com.ItRoid.turnera.models.LicenciasModel;

import java.text.ParseException;
import java.util.List;

public interface LicenciasService <T>{

    LicenciasModel altaLicencia (LicenciasModel licenciasModel) throws ParseException;

    List<LicenciasEntity> buscarLicencias(Long idProfesional) throws ParseException;

    boolean buscarDiaEnLicencias(Long idProfesional, String dia);

    LicenciasModel buscarLicencia(Long idProfesional, Long idLicencia) throws ParseException;

    LicenciasModel modifLicencia(Long idProfesional, Long idLicencia, LicenciasModel licenciasModel) throws ParseException;

    void deleteLicencia(Long idProfesional, Long idLicencia) throws ParseException;


}
