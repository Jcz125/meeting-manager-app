package eu.telecomnancy.profrdv.server.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.*;

import eu.telecomnancy.profrdv.server.SpringConfiguration;
import eu.telecomnancy.profrdv.server.model.data.EcoleData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.SalleRepository;
import eu.telecomnancy.profrdv.server.repository.UtilisateurRepository;


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
        this.salles = new ArrayList<>();
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

    public void updateData(EcoleData data) {
        if (data.nom != null) this.nom = data.nom;
        if (data.salleIds != null) {
            salles = new ArrayList<>(data.salleIds.length);
            SalleRepository salleRepository = (SalleRepository) SpringConfiguration.contextProvider().getApplicationContext().getBean("salleRepository");
            for (int id: data.salleIds) {
                Optional<Salle> salle = salleRepository.findById(id);
                if (salle.isPresent()) {
                    salles.add(salle.get());
                }
            }
        }
        if (data.utilisateursIds != null) {
            utilisateurs = new ArrayList<>(data.utilisateursIds.length);
            UtilisateurRepository utilisateurRepository = (UtilisateurRepository) SpringConfiguration.contextProvider().getApplicationContext().getBean("utilisateurRepository");
            for (int id: data.utilisateursIds) {
                Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
                if (utilisateur.isPresent()) {
                    utilisateurs.add(utilisateur.get());
                }
            }
        }
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public void addSalle(Salle salle) {
        salles.add(salle);
    }


    public Integer getId() {
        return id;
    }
}
