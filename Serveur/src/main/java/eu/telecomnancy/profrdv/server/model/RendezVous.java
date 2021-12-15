package eu.telecomnancy.profrdv.server.model;

import eu.telecomnancy.profrdv.server.model.states.Demande;
import eu.telecomnancy.profrdv.server.model.states.EtatRendezVous;
import eu.telecomnancy.profrdv.server.model.states.EtatRendezVousEnum;
import eu.telecomnancy.profrdv.server.model.states.Realise;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime horaire;
    @ManyToMany(targetEntity=Utilisateur.class, cascade=CascadeType.ALL)
    private Map<Utilisateur, Boolean> utilisateurs; // on donne une paire pour attribuer une confirmation à tout le monde
    @ManyToOne(cascade=CascadeType.ALL)
    private Salle salle;
    private String description;
    @Column(nullable = false)
    private String titre;
    private EtatRendezVousEnum etatRendezVous;

    public RendezVous() {}


    public RendezVous(LocalDateTime horaire, ArrayList<Utilisateur> utilisateurs, Salle salle, String titre, String description) {
        this.horaire = horaire;
        this.utilisateurs = new HashMap<>();

        for (Utilisateur utilisateur : utilisateurs) {
            this.utilisateurs.put(utilisateur, false);
        }

        this.description = description;
        this.titre = titre;
        this.salle = salle;
        this.etatRendezVous = EtatRendezVousEnum.DEMANDE;
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
        if (!(etatRendezVous == EtatRendezVousEnum.REALISE)) {
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
    public void setState(EtatRendezVousEnum etatRendezVous) {
        this.etatRendezVous = etatRendezVous;
    }


    public void annuler() {
        this.etatRendezVous.annuler(this);
    }


    public void confirmer() {
        this.etatRendezVous.confirmer(this);
    }


    public void demande() {
        this.etatRendezVous.demande(this);
    }


    public void realiser() {
        this.etatRendezVous.realiser(this);
    }
    //endregion


    //region assesseurs
    public Set<Utilisateur> getUtilisateurs() {
        return this.utilisateurs.keySet();
    }


    public EtatRendezVousEnum getEtatRendezVous() {
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

    public Integer getId() {
        return id;
    }

    //endregion
}
