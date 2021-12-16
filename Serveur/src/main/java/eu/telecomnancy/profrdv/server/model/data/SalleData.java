package eu.telecomnancy.profrdv.server.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalleData {
    public Integer numero;
    public Integer etage;
    public String aile;
    public SalleData() {}

    public SalleData(int numero, int etage, String aile) {
        this.numero = numero;
        this.etage =  etage;
        this.aile = aile;
    }
}
