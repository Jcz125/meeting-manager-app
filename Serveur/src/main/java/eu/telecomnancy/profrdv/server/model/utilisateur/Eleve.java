package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.RendezVous;

import javax.persistence.Entity;

@Entity
public class Eleve extends Utilisateur {
    public Eleve(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }

    public Eleve() {}

    public boolean estDisponible(RendezVous rendezVous) {
        for (RendezVous rdv: RDVs) {
            if (rdv.getHoraire() == rendezVous.getHoraire())
                return false;
        }
        return true;
    }
}
