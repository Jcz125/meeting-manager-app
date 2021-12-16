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
    private UtilisateurData data;

    public Utilisateur(UtilisateurData utilisateurREST) {
        this.data = utilisateurREST;
    }

    public Utilisateur(String nom, String prenom, String email) {
        data = new UtilisateurData();
        data.nom = nom;
        data.prenom = prenom;
        data.email = email;
    }


    /*public void notifier(RendezVous rendezVous) {
        // fonction pour notifier l'utilisateur d'un changement d'état d'un rendez-vous auquel il participe
        if (notification) {
        }
    }*/


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
    public String getNom() {
        return data.nom;
    }


    public void setNom(String nom) {
        data.nom = nom;
    }


    public String getPrenom() {
        return data.prenom;
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


    public String getTelephone() {
        return data.telephone;
    }


    public void setTelephone(String telephone) {
        data.telephone = telephone;
    }


    public void setNotification(boolean notification) {
        data.notification = notification;
    }

    public List<RendezVous> getRDVs() {
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
        List<DisponibiliteFixe> disponibiliteFixes = new ArrayList<>();
        for(DisponibiliteFixeData dispo: data.disponibiliteFixes) {
            disponibiliteFixes.add(new DisponibiliteFixe(dispo));
        }
        return disponibiliteFixes;
    }

    public Integer getId() {
        return data.id;
    }

    //endregion
}
