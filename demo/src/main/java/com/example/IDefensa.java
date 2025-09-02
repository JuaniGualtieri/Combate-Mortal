package com.example;

// Interfaz para defensas (ejemplo: Escudo)
public interface IDefensa {
    // Método que recibe un daño entrante y devuelve el daño neto tras aplicar la defensa
    int aplicar(int danioEntrante);
}
