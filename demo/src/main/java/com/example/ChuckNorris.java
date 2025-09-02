package com.example;

// Subclase especial de Ejercito
public class ChuckNorris extends Ejercito {
    public ChuckNorris(String nombre, IArma arma) {
        // Se le da "vida infinita" usando el valor máximo de int
        super(nombre, Integer.MAX_VALUE, arma); 
    }

    // Chuck Norris nunca recibe daño
    @Override 
    public void recibirDisparo(int danioEntrante) {
        // Método vacío a propósito
    }

    @Override 
    public String tipo() { 
        return "ChuckNorris"; 
    }
}
