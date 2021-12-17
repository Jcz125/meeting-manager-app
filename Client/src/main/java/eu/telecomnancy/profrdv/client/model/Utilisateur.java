package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.*;
import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import eu.telecomnancy.profrdv.client.model.disponibilite.ModificateurDisponibilite;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Utilisateur {
    protected UtilisateurData data;

    public Utilisateur(UtilisateurData utilisateurREST) {
        this.data = utilisateurREST;
    }

    public Utilisateur(String nom, String prenom, String email) {
        data = new UtilisateurData();
        data.nom = nom;
        data.prenom = prenom;
        data.email = email;
        data.estProf = this instanceof Professeur;
        HttpEntity<UtilisateurData> dataRequest = new HttpEntity<>(data);
        RestTemplate restTemplate = new RestTemplate();
        data.id = restTemplate.exchange(
                "http://127.0.0.1:8080/utilisateur",
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
                        "http://127.0.0.1:8080/utilisateur?id=" + data.id,
                        UtilisateurData.class);
    }

    public void updateData(UtilisateurData data) {
        data.id = this.data.id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(
                "http://127.0.0.1:8080/utilisateur?id=" + data.id,
                data);
        fetchData();
    }

    public void delete() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(
                "http://127.0.0.1:8080/utilisateur?id=" + data.id);
        data = null;
    }

    public boolean prendreRDV(List<Utilisateur> utilisateurs, LocalDateTime horaire, String titre, String description, Salle salle) {
        RendezVousData data = new RendezVousData();
        data.horaire = horaire;
        data.titre = titre;
        data.description = description;
        data.salle = salle.getData();
        Map<Integer, Boolean> utilisateursIdsConfirmed = new HashMap<>();
        for (Utilisateur u: utilisateurs) {
            utilisateursIdsConfirmed.put(u.getId(), false);
        }
        data.utilisateursIdsConfirmed = utilisateursIdsConfirmed;
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<RendezVousData> requestUpdate = new HttpEntity<>(data);
        ResponseEntity<BooleanResult> response =
                    restTemplate.exchange(
                            "http://127.0.0.1:8080/utilisateur/prendreRDV?id=" + data.id,
                            HttpMethod.POST,
                            requestUpdate, BooleanResult.class);
        return response.getBody().success;
    }

    public void confirmerRDV(RendezVous rdv) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(
                "http://127.0.0.1:8080//rdv/confirme?userid=" + data.id + "&rdvid=" + rdv.getId(),
                null, Void.class);
        fetchData();
    }

    //region assesseurs
    public List<RendezVous> getRDVs() {
        fetchData();
        List<RendezVous> rendezVous = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for (Integer id: data.RDVsIds) {
            RendezVousData response =
                    restTemplate.getForObject(
                            "http://127.0.0.1:8080/rdv?id=" + id,
                            RendezVousData.class);
            rendezVous.add(new RendezVous(response));
        }
        return rendezVous;
    }

    public List<DisponibiliteFixe> getDisponibiliteFixe() {
        fetchData();
        List<DisponibiliteFixe> disponibiliteFixes = new ArrayList<>();
        for(DisponibiliteFixeData dispo: data.disponibiliteFixes) {
            disponibiliteFixes.add(new DisponibiliteFixe(dispo));
        }
        return disponibiliteFixes;
    }

    public List<ModificateurDisponibilite> getModificateurDisponibilite() {
        fetchData();
        List<ModificateurDisponibilite> disponibiliteExcept = new ArrayList<>();
        for(ModificateurDisponibiliteData dispo : data.modificateurDisponibilites) {
            disponibiliteExcept.add(new ModificateurDisponibilite(dispo));
        }
        return disponibiliteExcept;
    }

    public Integer getId() {
        return data.id;
    }

    public String getNom() {
        fetchData();
        return data.nom;
    }

    public String getPrenom() {
        fetchData();
        return data.prenom;
    }

    public String getTelephone() {
        fetchData();
        return data.telephone;
    }

    public String getEmail() {
        fetchData();
        return data.email;
    }

    public void setNom(String nom) {
        UtilisateurData data = new UtilisateurData();
        data.nom = nom;
        updateData(data);
    }

    public void setPrenom(String prenom) {
        UtilisateurData data = new UtilisateurData();
        data.prenom = prenom;
        updateData(data);
    }

    public void setEmail(String email) {
        UtilisateurData data = new UtilisateurData();
        data.email = email;
        updateData(data);
    }

    public void setTelephone(String telephone) {
        UtilisateurData data = new UtilisateurData();
        data.telephone = telephone;
        updateData(data);
    }

    public void setNotification(boolean notification) {
        UtilisateurData data = new UtilisateurData();
        data.notification = notification;
        updateData(data);
    }

    //endregion
}
