package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.Salle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Utilisateur {
    protected final HashMap<LocalDateTime, RendezVous> RDVs;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private boolean notification;


    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.RDVs = new HashMap<>();
    }


    public void notifier(RendezVous rendezVous) {
        // fonction pour notifier l'utilisateur d'un changement d'état d'un rendez-vous auquel il participe
        if (notification) {
        }
    }


    public void ajouterRDV(RendezVous rendezVous) {
        if (!this.RDVs.containsKey(rendezVous.getHoraire())) {
            this.RDVs.put(rendezVous.getHoraire(), rendezVous);
        }
    }


    public boolean annulerRDV(RendezVous rendezVous) {
        if (this.RDVs.containsKey(rendezVous.getHoraire())) {
            rendezVous.annuler();
            return true;
        }
        return false;
    }


    public abstract boolean estDisponible(LocalDateTime horaire);


    public boolean prendreRDV(ArrayList<Utilisateur> utilisateurs, Salle salle, LocalDateTime date, String titre, String description) {
        utilisateurs.remove(this);
        utilisateurs.add(this);

        RendezVous rendezVous = new RendezVous(date, utilisateurs, salle, titre, description);

        for (Utilisateur utilisateur : utilisateurs) {
            if (!utilisateur.estDisponible(rendezVous.getHoraire()))
                return false;
        }

        if (!salle.estDisponible(date))
            return false;

        for (Utilisateur utilisateur : utilisateurs)
            utilisateur.ajouterRDV(rendezVous);

        return true;
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
