package eu.telecomnancy.profrdv.client.model;

public class Salle {
    private int numero;
    private int etage;
    private String aile;

    public Salle (int numero, int etage, String aile) {
        this.numero = numero;
        this.etage =  etage;
        this.aile = aile;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getEtage() {
        return etage;
    }

    public void setAile(String aile) {
        this.aile = aile;
    }

    public String getAile() {
        return aile;
    }
}
