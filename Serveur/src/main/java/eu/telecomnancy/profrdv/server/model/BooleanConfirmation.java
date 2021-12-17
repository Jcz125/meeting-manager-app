package eu.telecomnancy.profrdv.server.model;

import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;

import javax.persistence.*;

@Entity
@Table(name = "boolean_confirmation")
public class BooleanConfirmation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Boolean confirme = false;
    @ManyToOne(targetEntity=Utilisateur.class, cascade=CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public BooleanConfirmation() {
    }

    public BooleanConfirmation(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Boolean getConfirme() {
        return confirme;
    }

    public void setConfirme(Boolean confirme) {
        this.confirme = confirme;
    }
}