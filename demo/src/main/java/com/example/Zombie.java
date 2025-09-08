package com.example;

public class Zombie extends Ejercito {

    public Zombie(String nombre, IArma arma) {
        // Vida inicial normal (3). No es infinita.
        super(nombre, 3, arma);
    }

    @Override
    public void recibirDisparo(int danioEntrante) {
        // Se resta vida, pero nunca baja de 1; así siempre está vivo.
        setVida(Math.max(1, getVida() - danioEntrante));
    }

    @Override
    public String tipo() {
        return "Zombie";
    }
}
