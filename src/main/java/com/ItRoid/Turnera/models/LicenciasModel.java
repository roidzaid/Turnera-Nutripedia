package com.ItRoid.Turnera.models;

public class LicenciasModel {

    private Long idLicencia;
    private Long idProfesional;
    private String diaDesde;
    private String diaHasta;
    private String motivoDeLicencia;


    public LicenciasModel() {
    }

    public LicenciasModel(Long idLicencia, Long idProfesional, String diaDesde, String diaHasta, String motivoDeLicencia) {
        this.idLicencia = idLicencia;
        this.idProfesional = idProfesional;
        this.diaDesde = diaDesde;
        this.diaHasta = diaHasta;
        this.motivoDeLicencia = motivoDeLicencia;
    }

    public Long getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Long idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getDiaDesde() {
        return diaDesde;
    }

    public void setDiaDesde(String diaDesde) {
        this.diaDesde = diaDesde;
    }

    public String getDiaHasta() {
        return diaHasta;
    }

    public void setDiaHasta(String diaHasta) {
        this.diaHasta = diaHasta;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getMotivoDeLicencia() {
        return motivoDeLicencia;
    }

    public void setMotivoDeLicencia(String motivoDeLicencia) {
        this.motivoDeLicencia = motivoDeLicencia;
    }
}
