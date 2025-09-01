package com.example;

public class ArmaRifle extends ArmaBase {

    // Constructor por defecto
    public ArmaRifle() {
        super("Rifle", 1, 10);
    }

    // Constructor con daño y balas
    public ArmaRifle(int danio, int balas) {
        super("Rifle", danio, balas);
    }
}
