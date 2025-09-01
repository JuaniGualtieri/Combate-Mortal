package com.example;

public class ChuckNorris extends Ejercito {
    public ChuckNorris(String nombre, IArma arma) {
        super(nombre, Integer.MAX_VALUE, arma); // vida "infinita"
    }
    @Override public void recibirDisparo(int danioEntrante) {
        // Chuck Norris no recibe daño :)
    }
    @Override public String tipo() { return "ChuckNorris"; }
}
