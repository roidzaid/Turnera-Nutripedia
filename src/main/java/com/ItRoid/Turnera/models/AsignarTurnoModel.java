package com.ItRoid.Turnera.models;

public class AsignarTurnoModel {

    private Long idConfiguracionTurno;
    private String fecha;
    private Long idProfesional;
    private String especialidad;
    private Long idPaciente;
    private String tipoConsulta;
    private String motivoConsulta;

    public AsignarTurnoModel() {
    }

    public AsignarTurnoModel(Long idConfiguracionTurno, String fecha, Long idProfesional, String especialidad, Long idPaciente,String tipoConsulta, String motivoConsulta) {
        this.idConfiguracionTurno = idConfiguracionTurno;
        this.fecha = fecha;
        this.idProfesional = idProfesional;
        this.especialidad = especialidad;
        this.idPaciente = idPaciente;
        this.tipoConsulta = tipoConsulta;
        this.motivoConsulta = motivoConsulta;
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

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
}
