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


    //region assesseurs
    public EtatRendezVousData getEtatRendezVous() {
        return data.etatRendezVous;
    }

    public String getEtatRendezVoustoString() { // utiliser instanceof
        return "";
    }


    public LocalDateTime getHoraire() {
        return data.horaire;
    }


    public String getDescription() {
        return data.description;
    }


    public String getTitre() {
        return data.titre;
    }


    public void setTitre(String titre) {
        data.titre = titre;
    }


    public void setDescription(String description) {
        data.description = description;
    }

    public void setEtatRendezVous(EtatRendezVousData etatRendezVous) {
        data.etatRendezVous = etatRendezVous;
    }

    public void setHoraire(LocalDateTime horaire) {
        data.horaire = horaire;
    }

    public void setSalle(SalleData salle) {
        data.salle = salle;
    }

    public Salle getSalle() {
        return new Salle(data.salle);
    }


    public List<Utilisateur> getUtilisateurs() {
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
        List<String> profString = new ArrayList<>();
        List<Utilisateur> users = this.getProfs();
        for (Utilisateur user : users)
            profString.add(user.getPrenom() + " " + user.getNom());
        return profString;
    }

    public List<String> getElevestoString() {
        List<String> eleveString = new ArrayList<>();
        List<Utilisateur> users = this.getEleves();
        for (Utilisateur user : users)
            eleveString.add(user.getPrenom() + " " + user.getNom());
        return eleveString;
    }

    public void annuler() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(
                "http://127.0.0.1:8080/rdv/annuler?id=" + data.id,
                HttpMethod.POST,
                null, Void.class);
    }
    //endregion
}
