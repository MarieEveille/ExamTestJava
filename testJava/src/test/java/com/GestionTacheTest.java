package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GestionTacheTest {
    
    @Test
    public void testAjouterTache(){
        GestionTache gestionTache = new GestionTache();
        gestionTache.ajouterTache("1","en cours", "tache1");
        assertEquals(1, gestionTache.getTaches().size());
    }

    @Test
    public void testCompleterTacheException() throws Exception{
        GestionTache gestionTache = new GestionTache();
        gestionTache.ajouterTache("1","tache", "tache1"); //La tache est initié à "Non commencée" donc on la complète à la ligne suivante
        gestionTache.completerTache("1");
        assertEquals(true, gestionTache.verifierTache("1"));
        assertThrows(IllegalArgumentException.class, () -> gestionTache.completerTache("2")); 
    }

    @Test
    public void testVerifierTache() throws Exception{
        GestionTache gestionTache = new GestionTache();
        gestionTache.ajouterTache("1","tache", "tache1");
        gestionTache.completerTache("1");
        assertEquals(true, gestionTache.verifierTache("1"));
        gestionTache.ajouterTache("2","tach", "tache2");
        assertEquals(false, gestionTache.verifierTache("2"));
        assertThrows(IllegalArgumentException.class, () -> gestionTache.completerTache(null)); 
    }



}