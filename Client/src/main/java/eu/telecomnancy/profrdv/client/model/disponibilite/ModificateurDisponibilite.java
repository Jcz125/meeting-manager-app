package eu.telecomnancy.profrdv.client.model.disponibilite;

import eu.telecomnancy.profrdv.client.model.data.DisponibiliteFixeData;
import eu.telecomnancy.profrdv.client.model.data.ModificateurDisponibiliteData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

public class ModificateurDisponibilite {
    private ModificateurDisponibiliteData data;

    public ModificateurDisponibilite(ModificateurDisponibiliteData data) {
        this.data = data;
    }

    public ModificateurDisponibilite(boolean inclusion, LocalDateTime debut, LocalDateTime fin) {
        data.inclut = inclusion;
        data.debut = debut;
        data.fin = fin;
        HttpEntity<ModificateurDisponibiliteData> dataRequest = new HttpEntity<>(data);
        RestTemplate restTemplate = new RestTemplate();
        data.id = restTemplate.exchange(
                "http://127.0.0.1:8080/modifdispo",
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
                        "http://127.0.0.1:8080/modifdispo?id=" + data.id,
                        ModificateurDisponibiliteData.class);
    }

    public void updateData(ModificateurDisponibiliteData data) {
        data.id = this.data.id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(
                "http://127.0.0.1:8080/modifdispo?id=" + data.id,
                this.data);
        fetchData();
    }

    public void delete() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(
                "http://127.0.0.1:8080/modifdispo?id=" + data.id);
        data = null;
    }


    public boolean estDansLeCreneau(LocalDateTime horaire) {
        fetchData();
        if (data.debut.isEqual(horaire))
            return true;

        if (horaire.isAfter(data.debut) && horaire.isBefore(data.fin))
            return true;

        if (data.fin.isEqual(horaire))
            return false;

        return false;
    }

    public void setDebut(LocalDateTime debut) {
        ModificateurDisponibiliteData data = new ModificateurDisponibiliteData();
        data.debut = debut;
        updateData(data);
    }


    public void setFin(LocalDateTime fin) {
        ModificateurDisponibiliteData data = new ModificateurDisponibiliteData();
        data.fin = fin;
        updateData(data);
    }


    public void setInclut(Boolean inclut) {
        ModificateurDisponibiliteData data = new ModificateurDisponibiliteData();
        data.inclut = inclut;
        updateData(data);
    }




    public LocalDateTime getDebut() {
        fetchData();
        return data.debut;
    }


    public LocalDateTime getFin() {
        fetchData();
        return data.fin;
    }


    public boolean estInclut() {
        fetchData();
        return data.inclut;
    }

    public ModificateurDisponibiliteData getData() {
        fetchData();
        return data;
    }
}
