package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.disponibilite.Disponibilite;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Professeur extends Utilisateur {
    @OneToOne(cascade= CascadeType.ALL)
    private Disponibilite disponibilites;

    public Professeur() {}

    public Professeur(String nom, String prenom, String email) {
        super(nom, prenom, email);
        disponibilites = new Disponibilite();
    }


    public void add(DayOfWeek jour, LocalTime debut, LocalTime fin) {
        disponibilites.add(jour, debut, fin);
    }


    public void add(boolean inclut, LocalDateTime debut, LocalDateTime fin) {
        disponibilites.add(inclut, debut, fin);
    }


    public boolean estDisponible(LocalDateTime horaire) {
        if (RDVs.containsKey(horaire))
            return false;
        return disponibilites.estDisponible(horaire);
    }
}
