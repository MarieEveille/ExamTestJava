package com;

public class Tache {
    private String Titre;
    private String Description;
    private String Etat;
    private int Duree;

    public Tache(String titre, String description) {
        Titre = titre;
        Description = description;
        Etat = "Non commencée";
    }

    public Tache(String titre, String description, int duree) {
        Titre = titre;
        Description = description;
        Etat = "Non commencée";
        if(duree <= 0){
            Duree = 1;
        }
        else{
            Duree = duree;
        }
    }

    public int getDuree() {
        return Duree;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }
    
}
