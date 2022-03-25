package com.ItRoid.Turnera.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@TableGenerator(name = "seq", initialValue = 10, allocationSize = 1)
@Table(name = "turnosAsignados")
public class TurnoAsignadoEntity {

    @Id
    @Column(name="idTurnoAsignado")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idTurnoAsignado;

    @Column(name = "idConfiguracionTurno")
    private Long idConfiguracionTurno;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "fechayHora")
    private String fechayHora;

    @Column(name = "idProfesional")
    private Long idProfesional;

    @Column(name = "nombreProfesional")
    private String nombreProfesional;

    @Column(name = "apellidoProfesional")
    private String apellidoProfesional;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "mailProfesional")
    private String mailProfesional;

    @Column(name = "idPaciente")
    private Long idPaciente;

    @Column(name = "nombrePaciente")
    private String nombrePaciente;

    @Column(name = "apellidoPaciente")
    private String apellidoPaciente;

    @Column(name = "dniPaciente")
    private String dniPaciente;

    @Column(name = "telefonoPaciente")
    private String telefonoPaciente;

    @Column(name = "mailPaciente")
    private String mailPaciente;

    @Column(name = "tipoConsulta")
    private String tipoConsulta;

    @Column(name = "motivoConsulta")
    private String motivoConsulta;



    public TurnoAsignadoEntity() {
    }

    public TurnoAsignadoEntity(Long idConfiguracionTurno, String fecha, String hora, String fechayHora, Long idProfesional, String nombreProfesional, String apellidoProfesional, String especialidad, String mailProfesional, Long idPaciente, String nombrePaciente, String apellidoPaciente, String dniPaciente, String telefonoPaciente, String mailPaciente,String tipoConsulta, String motivoConsulta) {
        this.idConfiguracionTurno = idConfiguracionTurno;
        this.fecha = fecha;
        this.hora = hora;
        this.fechayHora = fechayHora;
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

    public String getFechayHora() {
        return fechayHora;
    }

    public void setFechayHora(String fechayHora) {
        this.fechayHora = fechayHora;
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
