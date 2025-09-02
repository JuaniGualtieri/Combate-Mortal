package com.example;

// Clase abstracta que implementa la interfaz IArma
// Sirve como plantilla base para todas las armas (Rifle, Misil, etc.)
public abstract class ArmaBase implements IArma {
    private int municiones;       
    // Daño fijo que produce cada disparo
    private final int danioPorDisparo; 
    private final String nombre;

    // Constructor 
    protected ArmaBase(String nombre, int danioPorDisparo, int municionesIniciales) {
        this.nombre = nombre;
        this.danioPorDisparo = danioPorDisparo;
        this.municiones = Math.max(0, municionesIniciales); 
    }

    // Método que representa disparar el arma
    @Override
    public int usar() {
        // Si hay municiones devuelve el daño, sino devuelve 0
        int disparo = (municiones > 0 ? danioPorDisparo : 0); 
        municiones = Math.max(0, municiones - 1);             
        return disparo;
    }

    // Devuelve la cantidad actual de municiones
    @Override
    public int getMuniciones() { 
        return municiones; 
    }

    // Recarga el arma con una cantidad de municiones (no suma si es negativa)
    @Override
    public void recargar(int cantidad) {
        municiones += Math.max(0, cantidad);
    }

    // Devuelve el nombre del arma
    @Override
    public String nombre() { 
        return nombre; 
    }
}
