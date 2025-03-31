package com.ItRoid.turnera.models;

public class ProfesionalModel {

    private Long idProfesional;
    private String nombre;
    private String apellido;
    private String dni;
    private String matricula;
    private String especialidad;
    private String mail;
    private String telefono;
    private String instagram;
    private String usuario;
    private String AliasMP;
    private String activo;
    private String diasAbrirAgenda;


    public ProfesionalModel() {
    }

    public ProfesionalModel(Long idProfesional, String nombre, String apellido, String dni, String matricula, String especialidad, String mail, String telefono, String instagram, String usuario, String AliasMP, String activo, String diasAbrirAgenda) {
        this.idProfesional = idProfesional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.mail = mail;
        this.telefono = telefono;
        this.instagram = instagram;
        this.usuario = usuario;
        this.AliasMP = AliasMP;
        this.activo = activo;
        this.diasAbrirAgenda = diasAbrirAgenda;
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
        return AliasMP;
    }

    public void setAliasMP(String aliasMP) {
        AliasMP = aliasMP;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDiasAbrirAgenda() {
        return diasAbrirAgenda;
    }

    public void setDiasAbrirAgenda(String diasAbrirAgenda) {
        this.diasAbrirAgenda = diasAbrirAgenda;
    }
}
