package com.example;

// Clase abstracta que representa cualquier tipo de ejército/unidad
public abstract class Ejercito {
    private String nombre;   
    private double vida;        // ahora double para manejar fracciones de daño
    private boolean vivo;   
    private IArma arma;      
    private IDefensa defensa; 

    // Constructor base: inicializa nombre, vida y arma
    protected Ejercito(String nombre, double vidaInicial, IArma arma) {
        this.nombre = nombre;
        this.vida = Math.max(0.0, vidaInicial);
        this.vivo = vidaInicial > 0.0;
        this.arma = arma; // puede ser null (sin arma)
    }

    // Getters y setters 
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getVida() { return vida; }

    // Setter protegido para que solo se use dentro de la jerarquía (doble encapsulamiento)
    protected void setVida(double vida) {
        this.vida = Math.max(0.0, vida);// controla que nunca sea negativa
        this.vivo = this.vida > 0.0;// controla automáticamente el estado
    }

    public boolean estaVivo() { return vivo; }

    public IArma getArma() { return arma; }
    public void setArma(IArma arma) { this.arma = arma; }

    public IDefensa getDefensa() { return defensa; }
    public void setDefensa(IDefensa defensa) { this.defensa = defensa; }

    // Ataques 

    // Disparo normal
    public void disparar(Ejercito objetivo) {
        int danio = (arma != null) ? arma.usar() : 0;
        objetivo.recibirDisparo(danio); // int se amplía a double automáticamente
    }

    // Disparo con potencia extra (sobrecarga del método anterior)
    public void disparar(Ejercito objetivo, int potenciaExtra) {
        int base = (arma != null) ? arma.usar() : 0;
        int danio = Math.max(0, base + Math.max(0, potenciaExtra));
        objetivo.recibirDisparo(danio);
    }

    //  Recibir daño 
    public void recibirDisparo(double danioEntrante) {
        if (!vivo) return; // si ya está muerto no recibe más daño
        // Si tiene defensa, se aplica; si no, se toma el daño tal cual
        double neto = (defensa != null) ? defensa.aplicar(danioEntrante) : danioEntrante;
        setVida(getVida() - neto);
    }

    // Método abstracto que cada subclase debe implementar
    public abstract String tipo();
}
