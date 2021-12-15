package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.SalleData;

public class Salle {
    private SalleData salleREST;

    public Salle (SalleData salleREST) {
        this.salleREST = salleREST;
    }

    public Salle (int numero, int etage, String aile) {
        salleREST.numero = numero;
        salleREST.etage =  etage;
        salleREST.aile = aile;
    }

    public int getNumero() {
        return salleREST.numero;
    }

    public void setNumero(int numero) {
        salleREST.numero = numero;
    }

    public void setEtage(int etage) {
        salleREST.etage = etage;
    }

    public int getEtage() {
        return salleREST.etage;
    }

    public void setAile(String aile) {
        salleREST.aile = aile;
    }

    public String getAile() {
        return salleREST.aile;
    }
}
