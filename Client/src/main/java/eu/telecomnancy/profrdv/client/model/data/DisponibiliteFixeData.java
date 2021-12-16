package eu.telecomnancy.profrdv.client.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.DayOfWeek;
import java.time.LocalTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisponibiliteFixeData {
    public int id;

    public DayOfWeek jour;
    public LocalTime debut;
    public LocalTime fin;

    public DisponibiliteFixeData() {}

    public DisponibiliteFixeData(int id, DayOfWeek jour, LocalTime debut, LocalTime fin) {
        this.id = id;
        this.jour = jour;
        this.debut = debut;
        this.fin = fin;
    }
}
