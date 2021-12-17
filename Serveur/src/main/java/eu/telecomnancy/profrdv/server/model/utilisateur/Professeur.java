package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.data.UtilisateurData;
import eu.telecomnancy.profrdv.server.model.disponibilite.Disponibilite;
import eu.telecomnancy.profrdv.server.model.disponibilite.DisponibiliteFixe;
import eu.telecomnancy.profrdv.server.model.disponibilite.ModificateurDisponibilite;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Professeur extends Utilisateur {
    @OneToOne(cascade = CascadeType.ALL)
    private Disponibilite disponibilites;

    public Professeur() {disponibilites = new Disponibilite();}
    public Professeur(UtilisateurData data) {super(data); disponibilites = new Disponibilite();}

    public Professeur(String nom, String prenom, String email) {
        super(nom, prenom, email);
        disponibilites = new Disponibilite();
    }

    public void add(DisponibiliteFixe dispo) {
        disponibilites.add(dispo);
    }

    public void add(ModificateurDisponibilite dispo) {
        disponibilites.add(dispo);
    }

    public boolean estDisponible(LocalDateTime horaire) {
        for (RendezVous rdv : RDVs)
            if (rdv.getHoraire().isEqual(horaire))
                return false;
        return disponibilites.estDisponible(horaire);
    }

    public Disponibilite getDisponibilites() {
        return disponibilites;
    }
}
