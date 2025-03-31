package com.ItRoid.turnera.entities;

import javax.persistence.*;

@Entity
@TableGenerator(name = "seq", initialValue = 10000, allocationSize = 1)
@Table(name = "configuracionTurnos")
public class ConfiguracionTurnosEntity {

    @Id
    @Column(name="idConfiguracionTurnos")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idConfiguracionTurnos;

    @Column(name = "hora")
    private String hora;

    @ManyToOne
    @JoinColumn(name="idHorario")
    private HorariosEntity idHorario ;

    public ConfiguracionTurnosEntity() {
    }

    public ConfiguracionTurnosEntity(String hora, HorariosEntity idHorario) {
        this.hora = hora;
        this.idHorario = idHorario;
    }

    public Long getIdConfiguracionTurnos() {
        return idConfiguracionTurnos;
    }

    public void setIdConfiguracionTurnos(Long idConfiguracionTurnos) {
        this.idConfiguracionTurnos = idConfiguracionTurnos;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public HorariosEntity getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(HorariosEntity idHorario) {
        this.idHorario = idHorario;
    }
}
