package com.ItRoid.turnera.models;

public class HorariosModel {

    private Long idHorario;
    private String diaDeSemana;
    private String tipoTurno;
    private int horaDesde;
    private int minutosDesde;
    private int horaHasta;
    private int minutosHasta;
    private int duracionTurnos;
    private String fechaHorarioEventual;

    public HorariosModel() {
    }

    public HorariosModel(Long idHorario, String diaDeSemana, String tipoTurno, int horaDesde, int minutosDesde, int horaHasta, int minutosHasta, int duracionTurnos, String fechaHorarioEventual) {
        this.idHorario = idHorario;
        this.diaDeSemana = diaDeSemana;
        this.tipoTurno = tipoTurno;
        this.horaDesde = horaDesde;
        this.minutosDesde = minutosDesde;
        this.horaHasta = horaHasta;
        this.minutosHasta = minutosHasta;
        this.duracionTurnos = duracionTurnos;
        this.fechaHorarioEventual = fechaHorarioEventual;
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
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

    public int getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(int horaDesde) {
        this.horaDesde = horaDesde;
    }

    public int getMinutosDesde() {
        return minutosDesde;
    }

    public void setMinutosDesde(int minutosDesde) {
        this.minutosDesde = minutosDesde;
    }

    public int getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(int horaHasta) {
        this.horaHasta = horaHasta;
    }

    public int getMinutosHasta() {
        return minutosHasta;
    }

    public void setMinutosHasta(int minutosHasta) {
        this.minutosHasta = minutosHasta;
    }

    public int getDuracionTurnos() {
        return duracionTurnos;
    }

    public void setDuracionTurnos(int duracionTurnos) {
        this.duracionTurnos = duracionTurnos;
    }

    public String getFechaHorarioEventual() {
        return fechaHorarioEventual;
    }

    public void setFechaHorarioEventual(String fechaHorarioEventual) {
        this.fechaHorarioEventual = fechaHorarioEventual;
    }
}
