package com.example;

public abstract class Ejercito {
    private String nombre;
    private int vida;
    private boolean vivo;
    private IArma arma;       // composición: posee un arma
    private IDefensa defensa; // opcional (escudo u otra)

    protected Ejercito(String nombre, int vidaInicial, IArma arma) {
        this.nombre = nombre;
        this.vida = Math.max(0, vidaInicial);
        this.vivo = vidaInicial > 0;
        this.arma = arma; // puede ser null (disparo no hace daño)
    }

    // ---- Encapsulamiento
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getVida() { return vida; }
    protected void setVida(int vida) {
        this.vida = Math.max(0, vida);
        this.vivo = this.vida > 0;
    }
    public boolean estaVivo() { return vivo; }

    public IArma getArma() { return arma; }
    public void setArma(IArma arma) { this.arma = arma; }

    public IDefensa getDefensa() { return defensa; }
    public void setDefensa(IDefensa defensa) { this.defensa = defensa; }

    // ---- Disparo (sobrecarga)
    public void disparar(Ejercito objetivo) {
        int danio = (arma != null) ? arma.usar() : 0;
        objetivo.recibirDisparo(danio);
    }

    public void disparar(Ejercito objetivo, int potenciaExtra) {
        int base = (arma != null) ? arma.usar() : 0;
        int danio = Math.max(0, base + Math.max(0, potenciaExtra));
        objetivo.recibirDisparo(danio);
    }

    // ---- Recibir daño (usa defensa si existe)
    public void recibirDisparo(int danioEntrante) {
        if (!vivo) return;
        int neto = (defensa != null) ? defensa.aplicar(danioEntrante) : danioEntrante;
        setVida(getVida() - neto);
    }

    // ---- Método abstracto (cumple rúbrica)
    public abstract String tipo();
}

