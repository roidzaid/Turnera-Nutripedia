package com.ItRoid.Turnera.models;

public class AsignarTurnoModel {

    private Long idConfiguracionTurno;
    private String fecha;
    private Long idProfesional;
    private String especialidad;
    private Long idPaciente;

    public AsignarTurnoModel() {
    }

    public AsignarTurnoModel(Long idConfiguracionTurno, String fecha, Long idProfesional, String especialidad, Long idPaciente) {
        this.idConfiguracionTurno = idConfiguracionTurno;
        this.fecha = fecha;
        this.idProfesional = idProfesional;
        this.especialidad = especialidad;
        this.idPaciente = idPaciente;
    }

    public Long getIdConfiguracionTurno() {
        return idConfiguracionTurno;
    }

    public void setIdConfiguracionTurno(Long idConfiguracionTurno) {
        this.idConfiguracionTurno = idConfiguracionTurno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}
