package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.disponibilite.Disponibilite;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Professeur extends Utilisateur {
    private final Disponibilite disponibilites;


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


    public boolean estDisponible(RendezVous rendezVous) {
        if (RDVs.containsKey(rendezVous.getHoraire()))
            return false;
        return disponibilites.estDisponible(rendezVous.getHoraire());
    }
}
