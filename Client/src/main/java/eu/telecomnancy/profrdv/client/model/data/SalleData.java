package eu.telecomnancy.profrdv.client.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalleData {
    public final int id;
    public int numero;
    public int etage;
    public String aile;

    public SalleData(int id, int numero, int etage, String aile) {
        this.id = id;
        this.numero = numero;
        this.etage =  etage;
        this.aile = aile;
    }
}
