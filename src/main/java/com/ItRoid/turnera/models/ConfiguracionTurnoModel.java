package com.ItRoid.turnera.models;

public class ConfiguracionTurnoModel {

    private Long idConfiguracionTurno;
    private String hora;

    public ConfiguracionTurnoModel() {
    }

    public ConfiguracionTurnoModel(Long idConfiguracionTurno, String hora) {
        this.idConfiguracionTurno = idConfiguracionTurno;
        this.hora = hora;
    }

    public Long getIdConfiguracionTurno() {
        return idConfiguracionTurno;
    }

    public void setIdConfiguracionTurno(Long idConfiguracionTurno) {
        this.idConfiguracionTurno = idConfiguracionTurno;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
