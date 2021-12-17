package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;
import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Professeur extends Utilisateur {

    public Professeur(UtilisateurData response) {
        super(response);
    }


    public Professeur(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }

    public List<DisponibiliteFixe> getDispoJour(DayOfWeek day) {
        ArrayList<DisponibiliteFixe> dispoJour = new ArrayList<>();
        for (DisponibiliteFixe dispo : this.getDisponibiliteFixe()) {
            if (dispo.getJour() == day)
                dispoJour.add(dispo);
        }
        return dispoJour;
    }
}
