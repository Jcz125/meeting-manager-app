package eu.telecomnancy.profrdv.client.model.disponibilite;

import eu.telecomnancy.profrdv.client.model.data.DisponibiliteFixeData;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DisponibiliteFixe {
    private DisponibiliteFixeData data;

    public DisponibiliteFixe(DisponibiliteFixeData data) {
        this.data = data;
    }

    public DisponibiliteFixe(DayOfWeek jour, LocalTime debut, LocalTime fin) {
        data.jour = jour;
        data.debut = debut;
        data.fin = fin;
    }


    public DayOfWeek getJour() {
        return data.jour;
    }


    public LocalTime getDebut() {
        return data.debut;
    }


    public LocalTime getFin() {
        return data.fin;
    }


    public boolean estDedans(LocalDateTime horaire) {
        if (data.jour != horaire.getDayOfWeek())
            return false;

        if (horaire.toLocalTime().isBefore(data.debut) || horaire.toLocalTime().isAfter(data.fin))
            return false;

        return !horaire.toLocalTime().equals(data.fin);
    }
}
