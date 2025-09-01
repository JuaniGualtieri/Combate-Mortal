package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class GuerraTests {

    @Test
    public void chuck_nunca_muere() {
        ChuckNorris chuckNorris1 = new ChuckNorris(1, 1, true, 1);
        Soldado soldado1 = new Soldado(1, 1, true, 1);

        soldado1.chuckAtaque(chuckNorris1);
        
        assertTrue(chuckNorris1.estoyVivo());
        assertTrue(chuckNorris1.getEstado());
    }

    @Test
    public void chuck_dispara() {
        ChuckNorris chuckNorris1 = new ChuckNorris(1, 1, true, 1);
        Soldado soldado1 = new Soldado(1, 1, true, 1);

        chuckNorris1.dispara(soldado1);

        assertFalse(soldado1.estoyVivo());
        assertFalse(soldado1.getEstado());
    }

    @Test
    public void soldado_recibe_disparo(){
        Soldado soldado1 = new Soldado(1, 1,true,1);
        
        soldado1.recibirAtaque();

        soldado1.estoyVivo();

        assert soldado1.getVida() == 0; 
        assert soldado1.getEstado() == false; 
    }

    @Test
    public void soldado_dispara_a_objetivo() {
        Soldado soldado1 = new Soldado(1, 1, true, 1);
        Soldado soldado2 = new Soldado(1, 1, true, 1);

        soldado1.dispara(soldado2);

        assert soldado2.estoyVivo() == false;
        assertEquals(0, soldado2.getVida());
    }

    @Test
    public void tanque_recibe_1_disparo(){
        Tanque tanque1 = new Tanque(2, 1, true,1);
        
        tanque1.recibirAtaque();

        tanque1.estoyVivo();
    
        assert tanque1.getVida() == 1;
        assert tanque1.getEstado() == true; 
    }


    @Test
    public void tanque_recibe_2_disparos_quema_ropa(){
        Tanque tanque1 = new Tanque(2, 1, true,1);
        
        tanque1.recibirAtaque();
        tanque1.recibirAtaque();

        tanque1.estoyVivo();

        assert tanque1.getVida() == 0; 
        assert tanque1.getEstado() == false; 
    }

    @Test
    public void tanque_recibe_dos_disparos_de_soldado(){
        Tanque tanque1 = new Tanque(2, 1, true,1);
        Soldado soldado1 = new Soldado(1, 1, true,1);
        Soldado soldado2 = new Soldado(1, 1, true,1);

        soldado1.dispara(tanque1);
        soldado2.dispara(tanque1);

        tanque1.estoyVivo();

        assert tanque1.getVida() == 0;
        assert tanque1.getEstado() == false;
    }

    @Test
    public void tanque_dispara_a_tanque_dos_veces(){
        Tanque tanque1 = new Tanque(2, 1, true,1);
        Tanque tanque2 = new Tanque(2, 1, true,1);

        tanque1.dispara(tanque2);
        tanque1.dispara(tanque2);

        tanque2.estoyVivo();

        assert tanque2.getVida() == 0;
        assert tanque2.getEstado() == false;
    }

    @Test
    public void tanque_dispara_a_tanque_una_vez(){
        Tanque tanque1 = new Tanque(2, 1, true,1);
        Tanque tanque2 = new Tanque(2, 1, true,1);

        tanque1.dispara(tanque2);

        tanque2.estoyVivo();

        assert tanque2.getVida() == 1;
        assert tanque2.getEstado() == true;
    } 

    @Test
    public void buque_recibe_3_disparos_de_tanques(){
        Tanque tanque1 = new Tanque(2, 1, true,1);
        Tanque tanque2 = new Tanque(2, 1, true,1);
        Tanque tanque3 = new Tanque(2,1,true,1);

        Buque buque1 = new Buque(3,1,true,1);

        tanque1.dispara(buque1);
        tanque2.dispara(buque1);
        tanque3.dispara(buque1);

        buque1.estoyVivo();

        assert buque1.getVida() == 0;
        assert buque1.getEstado() == false;
    }

    @Test
    public void buque_ataca_buque(){
        Buque buque1 = new Buque(3,1,true,1);
        Buque buque2 = new Buque(3,1,true,1);

        buque2.dispara(buque1);
        buque2.dispara(buque1);
        buque2.dispara(buque1);

        buque1.estoyVivo();

        assert buque1.getVida() == 0;
        assert buque1.getEstado() == false;
    }

  
    
    @Test
    public void tanque_con_escudo_sobrevive_a_dos_tiros() {
        Tanque tanque1 = new Tanque(2, 1, true, 1);
        Escudo e1 = new Escudo(0.5);  // 50% de protección
        tanque1.aplicarResistencia(e1);
    
        tanque1.recibirAtaqueConEscudo(1);
        assertTrue(tanque1.estoyVivo()); // El tanque debería estar vivo
    
        tanque1.recibirAtaqueConEscudo(1);
        assertFalse(tanque1.estoyVivo()); // El tanque debería estar muerto
    }


    




}

