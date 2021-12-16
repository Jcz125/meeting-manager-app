package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.SalleData;
import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class Salle {
    private SalleData data;

    public Salle (SalleData salleREST) {
        this.data = salleREST;
    }

    public Salle (int numero, int etage, String aile) {
        data.numero = numero;
        data.etage =  etage;
        data.aile = aile;
        HttpEntity<SalleData> dataRequest = new HttpEntity<>(data);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(
                "http://127.0.0.1:8080/salle",
                HttpMethod.POST,
                dataRequest,
                Void.class
        );
    }

    public void updateData() {
        RestTemplate restTemplate = new RestTemplate();
        this.data =
                restTemplate.getForObject(
                        "http://127.0.0.1:8080/salle?id=" + data.numero,
                        SalleData.class);
    }

    public int getNumero() {
        updateData();
        return data.numero;
    }

    public void setNumero(int numero) {
        data.numero = numero;
    }

    public void setEtage(int etage) {
        data.etage = etage;
    }

    public int getEtage() {
        updateData();
        return data.etage;
    }

    public void setAile(String aile) {
        data.aile = aile;
    }

    public String getAile() {
        updateData();
        return data.aile;
    }
}
