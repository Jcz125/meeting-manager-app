package eu.telecomnancy.profrdv.client.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EcoleData {
    public int id;
    public String nom;
    public Integer[] salleIds;
    public Integer[] utilisateursIds;

    public EcoleData() {}

    public EcoleData(int id, String nom, Integer[] salleIds, Integer[] utilisateursIds) {
        this.id = id;
        this.nom = nom;
        this.salleIds = salleIds;
        this.utilisateursIds = utilisateursIds;
    }
}
