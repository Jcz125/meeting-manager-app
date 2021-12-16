package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.RendezVousData;
import eu.telecomnancy.profrdv.client.model.data.SalleData;
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
        data.numero = restTemplate.exchange(
                "http://127.0.0.1:8080/salle",
                HttpMethod.POST,
                dataRequest,
                Integer.class
        ).getBody();
        fetchData();
    }

    public void fetchData() {
        RestTemplate restTemplate = new RestTemplate();
        this.data =
                restTemplate.getForObject(
                        "http://127.0.0.1:8080/salle?id=" + data.numero,
                        SalleData.class);
    }

    public void updateData(SalleData data) {
        data.numero = this.data.numero;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(
                "http://127.0.0.1:8080/salle?id=" + data.numero,
                this.data);
    }

    public SalleData getData() {
        return data;
    }

    public void setEtage(int etage) {
        fetchData();
        SalleData data = new SalleData();
        data.etage = etage;
        updateData(data);
    }

    public void setAile(String aile) {
        fetchData();
        SalleData data = new SalleData();
        data.aile = aile;
        updateData(data);
    }

    public int getNumero() {
        fetchData();
        return data.numero;
    }

    public int getEtage() {
        fetchData();
        return data.etage;
    }

    public String getAile() {
        fetchData();
        return data.aile;
    }
}
