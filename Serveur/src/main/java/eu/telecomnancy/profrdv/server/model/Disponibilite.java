package eu.telecomnancy.profrdv.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Disponibilite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private LocalDateTime debut;
    private LocalDateTime fin;

    public Disponibilite() {}


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

    public Integer getId() {
        return id;
    }
}
