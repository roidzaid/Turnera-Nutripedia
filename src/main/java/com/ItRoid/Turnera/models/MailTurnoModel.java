package com.ItRoid.Turnera.models;

public class MailTurnoModel {

    private String mailPaciente;
    private String nombrePaciente;
    private String dniPaciente;
    private String telefonoPaciente;
    private String mailProfecional;
    private String nombreProfecional;
    private String telefonoProfesional;
    private String especialidad;
    private String fecha;
    private String hora;
    private String tipoConsulta;
    private String motivoConsulta;

    public MailTurnoModel() {
    }

    public MailTurnoModel(String mailPaciente, String nombrePaciente, String dniPaciente, String telefonoPaciente, String mailProfecional, String nombreProfecional, String telefonoProfesional, String especialidad, String fecha, String hora, String tipoConsulta, String motivoConsulta) {
        this.mailPaciente = mailPaciente;
        this.nombrePaciente = nombrePaciente;
        this.dniPaciente = dniPaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.mailProfecional = mailProfecional;
        this.nombreProfecional = nombreProfecional;
        this.telefonoProfesional = telefonoProfesional;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoConsulta = tipoConsulta;
        this.motivoConsulta = motivoConsulta;
    }

    public String getMailPaciente() {
        return mailPaciente;
    }

    public void setMailPaciente(String mailPaciente) {
        this.mailPaciente = mailPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public String getMailProfecional() {
        return mailProfecional;
    }

    public void setMailProfecional(String mailProfecional) {
        this.mailProfecional = mailProfecional;
    }

    public String getNombreProfecional() {
        return nombreProfecional;
    }

    public void setNombreProfecional(String nombreProfecional) {
        this.nombreProfecional = nombreProfecional;
    }

    public String getTelefonoProfesional() {
        return telefonoProfesional;
    }

    public void setTelefonoProfesional(String telefonoProfesional) {
        this.telefonoProfesional = telefonoProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
