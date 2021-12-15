package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.Disponibilite;
import eu.telecomnancy.profrdv.server.model.RendezVous;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professeur extends Utilisateur {
    @OneToMany(targetEntity=Disponibilite.class, cascade= CascadeType.ALL)
    private List<Disponibilite> disponibilites;

    public Professeur() {}

    public Professeur(String nom, String prenom, String email) {
        super(nom, prenom, email);
        disponibilites = new ArrayList<>();
    }


    public void add(Disponibilite disponibilite) {
        disponibilites.add(disponibilite);
    }


    public boolean estDisponible(RendezVous rendezVous) {
        for (RendezVous rdv: RDVs) {
            if (rdv.getHoraire() == rendezVous.getHoraire())
                return false;
        }
        for (Disponibilite plage : this.disponibilites) {
            if (plage.getDebut().isBefore(rendezVous.getHoraire())) {
                if (plage.getFin().isAfter((rendezVous.getHoraire()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
