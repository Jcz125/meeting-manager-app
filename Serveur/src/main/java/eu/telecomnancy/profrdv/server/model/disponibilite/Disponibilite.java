package eu.telecomnancy.profrdv.server.model.disponibilite;

import eu.telecomnancy.profrdv.server.model.data.DisponibiliteData;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Disponibilite {
    private int id;
    private ArrayList<DisponibiliteFixe> dispoFixe = null;
    private ArrayList<ModificateurDisponibilite> modifsDispo = null;


    public Disponibilite() {
        this.dispoFixe = new ArrayList<>();
        this.modifsDispo = new ArrayList<>();
    }


    public void add(DayOfWeek jour, LocalTime debut, LocalTime fin) {
        DisponibiliteFixe nouveauDisponibiliteFixe = new DisponibiliteFixe(jour, debut, fin);
        dispoFixe.add(nouveauDisponibiliteFixe);
    }


    public void add(boolean inclut, LocalDateTime debut, LocalDateTime fin) {
        ModificateurDisponibilite nouveauModificateurDisponibilite = new ModificateurDisponibilite(inclut, debut, fin);
        modifsDispo.add(nouveauModificateurDisponibilite);
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
        Pair pair = new Pair(dispoFixe.size(), modifsDispo.size());
        return new DisponibiliteData(id, pair.getDisponibiliteFixeData(), pair.getModificateurDisponibiliteData());
    }
}
