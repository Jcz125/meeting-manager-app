package eu.telecomnancy.profrdv.server.model;

import eu.telecomnancy.profrdv.server.SpringConfiguration;
import eu.telecomnancy.profrdv.server.model.data.RendezVousData;
import eu.telecomnancy.profrdv.server.model.states.EtatRendezVousEnum;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.SalleRepository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime horaire;
    @ManyToMany(targetEntity = Utilisateur.class, cascade = CascadeType.ALL)
    private Map<Utilisateur, Boolean> utilisateurs; // on donne une paire pour attribuer une confirmation à tout le monde
    @ManyToOne(cascade = CascadeType.ALL)
    private Salle salle;
    private String description;
    @Column(nullable = false)
    private String titre;
    private EtatRendezVousEnum etatRendezVous;


    public RendezVous() {
    }


    public RendezVous(LocalDateTime horaire, Salle salle, String titre, String description) {
        this.horaire = horaire;
        this.utilisateurs = new HashMap<>();
        this.description = description;
        this.titre = titre;
        this.salle = salle;
        this.etatRendezVous = EtatRendezVousEnum.DEMANDE;
    }


    public RendezVous(RendezVousData data) {
        SalleRepository salleRepository = (SalleRepository) SpringConfiguration.contextProvider().getApplicationContext().getBean("salleRepository");
        Optional<Salle> salle = salleRepository.findById(data.salle.numero);
        this.horaire = data.horaire;
        this.utilisateurs = new HashMap<>();
        this.description = data.description;
        this.titre = data.titre;
        this.salle = salle.isEmpty() ? null : salle.get();
        this.etatRendezVous = EtatRendezVousEnum.DEMANDE;
    }


    public RendezVous(LocalDateTime horaire, List<Utilisateur> utilisateurs) {
        this.horaire = horaire;
        this.utilisateurs = new HashMap<>();

        for (Utilisateur utilisateur : utilisateurs) {
            this.utilisateurs.put(utilisateur, false);
        }

        this.salle = null;
    }


    public void updateData(RendezVousData data) {
        if (etatRendezVous != EtatRendezVousEnum.DEMANDE && etatRendezVous == EtatRendezVousEnum.CONFIRME)
            return;
        if (data.titre != null) this.titre = data.titre;
        if (data.description != null) this.description = data.description;
        if (etatRendezVous != EtatRendezVousEnum.DEMANDE)
            return;
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


    public static List<RendezVous> genererRendezVous(List<Utilisateur> utilisateurs, LocalDateTime debut, LocalDateTime fin) {
        ArrayList<RendezVous> creneaux = new ArrayList<>();
        LocalDateTime heure = LocalDateTime.from(debut);
        while (!fin.isEqual(heure) || fin.isBefore(heure)) {
            boolean addable = true;
            for (Utilisateur utilisateur : utilisateurs) {
                if (!utilisateur.estDisponible(heure)) {
                    addable = false;
                    break;
                }
            }

            if (addable)
                creneaux.add(new RendezVous(LocalDateTime.from(heure), utilisateurs));

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


    public RendezVousData getData() {
        Map<Integer, Boolean> utilisateursIdsConfirmed = new HashMap<>();
        for (Utilisateur utilisateur : utilisateurs.keySet()) {
            utilisateursIdsConfirmed.put(utilisateur.getId(), utilisateurs.get(utilisateur));
        }
        return new RendezVousData(id, horaire, utilisateursIdsConfirmed, description, titre, salle == null ? null : salle.getData(), etatRendezVous == null ? null : etatRendezVous.getData());
    }


    public boolean peutEtreSupprimer() {
        return !utilisateurs.containsValue(true);
    }

    //endregion
}
