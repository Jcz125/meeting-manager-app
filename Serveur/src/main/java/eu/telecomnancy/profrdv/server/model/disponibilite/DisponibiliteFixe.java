package eu.telecomnancy.profrdv.server.model.disponibilite;

import eu.telecomnancy.profrdv.server.model.data.DisponibiliteFixeData;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DisponibiliteFixe {
    private int id;
    private final DayOfWeek jour;
    private final LocalTime debut;
    private final LocalTime fin;


    public DisponibiliteFixe(DayOfWeek jour, LocalTime debut, LocalTime fin) {
        this.jour = jour;
        this.debut = debut;
        this.fin = fin;
    }


    public DayOfWeek getJour() {
        return jour;
    }


    public LocalTime getDebut() {
        return debut;
    }


    public LocalTime getFin() {
        return fin;
    }


    public boolean estDedans(LocalDateTime horaire) {
        if (jour != horaire.getDayOfWeek())
            return false;

        if (horaire.toLocalTime().isBefore(debut) || horaire.toLocalTime().isAfter(fin))
            return false;

        return !horaire.toLocalTime().equals(fin);
    }


    public DisponibiliteFixeData getData() {
        return new DisponibiliteFixeData(id, jour, debut, fin);
    }
}