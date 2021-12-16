package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.EcoleData;
import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Ecole {

    private EcoleData ecoleREST;


    public Ecole() {
        RestTemplate restTemplate = new RestTemplate();
        this.ecoleREST = restTemplate.getForObject(
                "http://127.0.0.1:8080/ecole", EcoleData.class);
    }


    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    public String getNom() {
        return ecoleREST.nom;
    }


    public void setNom(String nom) {
        ecoleREST.nom = nom;
    }


    public List<Utilisateur> getUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for (Integer i : ecoleREST.utilisateursIds) {
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


    public void ajouterUtilisateur(Utilisateur utilisateur) {

    }
}
