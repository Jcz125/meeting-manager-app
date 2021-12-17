package eu.telecomnancy.profrdv.server.model.utilisateur;

import eu.telecomnancy.profrdv.server.SpringConfiguration;
import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.data.DisponibiliteFixeData;
import eu.telecomnancy.profrdv.server.model.data.ModificateurDisponibiliteData;
import eu.telecomnancy.profrdv.server.model.data.UtilisateurData;
import eu.telecomnancy.profrdv.server.model.disponibilite.Disponibilite;
import eu.telecomnancy.profrdv.server.model.disponibilite.DisponibiliteFixe;
import eu.telecomnancy.profrdv.server.model.disponibilite.ModificateurDisponibilite;
import eu.telecomnancy.profrdv.server.repository.DisponibiliteRepositoryFixe;
import eu.telecomnancy.profrdv.server.repository.ModificateurDisponibiliteRepository;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Entity
public class Professeur extends Utilisateur {
    @OneToOne(cascade = CascadeType.ALL)
    private Disponibilite disponibilites;

    public Professeur() {disponibilites = new Disponibilite();}
    public Professeur(UtilisateurData data) {super(data); disponibilites = new Disponibilite();}

    public Professeur(String nom, String prenom, String email) {
        super(nom, prenom, email);
        disponibilites = new Disponibilite();
    }

    public void add(DisponibiliteFixe dispo) {
        disponibilites.add(dispo);
    }

    public void add(ModificateurDisponibilite dispo) {
        disponibilites.add(dispo);
    }

    public boolean estDisponible(LocalDateTime horaire) {
        for (RendezVous rdv : RDVs)
            if (rdv.getHoraire().isEqual(horaire))
                return false;
        return disponibilites.estDisponible(horaire);
    }

    public Disponibilite getDisponibilites() {
        return disponibilites;
    }

    @Override
    public void updateData(UtilisateurData data) {
        super.updateData(data);
        if (data.disponibiliteFixes != null) {
            RDVs = new ArrayList<>(data.disponibiliteFixes.length);
            DisponibiliteRepositoryFixe disponibiliteRepositoryFixe = (DisponibiliteRepositoryFixe) SpringConfiguration.contextProvider().getApplicationContext().getBean("disponibiliteRepositoryFixe");
            for (DisponibiliteFixeData dispoData: data.disponibiliteFixes) {
                Optional<DisponibiliteFixe> dispo = disponibiliteRepositoryFixe.findById(dispoData.id);
                if (dispo.isPresent()) {
                    disponibilites.dispoFixe.add(dispo.get());
                }
            }
        }
        if (data.modificateurDisponibilites != null) {
            RDVs = new ArrayList<>(data.modificateurDisponibilites.length);
            ModificateurDisponibiliteRepository modificateurDisponibiliteRepository = (ModificateurDisponibiliteRepository) SpringConfiguration.contextProvider().getApplicationContext().getBean("modificateurDisponibiliteRepository");
            for (ModificateurDisponibiliteData dispoData: data.modificateurDisponibilites) {
                Optional<ModificateurDisponibilite> dispo = modificateurDisponibiliteRepository.findById(dispoData.id);
                if (dispo.isPresent()) {
                    disponibilites.modifsDispo.add(dispo.get());
                }
            }
        }
    }
}
