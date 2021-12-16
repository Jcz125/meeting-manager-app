package eu.telecomnancy.profrdv.client.model.disponibilite;

import eu.telecomnancy.profrdv.client.model.data.ModificateurDisponibiliteData;

import java.time.LocalDateTime;

public class ModificateurDisponibilite {
    private ModificateurDisponibiliteData data;

    public ModificateurDisponibilite(ModificateurDisponibiliteData data) {
        this.data = data;
    }

    public ModificateurDisponibilite(boolean inclusion, LocalDateTime debut, LocalDateTime fin) {
        data.inclut = inclusion;
        data.debut = debut;
        data.fin = fin;
    }


    public boolean estDansLeCreneau(LocalDateTime horaire) {
        if (data.debut.isEqual(horaire))
            return true;

        if (horaire.isAfter(data.debut) && horaire.isBefore(data.fin))
            return true;

        if (data.fin.isEqual(horaire))
            return false;

        return false;
    }


    public LocalDateTime getDebut() {
        return data.debut;
    }


    public LocalDateTime getFin() {
        return data.fin;
    }


    public boolean estInclut() {
        return data.inclut;
    }
}
