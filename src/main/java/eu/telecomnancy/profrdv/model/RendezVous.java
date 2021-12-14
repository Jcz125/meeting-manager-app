package eu.telecomnancy.profrdv.model;

import eu.telecomnancy.profrdv.model.states.EtatRendezVous;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RendezVous {
    private LocalDateTime localDateTime;
    private ArrayList<Utilisateur> utilisateurs;
    private String description;
    private String titre;

    private EtatRendezVous etatRendezVous;


    public RendezVous(LocalDateTime localDateTime, ArrayList<Utilisateur> utilisateurs, String titre, String description) {
        this.localDateTime = localDateTime;
        this.utilisateurs = utilisateurs;
        this.description = description;
        this.titre = titre;
    }


    //region état rendez-vous
    public void setState(EtatRendezVous etatRendezVous) {
        this.etatRendezVous = etatRendezVous;
    }


    public void annuler() {
        this.etatRendezVous.annuler();
    }


    public void confirmer() {
        this.etatRendezVous.confirmer();
    }


    public void demande() {
        this.etatRendezVous.demande();
    }


    public void realiser() {
        this.etatRendezVous.realiser();
    }
    //endregion


    //region assesseurs
    public ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }


    public EtatRendezVous getEtatRendezVous() {
        return etatRendezVous;
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }


    public String getDescription() {
        return description;
    }


    public String getTitre() {
        return titre;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }


    public void setDescription(String description) {
        this.description = description;
    }
    //endregion
}
