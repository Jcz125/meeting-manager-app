package eu.telecomnancy.profrdv.server.model;

import java.util.ArrayList;

public class Professeur extends Utilisateur {
    private final ArrayList<Disponibilite> disponibilites;


    public Professeur(String nom, String prenom, String email) {
        super(nom, prenom, email);
        disponibilites = new ArrayList<>();
    }

    public void add(Disponibilite disponibilite) {
        disponibilites.add(disponibilite);
    }

    public boolean estDisponible(RendezVous rendezVous) {
        if(true) {
            return true;
        }
        return false;
    }
}
