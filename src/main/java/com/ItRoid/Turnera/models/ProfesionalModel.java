package com.ItRoid.Turnera.models;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Blob;

public class ProfesionalModel {

    private Long idProfesional;
    private String nombre;
    private String apellido;
    private String dni;
    private String matricula;
    private String especialidad;
    private String mail;
    private String telefono;


    public ProfesionalModel() {
    }

    public ProfesionalModel(Long idProfesional, String nombre, String apellido, String dni, String matricula, String especialidad, String mail, String telefono) {
        this.idProfesional = idProfesional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.mail = mail;
        this.telefono = telefono;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
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

}
