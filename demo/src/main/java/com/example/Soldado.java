package com.example;

public class Soldado extends Ejercito {

    public Soldado(int vida, int danio, boolean estado, int resistencia) {
        super(vida, danio, estado, resistencia);
    }

    @Override
    public void recibirAtaque() {
        recibirAtaqueConEscudo(getDanio());
    }
}
