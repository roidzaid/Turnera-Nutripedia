package com.ItRoid.turnera.models;

public class PrepagaModels {

    private Long idPrepaga;
    private String prepaga;
    private Long idProfesional;

    public PrepagaModels() {
    }

    public PrepagaModels(Long idPrepaga, String prepaga, Long idProfesional) {
        this.idPrepaga = idPrepaga;
        this.prepaga = prepaga;
        this.idProfesional = idProfesional;
    }

    public Long getIdPrepaga() {
        return idPrepaga;
    }

    public void setIdPrepaga(Long idOs) {
        this.idPrepaga = idPrepaga;
    }

    public String getPrepaga() {
        return prepaga;
    }

    public void setPrepaga(String prepaga) {
        this.prepaga = prepaga;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }
}
