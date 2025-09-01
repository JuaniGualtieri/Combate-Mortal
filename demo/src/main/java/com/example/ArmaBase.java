package com.example;

public abstract class ArmaBase implements IArma {
    private int municiones;       // por defecto 10 como pidió el profe
    private final int danioPorDisparo; // daño fijo de esta arma
    private final String nombre;

    protected ArmaBase(String nombre, int danioPorDisparo, int municionesIniciales) {
        this.nombre = nombre;
        this.danioPorDisparo = danioPorDisparo;
        this.municiones = Math.max(0, municionesIniciales); // nunca arranca negativo
    }

    @Override
    public int usar() {
        int disparo = (municiones > 0 ? danioPorDisparo : 0); // calcula daño (0 si no hay balas)
        municiones = Math.max(0, municiones - 1);             // resta 1 si había balas
        return disparo;
    }

    @Override
    public int getMuniciones() { 
        return municiones; 
    }

    @Override
    public void recargar(int cantidad) {
        // suma solo si cantidad es positiva
        municiones += Math.max(0, cantidad);
    }

    @Override
    public String nombre() { 
        return nombre; 
    }
}
