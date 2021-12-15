package eu.telecomnancy.profrdv.client.model.data;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EcoleData {
    public int id;
    public String nom;
    public List<Integer> disponibilitesIds;
    public List<Integer> utilisateursIds;

    public EcoleData(int id, String nom, List<Integer> disponibilitesIds, List<Integer> utilisateursIds) {
        this.id = id;
        this.nom = nom;
        this.disponibilitesIds = disponibilitesIds;
        this.utilisateursIds = utilisateursIds;
    }
}
