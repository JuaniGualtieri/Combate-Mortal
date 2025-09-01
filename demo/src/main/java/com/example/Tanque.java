package com.example;

public class Tanque extends Ejercito {
    public Tanque(String nombre, IArma arma) {
        super(nombre, 2, arma); // muere en 2 disparos
    }
    @Override public String tipo() { return "Tanque"; }
}
