package com.ItRoid.Turnera.entities;

import javax.persistence.*;

@Entity
@TableGenerator(name = "seq", initialValue = 1000, allocationSize = 1)
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @Column(name="idUsuario")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idUsuario;

    @Column(name="usuario")
    private String usuario;

    @Column(name="contraseña")
    private String contraseña;

    @Column(name="idProfesional")
    private Long idProfesional;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String usaurio, String contraseña, Long idProfecional) {
        this.usuario = usaurio;
        this.contraseña = contraseña;
        this.idProfesional = idProfecional;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
