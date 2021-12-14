package eu.telecomnancy.profrdv.server.model;

import java.time.LocalDateTime;

public class Disponibilite {
    private final LocalDateTime debut;
    private final LocalDateTime fin;


    public Disponibilite(LocalDateTime debut, LocalDateTime fin) {
        this.debut = debut;
        this.fin = fin;
    }


    public LocalDateTime getFin() {
        return fin;
    }


    public LocalDateTime getDebut() {
        return debut;
    }
}
