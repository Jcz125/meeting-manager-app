package eu.telecomnancy.profrdv.server.model.disponibilite;

import eu.telecomnancy.profrdv.server.model.data.DisponibiliteData;
import eu.telecomnancy.profrdv.server.model.data.DisponibiliteFixeData;
import eu.telecomnancy.profrdv.server.model.data.ModificateurDisponibiliteData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disponibilite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToMany(targetEntity= DisponibiliteFixe.class, cascade=CascadeType.ALL)
    public List<DisponibiliteFixe> dispoFixe = null;
    @OneToMany(targetEntity=ModificateurDisponibilite.class, cascade=CascadeType.ALL)
    public List<ModificateurDisponibilite> modifsDispo = null;


    public Disponibilite() {
        this.dispoFixe = new ArrayList<>();
        this.modifsDispo = new ArrayList<>();
    }

    public boolean estDisponible(LocalDateTime horaire) {
        for (DisponibiliteFixe disponibiliteFixe : dispoFixe) {
            if (disponibiliteFixe.estDedans(horaire)) {
                for (ModificateurDisponibilite modifDispo : modifsDispo) {
                    if (modifDispo.estDansLeCreneau(horaire) && !modifDispo.estInclut()) {
                        return false;
                    }
                }
                return true;
            }
        }

        for (ModificateurDisponibilite modifDispo : modifsDispo) {
            if (modifDispo.estDansLeCreneau(horaire) && modifDispo.estInclut()) {
                return true;
            }
        }

        return false;
    }


    public DisponibiliteData getData() {
        DisponibiliteFixeData[] disponibiliteFixeData = new DisponibiliteFixeData[dispoFixe == null ? 0 : dispoFixe.size()];
        ModificateurDisponibiliteData[] modificateurDisponibiliteData = new ModificateurDisponibiliteData[modifsDispo == null ? 0 : modifsDispo.size()];
        for (int i = 0; i < disponibiliteFixeData.length; i++) {
            disponibiliteFixeData[i] = dispoFixe.get(i).getData();
        }

        for (int i = 0; i < modificateurDisponibiliteData.length; i++) {
            modificateurDisponibiliteData[i] = modifsDispo.get(i).getData();
        }
        return new DisponibiliteData(disponibiliteFixeData, modificateurDisponibiliteData);
    }

    public void add(DisponibiliteFixe dispo) {
        dispoFixe.add(dispo);
    }

    public void add(ModificateurDisponibilite dispo) {
        modifsDispo.add(dispo);
    }
}
