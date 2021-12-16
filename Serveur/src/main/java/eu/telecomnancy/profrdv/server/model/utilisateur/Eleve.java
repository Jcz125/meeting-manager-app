package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.RendezVous;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Eleve extends Utilisateur {
    public Eleve(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }


    public Eleve() {
    }


    public boolean estDisponible(LocalDateTime horaire) {
        for (RendezVous rdv : RDVs)
            if (rdv.getHoraire().isEqual(horaire))
                return false;
        return true;
    }
}
