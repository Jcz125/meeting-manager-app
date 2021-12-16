package eu.telecomnancy.profrdv.client.model.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RendezVousData {
    public Integer id;
    public LocalDateTime horaire;

    public String description;
    public String titre;
    public SalleData salle;

    public EtatRendezVousData etatRendezVous;
    public Map<Integer, Boolean> utilisateursIdsConfirmed;

    public RendezVousData() {}

    public RendezVousData(int id, LocalDateTime horaire, Map<Integer, Boolean> utilisateursIdsConfirmed, String description, String titre, SalleData salle, EtatRendezVousData etatRendezVous) {
        this.description = description;
        this.horaire = horaire;
        this.id = id;
        this.utilisateursIdsConfirmed = utilisateursIdsConfirmed;
        this.titre = titre;
        this.etatRendezVous = etatRendezVous;
        this.salle = salle;
    }
}
