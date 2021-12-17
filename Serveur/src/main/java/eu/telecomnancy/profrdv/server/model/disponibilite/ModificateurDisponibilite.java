package eu.telecomnancy.profrdv.server.model.disponibilite;

import eu.telecomnancy.profrdv.server.model.data.DisponibiliteFixeData;
import eu.telecomnancy.profrdv.server.model.data.ModificateurDisponibiliteData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ModificateurDisponibilite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private boolean inclut;

    private LocalDateTime debut;
    private LocalDateTime fin;

    public ModificateurDisponibilite() {}

    public ModificateurDisponibilite(boolean inclusion, LocalDateTime debut, LocalDateTime fin) {
        this.inclut = inclusion;
        this.debut = debut;
        this.fin = fin;
    }

    public ModificateurDisponibilite(ModificateurDisponibiliteData data) {
        this(data.inclut, data.debut, data.fin);
    }


    public boolean estDansLeCreneau(LocalDateTime horaire) {
        if (debut.isEqual(horaire))
            return true;

        if (horaire.isAfter(debut) && horaire.isBefore(fin))
            return true;

        if (fin.isEqual(horaire))
            return false;

        return false;
    }


    public LocalDateTime getDebut() {
        return debut;
    }


    public LocalDateTime getFin() {
        return fin;
    }


    public boolean estInclut() {
        return inclut;
    }


    public ModificateurDisponibiliteData getData() {
        return new ModificateurDisponibiliteData(id, inclut, debut, fin);
    }

    public Integer getId() {
        return id;
    }

    public void updateData(ModificateurDisponibiliteData data) {
        if (data.inclut != null) this.inclut = data.inclut;
        if (data.debut != null) this.debut = data.debut;
        if (data.fin != null) this.fin = data.fin;
    }
}
