package com.ItRoid.turnera.entities;

import javax.persistence.*;

@Entity
@TableGenerator(name = "seq", initialValue = 1000, allocationSize = 1)
@Table(name = "feriados")
public class FeriadosEntity {

    @Id
    @Column(name="id_feriado")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idFeriado;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "detalle")
    private String detalle;

    public FeriadosEntity() {
    }

    public FeriadosEntity(String fecha, String detalle) {
        this.fecha = fecha;
        this.detalle = detalle;
    }

    public Long getIdFeriado() {
        return idFeriado;
    }

    public void setIdFeriado(Long idFeriado) {
        this.idFeriado = idFeriado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
