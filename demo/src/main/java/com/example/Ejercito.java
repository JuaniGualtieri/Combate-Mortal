package com.example;

public class Ejercito {
    private int vida;
    private int danio;
    private boolean estado;
    private int resistencia;
    private Escudo escudo; 

    public Ejercito(int vida, int danio,boolean estado,int resistencia) {
        this.vida = vida;
        this.danio = danio; 
        this.estado = estado; 
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }	

    public void setDanio(int danio){
        this.setDanio(danio);
    }

    public int getDanio(){
        return danio; 
    }

    public int getResistencia(){
        return resistencia;
    }

    public void setResistencia(int resistencia){
        this.resistencia = resistencia;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public void recibirAtaqueConEscudo(int dano) {
        double danoRecibido = dano;
        if (escudo != null) {
            danoRecibido *= (1 - escudo.getPorcentaje());
        }
        setVida((int) Math.max(getVida() - danoRecibido, 0));
        if (getVida() <= 0) {
            setEstado(false);
        }
    }

    public void recibirAtaque() {
        recibirAtaqueConEscudo(this.danio);
    }

    public void dispara(Ejercito objetivo) {
        objetivo.recibirAtaqueConEscudo(this.danio);
    }

    public boolean estoyVivo(){
        if (getVida() == 0){
            return false;
        } else {
            return true; 
        }
    }

    public void chuckAtaque(Ejercito ChuckNorris){
        setVida(getVida() - 0);
    }

    public void aplicarResistencia(Escudo es1){
        this.escudo = es1; 
    }

  



 
   

}

