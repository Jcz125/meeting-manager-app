package eu.telecomnancy.profrdv.server.model.disponibilite;

import eu.telecomnancy.profrdv.server.model.data.DisponibiliteFixeData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class DisponibiliteFixe {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private DayOfWeek jour;
    private LocalTime debut;
    private LocalTime fin;

    public DisponibiliteFixe() {}

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
