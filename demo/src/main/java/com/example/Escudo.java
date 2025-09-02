package com.example;

// Clase que implementa la interfaz IDefensa
// Reduce el daño entrante según un porcentaje
public class Escudo implements IDefensa {
    // Porcentaje de reducción (ej: 0.5 = reduce 50% del daño)
    private double porcentaje; 

    // Constructor que asegura que el porcentaje esté entre 0.0 y 1.0
    public Escudo(double porcentaje) {
        this.porcentaje = Math.min(1.0, Math.max(0.0, porcentaje));
    }

    public double getPorcentaje() { 
        return porcentaje; 
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = Math.min(1.0, Math.max(0.0, porcentaje));
    }

    // Aplica la reducción de daño y devuelve el daño neto
    @Override
    public int aplicar(int danioEntrante) {
        double neto = danioEntrante * (1.0 - porcentaje);
        // Redondeamos al entero más cercano y no deveuelve negativo
        return (int)Math.max(0, Math.round(neto)); 
    }
}
