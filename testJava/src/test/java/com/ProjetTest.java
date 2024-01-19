package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProjetTest {
    
    @Test
    public void testAjouterTacheProjet(){
        Projet projet = new Projet("projet1");
        projet.ajouterTacheProjet("1","tache1", "tache1");
        assertEquals(1, projet.getTaches().size()); // On vérifie que la tache est bien ajoutée dans la liste de tache du projet
        assertEquals(1, projet.getGestionTache().getTaches().size()); //On vérifie que la tache est bien ajoutée dans la gestion de tache
        projet.ajouterTacheProjet("2","tache2", "tache2");
        assertEquals(2, projet.getTaches().size());
    }

    @Test
    public void testSupprimerTacheProjet(){
        Projet projet = new Projet("projet1");
        projet.ajouterTacheProjet("1","tache1", "tache1");
        projet.retirerTacheProjet("1");
        assertEquals(0, projet.getTaches().size()); // On vérifie que la tache est bien supprimée dans la liste de tache du projet
        assertEquals(0, projet.getGestionTache().getTaches().size()); //On vérifie que la tache est bien supprimée dans la gestion de tache
    }


    @Test
    public void testVerifierTacheProjet() throws Exception{
        Projet projet = new Projet("projet1");
        projet.ajouterTacheProjet("1","tache1", "tache1");
        projet.completerTacheProjet("1");
        assertEquals(true, projet.verifierTacheProjet("1")); // On vérifie que la tache est bien complétée dans la gestion de tache
        projet.ajouterTacheProjet("2","tache1", "tache1");
        assertEquals(false, projet.verifierTacheProjet("2")); // On vérifie que la tache est non complétée dans la gestion de tache
        assertThrows(IllegalArgumentException.class, () -> projet.verifierTacheProjet(null)); 

    }

    @Test
    public void testCompleterTacheProjet() throws Exception{
        Projet projet = new Projet("projet1");
        projet.ajouterTacheProjet("1","tache1", "tache1");
        projet.completerTacheProjet("1");
        assertEquals(true, projet.verifierTacheProjet("1")); // On vérifie que la tache est bien complétée dans la gestion de tache
        assertEquals(true, projet.getGestionTache().verifierTache("1")); // On vérifie que la tache est bien complétée dans la liste de tache du projet
        projet.ajouterTacheProjet("2", "tache2", "tache2");
        assertEquals(false, projet.verifierTacheProjet("2")); // On vérifie que la tache est non complétée dans la gestion de tache
        assertThrows(IllegalArgumentException.class, () -> projet.completerTacheProjet(null)); 
    }

    @Test
    public void testDureeTacheProjet() {
        Projet projet = new Projet("projet1");
        projet.ajouterTacheProjetDuree("1","tache1", "tache1", 2);
        projet.ajouterTacheProjetDuree("2","tache2", "tache2", 5);
        projet.ajouterTacheProjetDuree("3","tache3", "tache3", -2);
        assertEquals(8, projet.calculerDureeTotale(projet.getTaches()));
    }
}
