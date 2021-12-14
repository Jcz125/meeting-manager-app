package eu.telecomnancy.profrdv.model;

import eu.telecomnancy.profrdv.model.states.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RendezVous {
    private LocalDateTime localDateTime;
    private ArrayList<Utilisateur> utilisateurs;
    private String description;

    private EtatRendezVous etatRendezVous;


    public RendezVous(LocalDateTime localDateTime, ArrayList<Utilisateur> utilisateurs, String description) {
        this.localDateTime = localDateTime;
        this.utilisateurs = utilisateurs;
        this.description = description;
    }


    public void setState(EtatRendezVous etatRendezVous) {
        this.etatRendezVous = etatRendezVous;
    }
}
