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

    @OneToMany(targetEntity=Disponibilite.class, cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_ecole")
    private List<Disponibilite> disponibilites;

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
        Integer[] disponibilitesIdsArray = new Integer[disponibilites == null ? 0 : disponibilites.size()];
        Integer[] utilisateursIdsArray = new Integer[utilisateurs == null ? 0 : utilisateurs.size()];
        for (int i = 0; i < disponibilitesIdsArray.length; i++) {
            disponibilitesIdsArray[i] = disponibilites.get(i).getId();
        }
        for (int i = 0; i < utilisateursIdsArray.length; i++) {
            utilisateursIdsArray[i] = utilisateurs.get(i).getId();
        }
        return new EcoleData(0, nom, disponibilitesIdsArray, utilisateursIdsArray);
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public Integer getId() {
        return id;
    }
}
