package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.DisponibiliteData;

import java.time.LocalDateTime;

public class Disponibilite {
    private DisponibiliteData disponibiliteREST;

    public Disponibilite(DisponibiliteData disponibiliteREST) {
        this.disponibiliteREST = disponibiliteREST;
    }

    public void setFin(LocalDateTime fin) {
        disponibiliteREST.fin = fin;
    }

    public void setDebut(LocalDateTime debut) {
        disponibiliteREST.debut = debut;
    }

    public LocalDateTime getFin() {
        return disponibiliteREST.fin;
    }


    public LocalDateTime getDebut() {
        return disponibiliteREST.debut;
    }
}
