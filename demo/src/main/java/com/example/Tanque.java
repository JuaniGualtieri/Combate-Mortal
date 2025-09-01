package com.example;

public class Tanque extends Ejercito{
    public Tanque(int vida,int danio,boolean estado,int resistencia) {
        super(vida,danio,estado,resistencia); 
    }

    @Override
    public void recibirAtaque() {
        recibirAtaqueConEscudo(getDanio());
    }

}
