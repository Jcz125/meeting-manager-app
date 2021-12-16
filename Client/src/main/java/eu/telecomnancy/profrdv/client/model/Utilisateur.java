package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.BooleanResult;
import eu.telecomnancy.profrdv.client.model.data.DisponibiliteFixeData;
import eu.telecomnancy.profrdv.client.model.data.RendezVousData;
import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;
import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        restTemplate.exchange(
                "http://127.0.0.1:8080/utilisateur",
                HttpMethod.POST,
                dataRequest,
                Void.class
        );
    }

    public void updateData() {
        RestTemplate restTemplate = new RestTemplate();
        this.data =
                restTemplate.getForObject(
                        "http://127.0.0.1:8080/utilisateur?id=" + data.id,
                        UtilisateurData.class);
    }

    /*public void ajouterRDV(RendezVous rendezVous) {
        if (!this.RDVs.containsKey(rendezVous.getHoraire())) {
            this.RDVs.put(rendezVous.getHoraire(), rendezVous);
        }
    }*/


    /*public boolean annulerRDV(RendezVous rendezVous) {
        if (this.RDVs.containsKey(rendezVous.getHoraire())) {
            rendezVous.annuler();
            return true;
        }
        return false;
    }*/


    //public abstract boolean estDisponible(RendezVous rendezVous);


    public boolean prendreRDV(List<Utilisateur> utilisateurs, LocalDateTime date, String titre, String description, Salle salle) {
        RendezVousData data = new RendezVousData();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<RendezVousData> requestUpdate = new HttpEntity<>(data);
        ResponseEntity<BooleanResult> response =
                    restTemplate.exchange(
                            "http://127.0.0.1:8080/utilisateur/prendreRDV",
                            HttpMethod.POST,
                            requestUpdate, BooleanResult.class);
        return response.getBody().success;
    }


    //region assesseurs
    public List<RendezVous> getRDVs() {
        updateData();
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
        updateData();
        List<DisponibiliteFixe> disponibiliteFixes = new ArrayList<>();
        for(DisponibiliteFixeData dispo: data.disponibiliteFixes) {
            disponibiliteFixes.add(new DisponibiliteFixe(dispo));
        }
        return disponibiliteFixes;
    }

    public Integer getId() {
        return data.id;
    }

    public String getNom() {
        updateData();
        return data.nom;
    }

    public String getPrenom() {
        updateData();
        return data.prenom;
    }

    public String getTelephone() {
        updateData();
        return data.telephone;
    }

    public void setNom(String nom) {
        data.nom = nom;
    }

    public void setPrenom(String prenom) {
        data.prenom = prenom;
    }

    public String getEmail() {
        return data.email;
    }

    public void setEmail(String email) {
        data.email = email;
    }


    public void setTelephone(String telephone) {
        data.telephone = telephone;
    }

    public void setNotification(boolean notification) {
        data.notification = notification;
    }

    //endregion
}
