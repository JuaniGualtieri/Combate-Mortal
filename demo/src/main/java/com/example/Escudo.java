package com.example;

public class Escudo implements IDefensa {
    private double porcentaje; // 0.0 a 1.0 (ej: 0.5 = reduce 50%)

    public Escudo(double porcentaje) {
        this.porcentaje = Math.min(1.0, Math.max(0.0, porcentaje));
    }

    public double getPorcentaje() { return porcentaje; }
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = Math.min(1.0, Math.max(0.0, porcentaje));
    }

    @Override
    public int aplicar(int danioEntrante) {
        double neto = danioEntrante * (1.0 - porcentaje);
        return (int)Math.max(0, Math.round(neto));
    }
}
