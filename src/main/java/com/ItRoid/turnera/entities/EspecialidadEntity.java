package com.ItRoid.turnera.entities;

import javax.persistence.*;

@Entity
@TableGenerator(name = "seq", initialValue = 100, allocationSize = 1)
@Table(name = "especialidades")
public class EspecialidadEntity {

    @Id
    @Column(name="idEspecialidad")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idEspecialidad;

    @Column(name = "especialidad")
    private String especialidad;

    public EspecialidadEntity() {
    }

    public EspecialidadEntity(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
