package eu.telecomnancy.profrdv.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private boolean notification;

    private ArrayList<RendezVous> RDVs;


    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }


    public void notifier(RendezVous rendezVous) {
        // fonction pour notifier l'utilisateur d'un changement d'état d'un rendez-vous auquel il participe
        if (notification) {
        }
    }


    public boolean ajouterRDV(RendezVous rendezVous) {
        if (!this.RDVs.contains(rendezVous)) {
            this.RDVs.add(rendezVous);
            return true;
        }
        return false;
    }


    public boolean annulerRDV(RendezVous rendezVous) {
        if (this.RDVs.contains(rendezVous)) {
            rendezVous.annuler();
            return true;
        }
        return false;
    }

    public boolean prendreRDV(List<Professeur> profs, List<Eleve> eleves, LocalDateTime date, String titre, String description) {
        return false;
    }


    //region assesseurs
    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public void setNotification(boolean notification) {
        this.notification = notification;
    }
    //endregion
}
