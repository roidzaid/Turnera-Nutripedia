package com.ItRoid.Turnera.models;

public class DiasDisponiblesModel {

    private Long idHorario;
    private String diaSemana;
    private String fecha;

    public DiasDisponiblesModel() {
    }

    public DiasDisponiblesModel(Long idHorario, String diaSemana, String fecha) {
        this.idHorario = idHorario;
        this.diaSemana = diaSemana;
        this.fecha = fecha;
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
