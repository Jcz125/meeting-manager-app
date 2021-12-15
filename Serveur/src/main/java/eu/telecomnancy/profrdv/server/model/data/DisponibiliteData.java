package eu.telecomnancy.profrdv.server.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisponibiliteData {
    public int id;
    public DisponibiliteFixeData[] dispo;
    public ModificateurDisponibiliteData[] modifs;


    public DisponibiliteData(int id, DisponibiliteFixeData[] dispo, ModificateurDisponibiliteData[] modifs) {
        this.id = id;
        this.dispo = dispo;
        this.modifs = modifs;
    }
}
