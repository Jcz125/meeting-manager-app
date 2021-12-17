package eu.telecomnancy.profrdv.client.model.disponibilite;

import eu.telecomnancy.profrdv.client.model.data.DisponibiliteFixeData;
import eu.telecomnancy.profrdv.client.model.data.SalleData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DisponibiliteFixe {
    private DisponibiliteFixeData data;

    public DisponibiliteFixe(DisponibiliteFixeData data) {
        this.data = data;
    }

    public DisponibiliteFixe(DayOfWeek jour, LocalTime debut, LocalTime fin) {
        data.jour = jour;
        data.debut = debut;
        data.fin = fin;
        HttpEntity<DisponibiliteFixeData> dataRequest = new HttpEntity<>(data);
        RestTemplate restTemplate = new RestTemplate();
        data.id = restTemplate.exchange(
                "http://127.0.0.1:8080/dispofixe",
                HttpMethod.POST,
                dataRequest,
                Integer.class
        ).getBody();
        fetchData();
    }

    private void fetchData() {
        RestTemplate restTemplate = new RestTemplate();
        this.data =
                restTemplate.getForObject(
                        "http://127.0.0.1:8080/dispofixe?id=" + data.id,
                        DisponibiliteFixeData.class);
    }

    public void updateData(DisponibiliteFixeData data) {
        data.id = this.data.id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(
                "http://127.0.0.1:8080/dispofixe?id=" + data.id,
                this.data);
        fetchData();
    }

    public void delete() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(
                "http://127.0.0.1:8080/dispofixe?id=" + data.id);
        data = null;
    }


    public DayOfWeek getJour() {
        return data.jour;
    }


    public LocalTime getDebut() {
        return data.debut;
    }


    public LocalTime getFin() {
        return data.fin;
    }


    public void setDebut(LocalTime debut) {
        DisponibiliteFixeData data = new DisponibiliteFixeData();
        data.debut = debut;
        updateData(data);
    }


    public void setFin(LocalTime fin) {
        DisponibiliteFixeData data = new DisponibiliteFixeData();
        data.fin = fin;
        updateData(data);
    }


    public void setJour(DayOfWeek jour) {
        DisponibiliteFixeData data = new DisponibiliteFixeData();
        data.jour = jour;
        updateData(data);
    }


    public boolean estDedans(LocalDateTime horaire) {
        fetchData();
        if (data.jour != horaire.getDayOfWeek())
            return false;

        if (horaire.toLocalTime().isBefore(data.debut) || horaire.toLocalTime().isAfter(data.fin))
            return false;

        return !horaire.toLocalTime().equals(data.fin);
    }

    public Integer getId() {
        return data.id;
    }

    public DisponibiliteFixeData getData() {
        fetchData();
        return data;
    }
}
