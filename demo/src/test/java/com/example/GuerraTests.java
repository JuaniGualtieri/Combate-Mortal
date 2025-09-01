package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class GuerraTests {

    @Test
    public void chuck_nunca_muere() {
        ChuckNorris chuck = new ChuckNorris("Chuck", new ArmaRifle(1, 5));
        Soldado soldado = new Soldado("Soldado1", new ArmaRifle(1, 1));

        soldado.disparar(chuck);

        assertTrue(chuck.estaVivo());
        assertEquals(Integer.MAX_VALUE, chuck.getVida());
    }

    @Test
    public void chuck_dispara_y_mata_a_soldado() {
        ChuckNorris chuck = new ChuckNorris("Chuck", new ArmaRifle(1, 5));
        Soldado soldado = new Soldado("Soldado1", new ArmaRifle(1, 1));

        chuck.disparar(soldado);

        assertFalse(soldado.estaVivo());
        assertEquals(0, soldado.getVida());
    }

    @Test
    public void soldado_muere_al_recibir_un_disparo() {
        Soldado soldado1 = new Soldado("Soldado1", new ArmaRifle(1, 1));
        Soldado soldado2 = new Soldado("Soldado2", new ArmaRifle(1, 1));

        soldado1.disparar(soldado2);

        assertFalse(soldado2.estaVivo());
        assertEquals(0, soldado2.getVida());
    }

    @Test
    public void soldado_dispara_a_otro_soldado() {
        Soldado s1 = new Soldado("S1", new ArmaRifle(1, 1));
        Soldado s2 = new Soldado("S2", new ArmaRifle(1, 1));

        s1.disparar(s2);

        assertFalse(s2.estaVivo());
        assertEquals(0, s2.getVida());
    }

    @Test
    public void tanque_recibe_un_disparo_y_sobrevive() {
        Tanque tanque = new Tanque("Tanque1", new ArmaRifle(1, 1));

        Soldado s = new Soldado("S1", new ArmaRifle(1, 1));
        s.disparar(tanque);

        assertTrue(tanque.estaVivo());
        assertEquals(1, tanque.getVida());
    }

    @Test
    public void tanque_muere_con_dos_disparos() {
        Tanque tanque = new Tanque("Tanque1", new ArmaRifle(1, 2));
        Soldado s1 = new Soldado("S1", new ArmaRifle(1, 1));
        Soldado s2 = new Soldado("S2", new ArmaRifle(1, 1));

        s1.disparar(tanque);
        s2.disparar(tanque);

        assertFalse(tanque.estaVivo());
        assertEquals(0, tanque.getVida());
    }

    @Test
    public void tanque_dispara_a_otro_tanque_dos_veces_y_lo_destruye() {
        Tanque t1 = new Tanque("T1", new ArmaRifle(1, 2));
        Tanque t2 = new Tanque("T2", new ArmaRifle(1, 2));

        t1.disparar(t2);
        t1.disparar(t2);

        assertFalse(t2.estaVivo());
        assertEquals(0, t2.getVida());
    }

    @Test
    public void tanque_dispara_a_otro_tanque_una_vez_y_sobrevive() {
        Tanque t1 = new Tanque("T1", new ArmaRifle(1, 2));
        Tanque t2 = new Tanque("T2", new ArmaRifle(1, 2));

        t1.disparar(t2);

        assertTrue(t2.estaVivo());
        assertEquals(1, t2.getVida());
    }

    @Test
    public void buque_muere_con_tres_disparos_de_tanques() {
        Buque buque = new Buque("Buque1", new ArmaRifle(1, 3));
        Tanque t1 = new Tanque("T1", new ArmaRifle(1, 1));
        Tanque t2 = new Tanque("T2", new ArmaRifle(1, 1));
        Tanque t3 = new Tanque("T3", new ArmaRifle(1, 1));

        t1.disparar(buque);
        t2.disparar(buque);
        t3.disparar(buque);

        assertFalse(buque.estaVivo());
        assertEquals(0, buque.getVida());
    }

    @Test
    public void buque_dispara_a_otro_buque_y_lo_destruye() {
        Buque b1 = new Buque("B1", new ArmaRifle(1, 3));
        Buque b2 = new Buque("B2", new ArmaRifle(1, 3));

        b1.disparar(b2);
        b1.disparar(b2);
        b1.disparar(b2);

        assertFalse(b2.estaVivo());
        assertEquals(0, b2.getVida());
    }

    @Test
    public void tanque_con_escudo_resiste_mas_disparos() {
        Tanque tanque = new Tanque("TanqueEscudado", new ArmaRifle(1, 2));
        tanque.setDefensa(new Escudo(0.5)); // 50% reducción
        Soldado s = new Soldado("S1", new ArmaRifle(1, 2));

        s.disparar(tanque);
        assertTrue(tanque.estaVivo());
        assertEquals(1, tanque.getVida()); // ahora espera 1 porque Math.round(0.5)=1

        s.disparar(tanque);
        assertFalse(tanque.estaVivo());
        assertEquals(0, tanque.getVida());
    }
}
