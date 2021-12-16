package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.Salle;
import eu.telecomnancy.profrdv.server.model.data.DisponibiliteData;
import eu.telecomnancy.profrdv.server.model.data.UtilisateurData;
import eu.telecomnancy.profrdv.server.model.disponibilite.DisponibiliteFixe;
import eu.telecomnancy.profrdv.server.model.disponibilite.ModificateurDisponibilite;
import org.springframework.http.RequestEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.DiscriminatorType.INTEGER;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "utilisateur_type", discriminatorType = INTEGER)
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(targetEntity = RendezVous.class, cascade = CascadeType.ALL)
    protected List<RendezVous> RDVs;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(unique = true, nullable = false)
    private String email;
    private String telephone;
    private boolean notification;


    public Utilisateur() {
    }


    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.RDVs = new ArrayList<>();
    }

    public Utilisateur(UtilisateurData data) {
        this.nom = data.nom;
        this.prenom = data.prenom;
        this.email = data.email;
        this.telephone = data.telephone == null ? "" : data.telephone;
        this.notification = data.notification == null ? false : data.notification;
        this.RDVs = new ArrayList<>();
    }


    public void notifier(RendezVous rendezVous) {
        // fonction pour notifier l'utilisateur d'un changement d'état d'un rendez-vous auquel il participe
        if (notification) {
        }
    }


    public void ajouterRDV(RendezVous rendezVous) {
        for (RendezVous rdv : RDVs) {
            if (rdv.getHoraire() == rendezVous.getHoraire())
                return;
        }
        this.RDVs.add(rendezVous);
    }


    public boolean annulerRDV(RendezVous rendezVous) {
        for (RendezVous rdv : RDVs) {
            if (rdv.getHoraire() == rendezVous.getHoraire()) {
                rdv.annuler();
                return true;
            }
        }
        return false;
    }


    public abstract boolean estDisponible(LocalDateTime horaire);


    public boolean prendreRDV(List<Utilisateur> utilisateurs, Salle salle, LocalDateTime date, String titre, String description) {
        utilisateurs.remove(this);
        utilisateurs.add(this);

        RendezVous rendezVous = new RendezVous(date, salle, titre, description);

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


    public UtilisateurData getData() {
        Integer[] RDVsIds = new Integer[RDVs.size()];
        for (int i = 0; i < RDVs.size(); i++) {
            RDVsIds[i] = RDVs.get(i).getId();
        }
        DisponibiliteData disponibiliteData;
        if (this instanceof Professeur) {
            Professeur prof = (Professeur) this;
            disponibiliteData = prof.getDisponibilites().getData();
            return new UtilisateurData(id, nom, prenom, email, telephone, notification, RDVsIds, true, disponibiliteData.dispo, disponibiliteData.modifs);
        }
        return new UtilisateurData(id, nom, prenom, email, telephone, notification, RDVsIds, false, null, null);
    }

    public void updateData(RequestEntity<UtilisateurData> monUtilisateur) {

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


    public Integer getId() {
        return id;
    }
    //endregion
}
