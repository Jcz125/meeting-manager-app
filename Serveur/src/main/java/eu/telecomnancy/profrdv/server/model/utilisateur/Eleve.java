package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.data.UtilisateurData;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Eleve extends Utilisateur {
    public Eleve(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }

    public Eleve() {}

    public Eleve(UtilisateurData data) {
        super(data);
    }


    public boolean estDisponible(LocalDateTime horaire) {
        for (RendezVous rdv : RDVs)
            if (rdv.getHoraire().isEqual(horaire))
                return false;
        return true;
    }
}
