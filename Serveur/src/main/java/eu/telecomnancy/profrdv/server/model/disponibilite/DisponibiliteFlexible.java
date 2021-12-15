package eu.telecomnancy.profrdv.server.model.disponibilite;

import java.time.LocalDateTime;

public class DisponibiliteFlexible {
    private final boolean inclut;
    private final LocalDateTime debut;
    private final LocalDateTime fin;


    public DisponibiliteFlexible(boolean inclusion, LocalDateTime debut, LocalDateTime fin) {
        this.inclut = inclusion;
        this.debut = debut;
        this.fin = fin;
    }


    public boolean estDedans(LocalDateTime horaire) {
        if (debut.isEqual(horaire)) {
            return inclut;
        }
        if (debut.isBefore(horaire) && fin.isAfter(horaire)) {
            return inclut;
        }
        return false;
    }


    public LocalDateTime getDebut() {
        return debut;
    }


    public LocalDateTime getFin() {
        return fin;
    }


    public boolean getInclut() {
        return inclut;
    }
}
