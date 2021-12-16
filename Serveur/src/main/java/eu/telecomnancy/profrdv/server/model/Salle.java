package eu.telecomnancy.profrdv.server.model;

import eu.telecomnancy.profrdv.server.SpringConfiguration;
import eu.telecomnancy.profrdv.server.model.data.RendezVousData;
import eu.telecomnancy.profrdv.server.model.data.SalleData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.RendezVousRepository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Salle {
    @Id
    private int numero;
    private int etage;
    private String aile;

    public Salle() {}

    public Salle(int numero, int etage, String aile) {
        this.numero = numero;
        this.etage = etage;
        this.aile = aile;
    }

    public Salle(SalleData data) {
        this(data.numero, data.etage, data.aile);
    }

    public boolean estDisponible(LocalDateTime date) {
        RendezVousRepository rendezVousRepository = (RendezVousRepository) SpringConfiguration.contextProvider().getApplicationContext().getBean("rendezVousRepository");
        for (RendezVous rdv : rendezVousRepository.findAll()) {
            if (rdv.getHoraire().isEqual(date) && rdv.getSalle().getNumero() == this.numero)
                return false;
        }

        return true;
    }


    //region assesseurs
    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public int getEtage() {
        return etage;
    }


    public void setEtage(int etage) {
        this.etage = etage;
    }


    public String getAile() {
        return aile;
    }


    public void setAile(String aile) {
        this.aile = aile;
    }

    public SalleData getData() {
        return new SalleData(numero, etage, aile);
    }
    //endregion assesseurs
}
