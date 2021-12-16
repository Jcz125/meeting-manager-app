package eu.telecomnancy.profrdv.client.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisponibiliteData {
    public DisponibiliteFixeData[] dispo;
    public ModificateurDisponibiliteData[] modifs;

    public  DisponibiliteData() {}

    public DisponibiliteData(DisponibiliteFixeData[] dispo, ModificateurDisponibiliteData[] modifs) {
        this.dispo = dispo;
        this.modifs = modifs;
    }
}
