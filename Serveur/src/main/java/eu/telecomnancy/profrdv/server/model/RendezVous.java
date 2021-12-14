package eu.telecomnancy.profrdv.server.model;

import eu.telecomnancy.profrdv.server.model.states.EtatRendezVous;
import eu.telecomnancy.profrdv.server.model.states.Realise;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class RendezVous {
    private final LocalDateTime localDateTime;
    private final HashMap<Utilisateur, Boolean> utilisateurHashmap; // on donne une pair pour attribuer une confirmation à tout le monde
    private String description;
    private String titre;

    private EtatRendezVous etatRendezVous;


    public RendezVous(LocalDateTime localDateTime, ArrayList<Utilisateur> utilisateurs, String titre, String description) {
        this.localDateTime = localDateTime;
        this.utilisateurHashmap = new HashMap<>();

        for (Utilisateur utilisateur : utilisateurs) {
            this.utilisateurHashmap.put(utilisateur, false);
        }

        this.description = description;
        this.titre = titre;
    }


    public void notifier() {
        // on notifie tous les utilisateurs d'un changement d'état sauf quand il a été réalisé
        if (!(etatRendezVous instanceof Realise)) {
            for (Utilisateur utilisateur : utilisateurHashmap.keySet()) {
                utilisateur.notifier(this);
            }
        }
    }


    public void ajoutConfirmation(Utilisateur CurrentUtilisateur) {
        utilisateurHashmap.put(CurrentUtilisateur, true);
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
        return this.utilisateurHashmap.keySet();
    }


    public EtatRendezVous getEtatRendezVous() {
        return this.etatRendezVous;
    }


    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
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
