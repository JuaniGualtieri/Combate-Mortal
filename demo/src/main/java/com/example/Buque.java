package com.example;

public class Buque extends Ejercito{
    public Buque(int vida, int daño, boolean estado,int resistencia) {
        super(vida, daño, estado,resistencia); 
    }

    @Override
    public void recibirAtaque() {
        recibirAtaqueConEscudo(getDanio());
    }



    
}
