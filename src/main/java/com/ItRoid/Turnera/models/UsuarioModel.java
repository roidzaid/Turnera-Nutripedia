package com.ItRoid.Turnera.models;

public class UsuarioModel {

    private String usuario;
    private String contraseña;
    private Long idProfesional;

    public UsuarioModel() {
    }

    public UsuarioModel(String usaurio, String contraseña, Long idProfecional) {
        this.usuario = usaurio;
        this.contraseña = contraseña;
        this.idProfesional = idProfecional;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }
}
