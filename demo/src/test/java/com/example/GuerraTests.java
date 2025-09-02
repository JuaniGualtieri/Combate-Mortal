package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class GuerraTests {

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
        assertEquals(Integer.MAX_VALUE, chuck.getVida());
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
        assertEquals(0, soldado.getVida());
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
        assertEquals(0, soldado2.getVida());
    }

    @Test
    public void soldado_dispara_a_otro_soldado() {
        // Igual que el anterior, otro caso de soldado disparando
        Soldado s1 = new Soldado("S1", new ArmaRifle(1, 1));
        Soldado s2 = new Soldado("S2", new ArmaRifle(1, 1));

        s1.disparar(s2);

        assertFalse(s2.estaVivo());
        assertEquals(0, s2.getVida());
    }

    @Test
    public void tanque_recibe_un_disparo_y_sobrevive() {
        // Tanque con vida 2
        Tanque tanque = new Tanque("Tanque1", new ArmaRifle(1, 1));

        // Soldado dispara al tanque
        Soldado s = new Soldado("S1", new ArmaRifle(1, 1));
        s.disparar(tanque);

        // Tanque debería sobrevivir porque vida inicial = 2 y daño = 1
        assertTrue(tanque.estaVivo());
        assertEquals(1, tanque.getVida()); // vida bajó de 2 → 1
    }

    @Test
    public void tanque_muere_con_dos_disparos() {
        // Tanque con vida 2
        Tanque tanque = new Tanque("Tanque1", new ArmaRifle(1, 2));
        // Dos soldados con daño 1 cada uno
        Soldado s1 = new Soldado("S1", new ArmaRifle(1, 1));
        Soldado s2 = new Soldado("S2", new ArmaRifle(1, 1));

        // Cada soldado dispara al tanque
        s1.disparar(tanque);
        s2.disparar(tanque);

        // Tanque debe morir (vida 2 - 1 - 1 = 0)
        assertFalse(tanque.estaVivo());
        assertEquals(0, tanque.getVida());
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
        assertEquals(0, t2.getVida());
    }

    @Test
    public void tanque_dispara_a_otro_tanque_una_vez_y_sobrevive() {
        Tanque t1 = new Tanque("T1", new ArmaRifle(1, 2));
        Tanque t2 = new Tanque("T2", new ArmaRifle(1, 2));

        // t1 dispara una vez a t2
        t1.disparar(t2);

        // t2 debe sobrevivir (vida = 2 - 1 = 1)
        assertTrue(t2.estaVivo());
        assertEquals(1, t2.getVida());
    }

    @Test
    public void buque_muere_con_tres_disparos_de_tanques() {
        // Buque con vida 3
        Buque buque = new Buque("Buque1", new ArmaRifle(1, 3));
        // Tres tanques con disparo de 1
        Tanque t1 = new Tanque("T1", new ArmaRifle(1, 1));
        Tanque t2 = new Tanque("T2", new ArmaRifle(1, 1));
        Tanque t3 = new Tanque("T3", new ArmaRifle(1, 1));

        // Cada tanque dispara al buque
        t1.disparar(buque);
        t2.disparar(buque);
        t3.disparar(buque);

        // Buque debe morir después de 3 disparos
        assertFalse(buque.estaVivo());
        assertEquals(0, buque.getVida());
    }

    @Test
    public void buque_dispara_a_otro_buque_y_lo_destruye() {
        Buque b1 = new Buque("B1", new ArmaRifle(1, 3));
        Buque b2 = new Buque("B2", new ArmaRifle(1, 3));

        // B1 dispara 3 veces a B2
        b1.disparar(b2);
        b1.disparar(b2);
        b1.disparar(b2);

        // B2 debe morir
        assertFalse(b2.estaVivo());
        assertEquals(0, b2.getVida());
    }

    @Test
    public void tanque_con_escudo_resiste_mas_disparos() {
        // Tanque con vida 2
        Tanque tanque = new Tanque("TanqueEscudado", new ArmaRifle(1, 2));
        // Se le pone un escudo que reduce 50% el daño
        tanque.setDefensa(new Escudo(0.5));
        Soldado s = new Soldado("S1", new ArmaRifle(1, 2));

        // Primer disparo del soldado
        s.disparar(tanque);
        // Daño neto = 1 * (1 - 0.5) = 0.5 → Math.round = 1
        // Vida del tanque: 2 - 1 = 1
        assertTrue(tanque.estaVivo());
        assertEquals(1, tanque.getVida());

        // Segundo disparo
        s.disparar(tanque);
        // Vida del tanque: 1 - 1 = 0 → muere
        assertFalse(tanque.estaVivo());
        assertEquals(0, tanque.getVida());
    }

    @Test
    public void tanque_con_escudo_90_por_ciento_no_recibe_dano_de_rifle() {
        // Tanque con vida 2
        Tanque tanque = new Tanque("TanqueBlindado", new ArmaRifle(1, 5));
        // Escudo que reduce 90% del daño
        tanque.setDefensa(new Escudo(0.9));

        // Soldado con rifle de daño 1
        Soldado soldado = new Soldado("S1", new ArmaRifle(1, 5));

        // El soldado dispara 3 veces al tanque
        soldado.disparar(tanque);
        soldado.disparar(tanque);
        soldado.disparar(tanque);

        // Como cada disparo tiene daño 1, y el escudo reduce 90%,
        // el daño neto es: 1 * (1 - 0.9) = 0.1 → round = 0
        // Por lo tanto el tanque no recibe daño.

        // Vida inicial del tanque era 2, debe seguir en 2
        assertEquals(2, tanque.getVida());
        // Y debe seguir vivo
        assertTrue(tanque.estaVivo());
    }
}