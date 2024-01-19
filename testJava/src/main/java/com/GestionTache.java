package com;

import java.util.*;

public class GestionTache {

    private Map<String, Tache> taches = new HashMap<>();

    public GestionTache() {
    }

    public Map<String, Tache> getTaches() {
        return taches;
    }

    public void ajouterTache(String key, String titre, String description) {
        Tache tache = new Tache(titre, description);
        taches.put(key, tache);
    }

    public void ajouterTacheDuree(String key, String titre, String description, int duree) {
        Tache tache = new Tache(titre, description, duree);
        taches.put(key, tache);
    }

    public void completerTache(String key) throws Exception {
        if (taches.containsKey(key)) {
            Tache tache = taches.get(key);
            tache.setEtat("Completée");
        } else {
            throw new IllegalArgumentException("La tache n'existe pas");
        }

    }

    public boolean verifierTache(String key) throws Exception {
        if (taches.containsKey(key)) {
            if(taches.get(key).getEtat().equals( "Completée")){
                return true;
            }else{
                return false;
            }
        } else {
            throw new IllegalArgumentException("La tache n'existe pas");
        }

    }
}