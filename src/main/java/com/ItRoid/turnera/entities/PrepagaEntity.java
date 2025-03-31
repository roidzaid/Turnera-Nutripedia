package com.ItRoid.turnera.entities;

import javax.persistence.*;

@Entity
@TableGenerator(name = "seq", initialValue = 1000, allocationSize = 1)
@Table(name = "prepagas")
public class PrepagaEntity {

    @Id
    @Column(name="idPrepaga")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private long idPrepaga;

    @Column(name="prepaga")
    private String prepaga;

    @Column(name="idProfesional")
    private long idProfesional;

    public PrepagaEntity() {
    }

    public PrepagaEntity(String prepaga, long idProfesional) {
        this.prepaga = prepaga;
        this.idProfesional = idProfesional;
    }

    public long getIdPrepaga() {
        return idPrepaga;
    }

    public void setIdPrepaga(long idPrepaga) {
        this.idPrepaga = idPrepaga;
    }

    public String getPrepaga() {
        return prepaga;
    }

    public void setPrepaga(String prepaga) {
        this.prepaga = prepaga;
    }

    public long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(long idProfesional) {
        this.idProfesional = idProfesional;
    }
}
