package com.ItRoid.Turnera.entities;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Entity
@TableGenerator(name = "seq", initialValue = 10, allocationSize = 1)
@Table(name = "profesionales")
public class ProfesionalEntity {

    @Id
    @Column(name="idProfesional")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idProfesional;

    @Column(name = "fechaAlta")
    private Date fechaAlta;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private String dni;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "mail")
    private String mail;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "aliasMP")
    private String aliasMP;

    @Column(name = "activo")
    private String activo;


    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="idProfesional")
    private List<HorariosEntity> horarios;

    public ProfesionalEntity() {
    }

    public ProfesionalEntity(Date fechaAlta, String nombre, String apellido, String dni, String matricula, String especialidad, String mail, String telefono, String instagram, String usuario, String aliasMP, String activo) {
        this.fechaAlta = fechaAlta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.mail = mail;
        this.telefono = telefono;
        this.instagram = instagram;
        this.usuario = usuario;
        this.aliasMP = aliasMP;
        this.activo = activo;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<HorariosEntity> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorariosEntity> horarios) {
        this.horarios = horarios;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAliasMP() {
        return aliasMP;
    }

    public void setAliasMP(String aliasMP) {
        this.aliasMP = aliasMP;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}


