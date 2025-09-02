package com.example;

// Otra arma concreta que hereda de ArmaBase
public class ArmaRifle extends ArmaBase {

    // Constructor por defecto: Rifle con daño 1 y 10 balas
    public ArmaRifle() {
        super("Rifle", 1, 10);
    }

    // Constructor parametrizado: Rifle con daño y balas personalizadas
    public ArmaRifle(int danio, int balas) {
        super("Rifle", danio, balas);
    }
}
