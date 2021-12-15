package eu.telecomnancy.profrdv.client.model.data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisponibiliteData {
    public int id;
    public LocalDateTime debut;
    public LocalDateTime fin;


    public DisponibiliteData(int id, LocalDateTime debut, LocalDateTime fin) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
    }
}
