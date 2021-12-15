package eu.telecomnancy.profrdv.client.model.data;


import java.time.LocalDateTime;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RendezVousData {
    public int id;
    public LocalDateTime horaire;

    public String description;
    public String titre;
    public SalleData salle;

    public EtatRendezVousData etatRendezVous;
    public HashMap<Integer, Boolean> utilisateursIdsConfirmed;


    public RendezVousData(int id, LocalDateTime horaire, HashMap<Integer, Boolean> utilisateursIdsConfirmed, String description, String titre, SalleData salle, EtatRendezVousData etatRendezVous) {
        this.description = description;
        this.horaire = horaire;
        this.id = id;
        this.utilisateursIdsConfirmed = utilisateursIdsConfirmed;
        this.titre = titre;
        this.etatRendezVous = etatRendezVous;
        this.salle = salle;
    }
}
