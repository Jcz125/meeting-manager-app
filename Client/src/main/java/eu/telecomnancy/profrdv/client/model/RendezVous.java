package eu.telecomnancy.profrdv.client.model;


import eu.telecomnancy.profrdv.client.model.data.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RendezVous {
    private RendezVousData data;

    public RendezVous(RendezVousData rendezVousREST) {
        this.data = rendezVousREST;
    }

    public static List<RendezVous> genererRendezVous(List<Utilisateur> utilisateurs, LocalDateTime debut, LocalDateTime fin) {
        List<Integer> utilisateursId = new ArrayList<>();
        for (Utilisateur u: utilisateurs) {
            utilisateursId.add(u.getId());
        }
        RechercheRDVData data = new RechercheRDVData(debut, fin , utilisateursId);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<RechercheRDVData> requestUpdate = new HttpEntity<>(data);
        ResponseEntity<RDVList> response =
                restTemplate.exchange(
                        "http://127.0.0.1:8080/genererRendezVous",
                        HttpMethod.POST,
                        requestUpdate, RDVList.class);
        List<RendezVous> rendezVous = new ArrayList<>();
        for (RendezVousData d: response.getBody().rendezVousList) {
            rendezVous.add(new RendezVous(d));
        }
        return rendezVous;
    }

    public void fetchData() {
        RestTemplate restTemplate = new RestTemplate();
        data = restTemplate.getForObject(
                        "http://127.0.0.1:8080/rdv?id=" + data.id,
                        RendezVousData.class);
    }

    public void updateData(RendezVousData data) {
        data.id = this.data.id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(
                "http://127.0.0.1:8080/rdv?id=" + data.id,
                this.data);
    }

    public void delete() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(
                "http://127.0.0.1:8080/rdv?id=" + data.id);
        data = null;
    }

    public void annuler() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(
                "http://127.0.0.1:8080/rdv/annuler?id=" + data.id,
                HttpMethod.POST,
                null, Void.class);
        fetchData();
    }

    //region assesseurs
    public EtatRendezVousData getEtatRendezVous() {
        fetchData();
        return data.etatRendezVous;
    }

    public String getEtatRendezVoustoString() { // utiliser instanceof
        return getEtatRendezVous().toString();
    }

    public LocalDateTime getHoraire() {
        fetchData();
        return data.horaire;
    }

    public String getDescription() {
        fetchData();
        return data.description;
    }

    public String getTitre() {
        fetchData();
        return data.titre;
    }
    public Salle getSalle() {
        fetchData();
        return new Salle(data.salle);
    }


    public void setTitre(String titre) {
        fetchData();
        RendezVousData data = new RendezVousData();
        data.titre = titre;
        updateData(data);
    }

    public void setDescription(String description) {
        fetchData();
        RendezVousData data = new RendezVousData();
        data.description = description;
        updateData(data);
    }

    public void setEtatRendezVous(EtatRendezVousData etatRendezVous) {
        fetchData();
        RendezVousData data = new RendezVousData();
        data.etatRendezVous = etatRendezVous;
        updateData(data);
    }

    public void setHoraire(LocalDateTime horaire) {
        fetchData();
        RendezVousData data = new RendezVousData();
        data.horaire = horaire;
        updateData(data);
    }

    public void setSalle(SalleData salle) {
        fetchData();
        RendezVousData data = new RendezVousData();
        data.salle = salle;
        updateData(data);
    }



    public List<Utilisateur> getUtilisateurs() {
        fetchData();
        List<Utilisateur> utilisateurs = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for (Map.Entry<Integer, Boolean> entry : this.data.utilisateursIdsConfirmed.entrySet()) {
            UtilisateurData response =
                    restTemplate.getForObject(
                            "http://127.0.0.1:8080/utilisateur?id=" + entry.getKey(),
                            UtilisateurData.class);
            if (response.estProf)
                utilisateurs.add(new Professeur(response));
            else
                utilisateurs.add(new Eleve(response));
        }
        return utilisateurs;
    }

    public List<Utilisateur> getProfs() {
        fetchData();
        List<Utilisateur> profs = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for (Map.Entry<Integer, Boolean> entry : this.data.utilisateursIdsConfirmed.entrySet()) {
            UtilisateurData response =
                    restTemplate.getForObject(
                            "http://127.0.0.1:8080/utilisateur?id=" + entry.getKey(),
                            UtilisateurData.class);
            if (response.estProf)
                profs.add(new Professeur(response));
        }
        return profs;
    }

    public List<Utilisateur> getEleves() {
        fetchData();
        List<Utilisateur> eleves = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for (Map.Entry<Integer, Boolean> entry : this.data.utilisateursIdsConfirmed.entrySet()) {
            UtilisateurData response =
                    restTemplate.getForObject(
                            "http://127.0.0.1:8080/utilisateur?id=" + entry.getKey(),
                            UtilisateurData.class);
            if (!response.estProf)
                eleves.add(new Eleve(response));
        }
        return eleves;
    }

    public List<String> getProfstoString() {
        fetchData();
        List<String> profString = new ArrayList<>();
        List<Utilisateur> users = this.getProfs();
        for (Utilisateur user : users)
            profString.add(user.getPrenom() + " " + user.getNom());
        return profString;
    }

    public List<String> getElevestoString() {
        fetchData();
        List<String> eleveString = new ArrayList<>();
        List<Utilisateur> users = this.getEleves();
        for (Utilisateur user : users)
            eleveString.add(user.getPrenom() + " " + user.getNom());
        return eleveString;
    }
    //endregion
}
