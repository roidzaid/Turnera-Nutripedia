package com.ItRoid.Turnera.models;

public class ValorConsultaModel {

    private Long idValorConsulta;
    private Long idProfesional;
    private String tipoConsulta;
    private String valorConsulta;
    private String valorDeSeña;

    public ValorConsultaModel() {
    }

    public ValorConsultaModel(Long idValorConsulta, Long idProfesional, String tipoConsulta, String valorConsulta, String valorDeSeña) {
        this.idValorConsulta = idValorConsulta;
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
