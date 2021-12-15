package eu.telecomnancy.profrdv.server.model;

import eu.telecomnancy.profrdv.server.model.states.Demande;
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
    private final Salle salle;
    private String description;
    private String titre;
    private EtatRendezVous etatRendezVous;


    public RendezVous(LocalDateTime horaire, ArrayList<Utilisateur> utilisateurs, Salle salle, String titre, String description) {
        this.horaire = horaire;
        this.utilisateurs = new HashMap<>();

        for (Utilisateur utilisateur : utilisateurs) {
            this.utilisateurs.put(utilisateur, false);
        }

        this.description = description;
        this.titre = titre;
        this.salle = salle;
        this.etatRendezVous = new Demande(this);
    }


    public RendezVous(LocalDateTime horaire, ArrayList<Utilisateur> utilisateurs) {
        this.horaire = horaire;
        this.utilisateurs = new HashMap<>();

        for (Utilisateur utilisateur : utilisateurs) {
            this.utilisateurs.put(utilisateur, false);
        }

        this.salle = null;
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


    public static ArrayList<RendezVous> genererRendezVous(ArrayList<Utilisateur> utilisateurs, LocalDateTime debut, LocalDateTime fin) {
        ArrayList<RendezVous> creneaux = new ArrayList<>();
        LocalDateTime heure = LocalDateTime.from(debut);
        while (!fin.isEqual(heure)) {
            boolean addable = true;
            for (Utilisateur utilisateur : utilisateurs) {
                if (!utilisateur.estDisponible(heure)) {
                    addable = false;
                    break;
                }
            }

            if (addable)
                creneaux.add(new RendezVous(heure, utilisateurs));

            heure = heure.plusMinutes(20);
        }
        return creneaux;
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


    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitre() {
        return this.titre;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }


    public Salle getSalle() {
        return salle;
    }

    //endregion
}
