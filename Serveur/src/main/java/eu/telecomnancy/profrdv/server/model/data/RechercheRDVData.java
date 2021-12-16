package eu.telecomnancy.profrdv.server.model.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RechercheRDVData {
    public LocalDateTime debut;
    public LocalDateTime fin;

    public List<Integer> utilisateursIds;

    public RechercheRDVData() {}

    public RechercheRDVData(LocalDateTime debut, LocalDateTime fin, List<Integer> utilisateursIds) {
        this.debut = debut;
        this.fin = fin;
        this.utilisateursIds = utilisateursIds;

    }
}
