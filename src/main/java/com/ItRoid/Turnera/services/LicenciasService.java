package com.ItRoid.Turnera.services;

import com.ItRoid.Turnera.entities.LicenciasEntity;
import com.ItRoid.Turnera.models.LicenciasModel;

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
