package com.example;

// Subclase de Ejercito
public class Buque extends Ejercito {
    public Buque(String nombre, IArma arma) {
        super(nombre, 3, arma); // un buque tiene 3 puntos de vida
    }

    @Override 
    public String tipo() { 
        return "Buque"; 
    }
}
