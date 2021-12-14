package eu.telecomnancy.profrdv.server.model;

import eu.telecomnancy.profrdv.server.model.states.EtatRendezVous;
import eu.telecomnancy.profrdv.server.model.states.Realise;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class RendezVous {

    private final LocalDateTime horaire;
    private final HashMap<Utilisateur, Boolean> utilisateurs; // on donne une paire pour attribuer une confirmation à tout le monde

    private String description;
    private String titre;
    private Salle salle;

    private EtatRendezVous etatRendezVous;


    public RendezVous(LocalDateTime horaire, ArrayList<Utilisateur> utilisateurs, String titre, String description) {
        this.horaire = horaire;
        this.utilisateurs = new HashMap<>();

        for (Utilisateur utilisateur : utilisateurs) {
            this.utilisateurs.put(utilisateur, false);
        }

        this.description = description;
        this.titre = titre;
    }


    public void notifier() {
        // on notifie tous les utilisateurs d'un changement d'état sauf quand il a été réalisé
        if (!(etatRendezVous instanceof Realise)) {
            for (Utilisateur utilisateur : utilisateurs.keySet()) {
                utilisateur.notifier(this);
            }
        }
    }


    public void ajoutConfirmation(Utilisateur CurrentUtilisateur) {
        utilisateurs.put(CurrentUtilisateur, true);
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
    public Set<Utilisateur> getUtilisateurs() {
        return this.utilisateurs.keySet();
    }


    public EtatRendezVous getEtatRendezVous() {
        return this.etatRendezVous;
    }


    public LocalDateTime getHoraire() {
        return this.horaire;
    }


    public String getDescription() {
        return this.description;
    }


    public String getTitre() {
        return this.titre;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }


    public void setDescription(String description) {
        this.description = description;
    }
    //endregion
}
