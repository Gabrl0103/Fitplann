package com.fitplan.model;

public enum ObjetivoFisico {
    MASA_MUSCULAR("Ganar masa muscular", 300),
    PERDER_GRASA("Perder grasa", -400),
    RESISTENCIA("Mejorar resistencia", 0);

    private final String descripcion;
    private final int ajusteCaloricoKcal;

    ObjetivoFisico(String descripcion, int ajusteCaloricoKcal) {
        this.descripcion = descripcion;
        this.ajusteCaloricoKcal = ajusteCaloricoKcal;
    }

    public String getDescripcion() { return descripcion; }
    public int getAjusteCaloricoKcal() { return ajusteCaloricoKcal; }
}
