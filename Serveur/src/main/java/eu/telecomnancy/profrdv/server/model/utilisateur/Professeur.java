package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.Disponibilite;
import eu.telecomnancy.profrdv.server.model.RendezVous;

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
        if (!this.RDVs.containsKey(rendezVous.getHoraire())) {
            for (Disponibilite plage : this.disponibilites) {
                if (plage.getDebut().isBefore(rendezVous.getHoraire())) {
                    if (plage.getFin().isAfter((rendezVous.getHoraire()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
