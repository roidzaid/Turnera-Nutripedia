package com.ItRoid.turnera.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@TableGenerator(name = "seq", initialValue = 10, allocationSize = 1)
@Table(name = "pacientes")
public class PacienteEntity {

    @Id
    @Column(name="idPaciente")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idPaciente;

    @Column(name = "fechaAlta")
    private Date fechaAlta;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private String dni;

    @Column(name = "fechaNac")
    private String fechaNac;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "mail")
    private String mail;


    public PacienteEntity() {
    }

    public PacienteEntity(Date fechaAlta, String nombre, String apellido, String dni, String fechaNac, String direccion, String localidad, String telefono, String mail) {
        this.fechaAlta = fechaAlta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
