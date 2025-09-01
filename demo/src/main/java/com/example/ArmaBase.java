package com.example;

public abstract class ArmaBase implements IArma {
    private int municiones = 10;       // por defecto 10 como pidió el profe
    private final int danioPorDisparo; // daño fijo de esta arma
    private final String nombre;

    protected ArmaBase(String nombre, int danioPorDisparo, int municionesIniciales) {
        this.nombre = nombre;
        this.danioPorDisparo = danioPorDisparo;
        this.municiones = Math.max(0, municionesIniciales);
    }

    @Override
    public int usar() {
        if (municiones <= 0) return 0;     // sin munición, no daña
        municiones--;
        return danioPorDisparo;
    }

    @Override
    public int getMuniciones() { return municiones; }

    @Override
    public void recargar(int cantidad) {
        if (cantidad > 0) municiones += cantidad;
    }

    @Override
    public String nombre() { return nombre; }
}
