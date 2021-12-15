package eu.telecomnancy.profrdv.client.model.data;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EcoleData {
    public int id;
    public String nom;
    public Integer[] disponibilitesIds;
    public Integer[] utilisateursIds;

    public EcoleData() {}

    public EcoleData(int id, String nom, Integer[] disponibilitesIds, Integer[] utilisateursIds) {
        this.id = id;
        this.nom = nom;
        this.disponibilitesIds = disponibilitesIds;
        this.utilisateursIds = utilisateursIds;
    }
}
