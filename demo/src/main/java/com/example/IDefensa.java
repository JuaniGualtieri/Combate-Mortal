package com.example;

// Interfaz para defensas (ejemplo: Escudo)
public interface IDefensa {
    // Método que recibe un daño entrante y devuelve el daño neto tras aplicar la defensa
    // Usamos double para permitir daño fraccionado (ej: 0.5)
    double aplicar(double danioEntrante);
}