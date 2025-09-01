package com.example;

public class Soldado extends Ejercito {
    public Soldado(String nombre, IArma arma) {
        super(nombre, 1, arma); // muere en 1 disparo (vida = 1)
    }
    @Override public String tipo() { return "Soldado"; }
}
