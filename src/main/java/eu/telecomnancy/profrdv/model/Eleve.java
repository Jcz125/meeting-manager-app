package eu.telecomnancy.profrdv.model;

import java.time.LocalDateTime;
import java.util.List;

public class Eleve extends Utilisateur {
    public Eleve(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }

    public void prendreRDV(Eleve e, LocalDateTime date) {

    }
    public void prendreRDV(List<Eleve> eleves, LocalDateTime date) {

    }
    public void prendreRDV(List<Professeur> profs, List<Eleve> eleves, LocalDateTime date) {

    }
}
