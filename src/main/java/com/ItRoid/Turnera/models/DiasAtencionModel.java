package com.ItRoid.Turnera.models;

import com.ItRoid.Turnera.entities.ProfesionalEntity;

import javax.persistence.*;
import java.util.Date;

public class DiasAtencionModel {

    private Long idHorario;
    private Date fechaAlta;
    private String diaDeSemana;
    private String tipoTurno;
    private String horaDesde;
    private String horaHasta;
    private int duracionTurnos;
    private String fechaHorarioEventual;

    public DiasAtencionModel() {
    }

    public DiasAtencionModel(Long idHorario, Date fechaAlta, String diaDeSemana, String tipoTurno, String horaDesde, String horaHasta, int duracionTurnos, String fechaHorarioEventual) {
        this.idHorario = idHorario;
        this.fechaAlta = fechaAlta;
        this.diaDeSemana = diaDeSemana;
        this.tipoTurno = tipoTurno;
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
        this.duracionTurnos = duracionTurnos;
        this.fechaHorarioEventual = fechaHorarioEventual;
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDiaDeSemana() {
        return diaDeSemana;
    }

    public void setDiaDeSemana(String diaDeSemana) {
        this.diaDeSemana = diaDeSemana;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public String getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(String horaDesde) {
        this.horaDesde = horaDesde;
    }

    public String getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(String horaHasta) {
        this.horaHasta = horaHasta;
    }

    public int getDuracionTurnos() {
        return duracionTurnos;
    }

    public void setDuracionTurnos(int duracionTurnos) {
        this.duracionTurnos = duracionTurnos;
    }

    public String getFechaHorarioEventual() {
        return fechaHorarioEventual;
    }

    public void setFechaHorarioEventual(String fechaHorarioEventual) {
        this.fechaHorarioEventual = fechaHorarioEventual;
    }
}
