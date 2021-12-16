package eu.telecomnancy.profrdv.server.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModificateurDisponibiliteData {
    public Integer id;
    public Boolean inclut;
    public LocalDateTime debut;
    public LocalDateTime fin;

    public ModificateurDisponibiliteData() {}

    public ModificateurDisponibiliteData(int id, boolean inclut, LocalDateTime debut, LocalDateTime fin) {
        this.id = id;
        this.inclut = inclut;
        this.debut = debut;
        this.fin = fin;
    }
}
