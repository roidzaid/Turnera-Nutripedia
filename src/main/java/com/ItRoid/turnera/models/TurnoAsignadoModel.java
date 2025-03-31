package com.ItRoid.turnera.models;

public class TurnoAsignadoModel {

    private Long idTurnoAsignado;
    private Long idConfiguracionTurno;
    private String fecha;
    private String hora;
    private Long idProfesional;
    private String nombreProfesional;
    private String apellidoProfesional;
    private String especialidad;
    private String mailProfesional;
    private Long idPaciente;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String dniPaciente;
    private String telefonoPaciente;
    private String mailPaciente;
    private String tipoConsulta;
    private String motivoConsulta;
    private String estadoPago;
    private String idPagoMP;
    private String prestador;
    private String valorConsulta;
    private String seña;


    public TurnoAsignadoModel() {
    }

    public TurnoAsignadoModel(Long idTurnoAsignado, Long idConfiguracionTurno, String fecha, String hora, Long idProfesional, String nombreProfesional, String apellidoProfesional, String especialidad, String mailProfesional, Long idPaciente, String nombrePaciente, String apellidoPaciente, String dniPaciente, String telefonoPaciente, String mailPaciente, String tipoConsulta, String motivoConsulta, String estadoPago, String idPagoMP, String prestador, String valorConsulta, String seña) {
        this.idTurnoAsignado = idTurnoAsignado;
        this.idConfiguracionTurno = idConfiguracionTurno;
        this.fecha = fecha;
        this.hora = hora;
        this.idProfesional = idProfesional;
        this.nombreProfesional = nombreProfesional;
        this.apellidoProfesional = apellidoProfesional;
        this.especialidad = especialidad;
        this.mailProfesional = mailProfesional;
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.dniPaciente = dniPaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.mailPaciente = mailPaciente;
        this.tipoConsulta = tipoConsulta;
        this.motivoConsulta = motivoConsulta;
        this.estadoPago = estadoPago;
        this.idPagoMP = idPagoMP;
        this.prestador = prestador;
        this.valorConsulta = valorConsulta;
        this.seña = seña;
    }

    public Long getIdTurnoAsignado() {
        return idTurnoAsignado;
    }

    public void setIdTurnoAsignado(Long idTurnoAsignado) {
        this.idTurnoAsignado = idTurnoAsignado;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getNombreProfesional() {
        return nombreProfesional;
    }

    public void setNombreProfesional(String nombreProfesional) {
        this.nombreProfesional = nombreProfesional;
    }

    public String getApellidoProfesional() {
        return apellidoProfesional;
    }

    public void setApellidoProfesional(String apellidoProfesional) {
        this.apellidoProfesional = apellidoProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMailProfesional() {
        return mailProfesional;
    }

    public void setMailProfesional(String mailProfesional) {
        this.mailProfesional = mailProfesional;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
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

    public String getMailPaciente() {
        return mailPaciente;
    }

    public void setMailPaciente(String mailPaciente) {
        this.mailPaciente = mailPaciente;
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

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getIdPagoMP() {
        return idPagoMP;
    }

    public void setIdPagoMP(String idPagoMP) {
        this.idPagoMP = idPagoMP;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(String valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public String getSeña() {
        return seña;
    }

    public void setSeña(String seña) {
        this.seña = seña;
    }
}
