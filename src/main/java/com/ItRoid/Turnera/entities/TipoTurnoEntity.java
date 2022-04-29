package com.ItRoid.Turnera.entities;

import javax.persistence.*;

@Entity
@TableGenerator(name = "seq", initialValue = 100, allocationSize = 1)
@Table(name = "tipoTurno")
public class TipoTurnoEntity {

    @Id
    @Column(name="idTipoTurno")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idTipoTurno;

    @Column(name = "tipoTurno")
    private String tipoTurno;

    public TipoTurnoEntity() {
    }

    public TipoTurnoEntity(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public Long getIdTipoTurno() {
        return idTipoTurno;
    }

    public void setIdTipoTurno(Long idTipoTurno) {
        this.idTipoTurno = idTipoTurno;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }
}
