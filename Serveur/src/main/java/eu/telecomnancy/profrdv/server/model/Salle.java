package eu.telecomnancy.profrdv.server.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Salle {
    private final ArrayList<LocalDateTime> occupation;
    private int numero;
    private int etage;
    private String aile;


    public Salle(int numero, int etage, String aile) {
        this.numero = numero;
        this.etage = etage;
        this.aile = aile;
        this.occupation = new ArrayList<>();
    }


    public boolean estDisponible(LocalDateTime date) {
        for (LocalDateTime localDateTime : occupation)
            if (localDateTime.isEqual(date))
                return false;

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
    //endregion assesseurs
}
