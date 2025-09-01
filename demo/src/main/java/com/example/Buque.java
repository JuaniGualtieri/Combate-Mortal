package com.example;

public class Buque extends Ejercito {
    public Buque(String nombre, IArma arma) {
        super(nombre, 3, arma); // muere en 3 disparos
    }
    @Override public String tipo() { return "Buque"; }
}
