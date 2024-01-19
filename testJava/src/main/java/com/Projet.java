package com;

import java.util.*;

public class Projet {

    private String nom;
    private List<Tache> taches = new ArrayList<>();
    private List<Tache> dureeTache = new ArrayList<>();
    private GestionTache gestionTache = new GestionTache();

    public Projet(String nom) {
        this.nom = nom;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public GestionTache getGestionTache() {
        return gestionTache;
    }

    public void ajouterTacheProjet(String key, String titre, String description){
        gestionTache.ajouterTache(key, titre, description);
        taches.add(gestionTache.getTaches().get(key));
    }

    public void ajouterTacheProjetDuree(String key, String titre, String description, int duree){
        gestionTache.ajouterTacheDuree(key, titre, description, duree);
        taches.add(gestionTache.getTaches().get(key));
    }

    public void retirerTacheProjet(String key){
        if(!gestionTache.getTaches().containsKey(key)){
            throw new IllegalArgumentException("La tache n'existe pas");
        }
        else{
            taches.remove(gestionTache.getTaches().get(key));
            gestionTache.getTaches().remove(key);
        }
    }

    public void completerTacheProjet(String key) throws Exception{
        if(!gestionTache.getTaches().containsKey(key)){
            throw new IllegalArgumentException("La tache n'existe pas");
        }
        else {
            gestionTache.completerTache(key);
        }
    }

    public boolean verifierTacheProjet(String key) throws Exception{
        if(!gestionTache.getTaches().containsKey(key)){
            throw new IllegalArgumentException("La tache n'existe pas");
        }
        else{
            return gestionTache.verifierTache(key);
        }
    }

    public int calculerDureeTotale(List<Tache> dureeTaches){
        int dureeTotale = 0;
        for(Tache tache : taches){
            dureeTotale += tache.getDuree();
        }
        return dureeTotale;
    }
    
}
