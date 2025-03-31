package com.ItRoid.turnera.models;

public class TurnosDisponiblesModel {

    private Long idConfiguracionTurnos;
    private String diaSemana;
    private String fecha;
    private String hora;

    public TurnosDisponiblesModel() {
    }

    public TurnosDisponiblesModel(Long idConfiguracionTurnos, String diaSemana, String fecha, String hora) {
        this.idConfiguracionTurnos = idConfiguracionTurnos;
        this.diaSemana = diaSemana;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Long getIdConfiguracionTurnos() {
        return idConfiguracionTurnos;
    }

    public void setIdConfiguracionTurnos(Long idConfiguracionTurnos) {
        this.idConfiguracionTurnos = idConfiguracionTurnos;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
