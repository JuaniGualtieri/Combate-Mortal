package com.example;

// Subclase de Ejercito
public class Tanque extends Ejercito {
    public Tanque(String nombre, IArma arma) {
        super(nombre, 2, arma); // un tanque tiene 2 puntos de vida
    }

    @Override 
    public String tipo() { 
        return "Tanque"; 
    }
}
