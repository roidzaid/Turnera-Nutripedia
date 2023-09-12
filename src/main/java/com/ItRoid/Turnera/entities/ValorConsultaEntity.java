package com.ItRoid.Turnera.entities;

import javax.persistence.*;

@Entity
@TableGenerator(name = "seq", initialValue = 1000, allocationSize = 1)
@Table(name = "valorConsulta")
public class ValorConsultaEntity {

    @Id
    @Column(name="idValorConsulta")
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "seq")
    private Long idValorConsulta;

    @Column(name="idProfesional")
    private Long idProfesional;

    @Column(name="tipoConsulta")
    private String tipoConsulta;

    @Column(name="valorConsulta")
    private String valorConsulta;

    @Column(name="valorDeSeña")
    private String valorDeSeña;

    public ValorConsultaEntity() {
    }

    public ValorConsultaEntity(Long idProfesional, String tipoConsulta, String valorConsulta, String valorDeSeña) {
        this.idProfesional = idProfesional;
        this.tipoConsulta = tipoConsulta;
        this.valorConsulta = valorConsulta;
        this.valorDeSeña = valorDeSeña;
    }

    public Long getIdValorConsulta() {
        return idValorConsulta;
    }

    public void setIdValorConsulta(Long idValorConsulta) {
        this.idValorConsulta = idValorConsulta;
    }

    public Long getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(String valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public String getValorDeSeña() {
        return valorDeSeña;
    }

    public void setValorDeSeña(String valorDeSeña) {
        this.valorDeSeña = valorDeSeña;
    }
}
