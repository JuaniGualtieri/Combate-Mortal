package com.example;

// Subclase de Ejercito
public class Soldado extends Ejercito {
    public Soldado(String nombre, IArma arma) {
        super(nombre, 1, arma); // un soldado tiene 1 punto de vida
    }

    @Override 
    public String tipo() { 
        return "Soldado"; 
    }
}
