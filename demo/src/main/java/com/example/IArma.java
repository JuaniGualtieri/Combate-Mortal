package com.example;

public interface IArma {
    int usar();                 // devuelve el daño del disparo y descuenta 1 munición
    int getMuniciones();
    void recargar(int cantidad);
    String nombre();
}
