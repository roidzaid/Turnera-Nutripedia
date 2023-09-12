package com.ItRoid.Turnera.models;

public class EspecialidadModel {

    private Long idEspecialidad;
    private String especialidad;

    public EspecialidadModel() {
    }

    public EspecialidadModel(Long idEspecialidad, String especialidad) {

        this.especialidad = especialidad;
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
}
