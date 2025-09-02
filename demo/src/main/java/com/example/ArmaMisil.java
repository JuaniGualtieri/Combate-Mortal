package com.example;

// Arma concreta que hereda de ArmaBase
public class ArmaMisil extends ArmaBase {
    // Constructor por defecto con parámetros fijos
    public ArmaMisil() {
        super("LanzaMisiles", 2, 5); // daño 2, 5 misiles
    }
}
