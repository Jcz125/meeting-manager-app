package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.EcoleData;
import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Ecole {

    private EcoleData data;


    public Ecole() {
        RestTemplate restTemplate = new RestTemplate();
        this.data = restTemplate.getForObject(
                "http://127.0.0.1:8080/ecole", EcoleData.class);
    }


    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    public String getNom() {
        return data.nom;
    }


    public void setNom(String nom) {
        data.nom = nom;
    }


    public List<Utilisateur> getUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for (Integer i : data.utilisateursIds) {
            UtilisateurData response =
                    restTemplate.getForObject(
                            "http://127.0.0.1:8080/utilisateur?id=" + i,
                            UtilisateurData.class);
            if (response.estProf)
                utilisateurs.add(new Professeur(response));
            else
                utilisateurs.add(new Eleve(response));
        }
        return utilisateurs;
    }


    public void addUtilisateur(Utilisateur utilisateur) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(
                "http://127.0.0.1:8080/utilisateur?ecoleId=" + data.id + "&userId=" + utilisateur.getId(),
                HttpMethod.POST,
                null,
                Void.class
        );
    }

    public void addSalle(Salle salle) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(
                "http://127.0.0.1:8080/utilisateur?ecoleId=" + data.id + "&salleId=" + salle.getNumero(),
                HttpMethod.POST,
                null,
                Void.class
        );
    }

}
