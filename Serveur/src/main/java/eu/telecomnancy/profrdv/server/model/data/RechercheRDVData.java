package eu.telecomnancy.profrdv.server.model.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RechercheRDVData {
    public LocalDateTime debut;
    public LocalDateTime fin;

    public Integer[] utilisateursIds;

    public RechercheRDVData() {}

    public RechercheRDVData(LocalDateTime debut, LocalDateTime fin, Integer[] utilisateursIds) {
        this.debut = debut;
        this.fin = fin;
        this.utilisateursIds = utilisateursIds;

    }
}