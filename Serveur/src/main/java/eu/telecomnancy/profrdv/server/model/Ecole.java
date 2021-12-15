package eu.telecomnancy.profrdv.server.model;

import eu.telecomnancy.profrdv.server.model.data.EcoleData;

import java.util.ArrayList;
import java.util.List;

public class Ecole {
    private String nom;
    private List<Integer> disponibilitesIds;
    private List<Integer> utilisateursIds;

    public Ecole(String nom) {
        this.nom = nom;
        this.utilisateursIds = new ArrayList<>();
    }

    public String getNom() {
        return this.nom;
    }

    public EcoleData getData() {
        Integer[] disponibilitesIdsArray = new Integer[disponibilitesIds == null ? 0 : disponibilitesIds.size()];
        Integer[] utilisateursIdsArray = new Integer[utilisateursIds == null ? 0 : utilisateursIds.size()];
        return new EcoleData(0, nom, disponibilitesIdsArray, utilisateursIds.toArray(utilisateursIdsArray));
    }

    public void addUtilisateur(Integer utilisateurId) {
        utilisateursIds.add(utilisateurId);
    }
}
