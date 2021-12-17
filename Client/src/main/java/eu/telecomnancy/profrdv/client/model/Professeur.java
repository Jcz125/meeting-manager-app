package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.DisponibiliteFixeData;
import eu.telecomnancy.profrdv.client.model.data.EcoleData;
import eu.telecomnancy.profrdv.client.model.data.ModificateurDisponibiliteData;
import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;

import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import eu.telecomnancy.profrdv.client.model.disponibilite.ModificateurDisponibilite;

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

    public void addDispoFixe(DisponibiliteFixe dispo) {
        fetchData();
        DisponibiliteFixeData[] dId = new DisponibiliteFixeData[data.disponibiliteFixes.length + 1];
        for (int i = 0; i < data.disponibiliteFixes.length; i++) {
            dId[i] = data.disponibiliteFixes[i];
        }
        dId[data.disponibiliteFixes.length] = dispo.getData();
        UtilisateurData data = new UtilisateurData();
        data.disponibiliteFixes = dId;
        updateData(data);
    }

    public void addModifDispo(ModificateurDisponibilite dispo) {
        fetchData();
        ModificateurDisponibiliteData[] dId = new ModificateurDisponibiliteData[data.modificateurDisponibilites.length + 1];
        for (int i = 0; i < data.disponibiliteFixes.length; i++) {
            dId[i] = data.modificateurDisponibilites[i];
        }
        dId[data.modificateurDisponibilites.length] = dispo.getData();
        UtilisateurData data = new UtilisateurData();
        data.modificateurDisponibilites = dId;
        updateData(data);
    }
}
