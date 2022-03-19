package com.ItRoid.Turnera.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@TableGenerator(name = "seq", initialValue = 1000, allocationSize = 1)
@Table(name = "horarios")
public class HorariosEntity {

    @Id
    @Column(name="idHorario")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idHorario;

    @Column(name = "fechaAlta")
    private Date fechaAlta;

    @Column(name = "diaDeSemana")
    private String diaDeSemana;

    @Column(name = "tipoTurno")
    private String tipoTurno;

    @Column(name = "horaDesde")
    private String horaDesde;

    @Column(name = "horaHasta")
    private String horaHasta;

    @Column(name = "duracionTurnos")
    private int duracionTurnos;

    @ManyToOne
    @JoinColumn(name="idProfesional")
    private ProfesionalEntity profesional ;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="idHorario")
    private List<ConfiguracionTurnosEntity> configuracionTurnos;

    public HorariosEntity() {
    }

    public HorariosEntity(Date fechaAlta, String diaDeSemana, String tipoTurno, String horaDesde, String horaHasta, int duracionTurnos, ProfesionalEntity profesional, List<ConfiguracionTurnosEntity> configuracionTurnos) {
        this.fechaAlta = fechaAlta;
        this.diaDeSemana = diaDeSemana;
        this.tipoTurno = tipoTurno;
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
        this.duracionTurnos = duracionTurnos;
        this.profesional = profesional;
        this.configuracionTurnos = configuracionTurnos;
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDiaDeSemana() {
        return diaDeSemana;
    }

    public void setDiaDeSemana(String diaDeSemana) {
        this.diaDeSemana = diaDeSemana;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public String getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(String horaDesde) {
        this.horaDesde = horaDesde;
    }

    public String getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(String horaHasta) {
        this.horaHasta = horaHasta;
    }

    public int getDuracionTurnos() {
        return duracionTurnos;
    }

    public void setDuracionTurnos(int duracionTurnos) {
        this.duracionTurnos = duracionTurnos;
    }

    public ProfesionalEntity getProfesional() {
        return profesional;
    }

    public void setProfesional(ProfesionalEntity profesional) {
        this.profesional = profesional;
    }

    public List<ConfiguracionTurnosEntity> getConfiguracionTurnos() {
        return configuracionTurnos;
    }

    public void setConfiguracionTurnos(List<ConfiguracionTurnosEntity> configuracionTurnos) {
        this.configuracionTurnos = configuracionTurnos;
    }
}
