package main.java.com;

import java.util.Map;

public class GestionTache {

    private Map<String, Tache> taches = new HashMap<>();

    public GestionTache() {
    }

    public void ajouterTache(String key, String titre, String description) {
        Tache tache = new Tache(titre, description);
        taches.put(key, tache);
    }

    public void completerTache(String titre) throws Exception {
        if (taches.containsKey(titre)) {
            taches.Etat = "Completée";

        } else {
            throw new Exception("La tache n'existe pas");
        }

    }

    public boolean verifierTache(String titre) throws Exception {
        if (taches.containsKey(titre)) {
            if(taches.Etat == "Completée"){
                return True;
            }else{
                return False;
            }
        } else {
            throw new Exception("La tache n'existe pas");
        }

    }
}