package test.java.com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.GestionTache;
import com.example.Tache;

public class GestionTacheTest {
    
    @Test
    public void testAjouterTache(){
        GestionTache gestionTache = new GestionTache();
        gestionTache.ajouterTache("en cours", "tache1");
        assertEquals(1, gestionTache.getTaches().size());
    }
}