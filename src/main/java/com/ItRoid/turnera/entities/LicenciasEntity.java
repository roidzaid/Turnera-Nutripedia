package com.ItRoid.turnera.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@TableGenerator(name = "seq", initialValue = 1000, allocationSize = 1)
@Table(name = "licencias")
public class LicenciasEntity {

    @Id
    @Column(name="idLicencia")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idLicencia;

    @Column(name="idProfesional")
    private Long idProfesional;

    @Column(name="dia")
    private String dia;

    @Column(name="diaDesde")
    private String diaDesde;

    @Column(name="diaHasta")
    private String diaHasta;

    @Column(name="motivoDeLicencia")
    private String motivoDeLicencia;


    @Column(name="diaDate")
    private Date diaDate;

    @Column(name="diaDesdeDate")
    private Date diaDesdeDate;

    @Column(name="diaHastaDate")
    private Date diaHastaDate;


    public LicenciasEntity() {
    }

    public LicenciasEntity(Long idProfesional, String dia, String diaDesde, String diaHasta, String motivoDeLicencia,Date diaDate, Date diaDesdeDate, Date diaHastaDate) {
        this.idProfesional = idProfesional;
        this.dia = dia;
        this.diaDesde = diaDesde;
        this.diaHasta = diaHasta;
        this.motivoDeLicencia = motivoDeLicencia;
        this.diaDate = diaDate;
        this.diaDesdeDate = diaDesdeDate;
        this.diaHastaDate = diaHastaDate;
    }

    public Long getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Long idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public Date getDiaDate() {
        return diaDate;
    }

    public void setDiaDate(Date diaDate) {
        this.diaDate = diaDate;
    }

    public Date getDiaDesdeDate() {
        return diaDesdeDate;
    }

    public void setDiaDesdeDate(Date diaDesdeDate) {
        this.diaDesdeDate = diaDesdeDate;
    }

    public Date getDiaHastaDate() {
        return diaHastaDate;
    }

    public void setDiaHastaDate(Date diaHastaDate) {
        this.diaHastaDate = diaHastaDate;
    }

    public String getMotivoDeLicencia() {
        return motivoDeLicencia;
    }

    public void setMotivoDeLicencia(String motivoDeLicencia) {
        this.motivoDeLicencia = motivoDeLicencia;
    }
}
