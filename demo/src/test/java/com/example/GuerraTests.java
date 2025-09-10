package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class GuerraTests {

    private static final double EPS = 0.00001; // tolerancia para comparaciones con double

    @Test
    public void chuck_nunca_muere() {
        // Crear a Chuck Norris con "vida infinita" y un arma
        ChuckNorris chuck = new ChuckNorris("Chuck", new ArmaRifle(1, 5));
        // Crear un soldado con 1 vida y un arma
        Soldado soldado = new Soldado("Soldado1", new ArmaRifle(1, 1));

        // Soldado dispara a Chuck Norris
        soldado.disparar(chuck);

        // Comprobar que Chuck sigue vivo
        assertTrue(chuck.estaVivo());
        // Comprobar que su vida sigue siendo Integer.MAX_VALUE
        assertEquals(Integer.MAX_VALUE, chuck.getVida(), EPS); // EPS usado para evitar warning
    }

    @Test
    public void chuck_dispara_y_mata_a_soldado() {
        // Crear a Chuck y un soldado
        ChuckNorris chuck = new ChuckNorris("Chuck", new ArmaRifle(1, 5));
        Soldado soldado = new Soldado("Soldado1", new ArmaRifle(1, 1));

        // Chuck dispara al soldado
        chuck.disparar(soldado);

        // Comprobar que el soldado murió
        assertFalse(soldado.estaVivo());
        // Vida del soldado debe ser 0
        assertEquals(0, soldado.getVida(), EPS);
    }

    @Test
    public void soldado_muere_al_recibir_un_disparo() {
        // Dos soldados, ambos con vida 1
        Soldado soldado1 = new Soldado("Soldado1", new ArmaRifle(1, 1));
        Soldado soldado2 = new Soldado("Soldado2", new ArmaRifle(1, 1));

        // Soldado1 dispara a soldado2
        soldado1.disparar(soldado2);

        // Comprobar que soldado2 murió
        assertFalse(soldado2.estaVivo());
        assertEquals(0, soldado2.getVida(), EPS);
    }

    @Test
    public void soldado_dispara_a_otro_soldado() {
        // Otro caso de soldado disparando a otro soldado
        Soldado s1 = new Soldado("S1", new ArmaRifle(1, 1));
        Soldado s2 = new Soldado("S2", new ArmaRifle(1, 1));

        s1.disparar(s2);

        assertFalse(s2.estaVivo());
        assertEquals(0, s2.getVida(), EPS);
    }

    @Test
    public void tanque_recibe_un_disparo_y_sobrevive() {
        // Tanque con vida 2
        Tanque tanque = new Tanque("Tanque1", new ArmaRifle(1, 1));
        // Soldado dispara al tanque
        Soldado s = new Soldado("S1", new ArmaRifle(1, 1));
        s.disparar(tanque);

        // Tanque debería sobrevivir
        assertTrue(tanque.estaVivo());
        assertEquals(1, tanque.getVida(), EPS);
    }

    @Test
    public void tanque_muere_con_dos_disparos() {
        // Tanque con vida 2
        Tanque tanque = new Tanque("Tanque1", new ArmaRifle(1, 2));
        // Dos soldados con daño 1 cada uno
        Soldado s1 = new Soldado("S1", new ArmaRifle(1, 1));
        Soldado s2 = new Soldado("S2", new ArmaRifle(1, 1));

        s1.disparar(tanque);
        s2.disparar(tanque);

        // Tanque debe morir
        assertFalse(tanque.estaVivo());
        assertEquals(0, tanque.getVida(), EPS);
    }

    @Test
    public void tanque_dispara_a_otro_tanque_dos_veces_y_lo_destruye() {
        // Dos tanques con vida 2 cada uno
        Tanque t1 = new Tanque("T1", new ArmaRifle(1, 2));
        Tanque t2 = new Tanque("T2", new ArmaRifle(1, 2));

        // t1 dispara dos veces a t2
        t1.disparar(t2);
        t1.disparar(t2);

        // t2 debe morir después de recibir 2 de daño
        assertFalse(t2.estaVivo());
        assertEquals(0, t2.getVida(), EPS);
    }

    @Test
    public void tanque_dispara_a_otro_tanque_una_vez_y_sobrevive() {
        // Dos tanques con vida 2
        Tanque t1 = new Tanque("T1", new ArmaRifle(1, 2));
        Tanque t2 = new Tanque("T2", new ArmaRifle(1, 2));

        // t1 dispara una vez a t2
        t1.disparar(t2);

        // t2 debe sobrevivir
        assertTrue(t2.estaVivo());
        assertEquals(1, t2.getVida(), EPS);
    }

    @Test
    public void buque_muere_con_tres_disparos_de_tanques() {
        // Buque con vida 3
        Buque buque = new Buque("Buque1", new ArmaRifle(1, 3));
        // Tres tanques con disparo de 1
        Tanque t1 = new Tanque("T1", new ArmaRifle(1, 1));
        Tanque t2 = new Tanque("T2", new ArmaRifle(1, 1));
        Tanque t3 = new Tanque("T3", new ArmaRifle(1, 1));

        t1.disparar(buque);
        t2.disparar(buque);
        t3.disparar(buque);

        // Buque debe morir
        assertFalse(buque.estaVivo());
        assertEquals(0, buque.getVida(), EPS);
    }

    @Test
    public void buque_dispara_a_otro_buque_y_lo_destruye() {
        // Dos buques con vida 3
        Buque b1 = new Buque("B1", new ArmaRifle(1, 3));
        Buque b2 = new Buque("B2", new ArmaRifle(1, 3));

        b1.disparar(b2);
        b1.disparar(b2);
        b1.disparar(b2);

        // b2 debe morir
        assertFalse(b2.estaVivo());
        assertEquals(0, b2.getVida(), EPS);
    }

    @Test
    public void tanque_con_escudo_resiste_4_disparos() {
        // Tanque con vida 2 y escudo 50%
        Tanque tanque = new Tanque("TanqueEscudado", new ArmaRifle(1, 2));
        tanque.setDefensa(new Escudo(0.5));
        Soldado s = new Soldado("S1", new ArmaRifle(1, 4));

        // Primer disparo
        s.disparar(tanque);
        assertTrue(tanque.estaVivo());
        assertEquals(1.5, tanque.getVida(), EPS);

        // Segundo disparo
        s.disparar(tanque);
        assertTrue(tanque.estaVivo());
        assertEquals(1.0, tanque.getVida(), EPS);

        // Tercer disparo
        s.disparar(tanque);
        assertTrue(tanque.estaVivo());
        assertEquals(0.5, tanque.getVida(), EPS);

        // Cuarto disparo → muere
        s.disparar(tanque);
        assertFalse(tanque.estaVivo());
        assertEquals(0.0, tanque.getVida(), EPS);
    }

    @Test
    public void zombie_nunca_muere() {
        // Zombie con vida mínima 1
        Zombie zombie = new Zombie("Zombie1", new ArmaRifle(1, 10));
        Soldado soldado = new Soldado("Soldado1", new ArmaRifle(1, 10));

        // Disparamos varias veces al zombie
        soldado.disparar(zombie);
        soldado.disparar(zombie);
        soldado.disparar(zombie);
        soldado.disparar(zombie);

        // Zombie siempre vivo, vida mínima 1
        assertTrue(zombie.estaVivo());
        assertEquals(1, zombie.getVida(), EPS);
    }
}
