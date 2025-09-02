package com.example;

// Interfaz que define el contrato de cualquier arma
public interface IArma {
    // Dispara: devuelve el daño y descuenta una munición
    int usar();
    int getMuniciones();
    void recargar(int cantidad);
    String nombre();
}
