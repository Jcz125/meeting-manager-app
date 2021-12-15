package eu.telecomnancy.profrdv.server.model.utilisateur;

import java.time.LocalDateTime;

public class Eleve extends Utilisateur {
    public Eleve(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }


    public boolean estDisponible(LocalDateTime horaire) {
        return !this.RDVs.containsKey(horaire);
    }
}
