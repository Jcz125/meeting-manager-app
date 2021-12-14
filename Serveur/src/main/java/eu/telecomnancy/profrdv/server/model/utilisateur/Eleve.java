package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.RendezVous;

public class Eleve extends Utilisateur {
    public Eleve(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }

    public boolean estDisponible(RendezVous rendezVous) {
        return !this.RDVs.containsKey(rendezVous.getHoraire());
    }
}
