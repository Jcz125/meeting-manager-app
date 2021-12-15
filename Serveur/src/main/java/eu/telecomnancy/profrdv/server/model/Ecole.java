package eu.telecomnancy.profrdv.server.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import eu.telecomnancy.profrdv.server.model.data.EcoleData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;



@Entity
public class Ecole {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nom;

    @OneToMany(targetEntity=Salle.class, cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_ecole")
    private List<Salle> salles;

    @OneToMany(targetEntity=Utilisateur.class, cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_ecole")
    private List<Utilisateur> utilisateurs;

    public Ecole() {}

    public Ecole(String nom) {
        this.nom = nom;
        this.utilisateurs = new ArrayList<>();
    }


    public String getNom() {
        return this.nom;
    }

    public EcoleData getData() {
        Integer[] sallesIdsArray = new Integer[salles == null ? 0 : salles.size()];
        Integer[] utilisateursIdsArray = new Integer[utilisateurs == null ? 0 : utilisateurs.size()];
        for (int i = 0; i < sallesIdsArray.length; i++) {
            sallesIdsArray[i] = salles.get(i).getNumero();
        }
        for (int i = 0; i < utilisateursIdsArray.length; i++) {
            utilisateursIdsArray[i] = utilisateurs.get(i).getId();
        }
        return new EcoleData(0, nom, sallesIdsArray, utilisateursIdsArray);
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public Integer getId() {
        return id;
    }
}
