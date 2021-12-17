package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.EcoleData;
import eu.telecomnancy.profrdv.client.model.data.SalleData;
import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Ecole {

    private EcoleData data;

    public Ecole() {
        fetchData();
    }


    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    public void fetchData() {
        RestTemplate restTemplate = new RestTemplate();
        this.data = restTemplate.getForObject(
                "http://127.0.0.1:8080/ecole",
                EcoleData.class);
    }

    public void updateData(EcoleData data) {
        data.id = this.data.id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(
                "http://127.0.0.1:8080/ecole",
                data);
        fetchData();
    }

    public List<Utilisateur> getUtilisateurs() {
        fetchData();
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

    public List<Salle> getSalles() {
        fetchData();
        List<Salle> salles = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for (Integer i : data.salleIds) {
            SalleData response =
                    restTemplate.getForObject(
                            "http://127.0.0.1:8080/salle?id=" + i,
                            SalleData.class);
            salles.add(new Salle(response));
        }
        return salles;
    }


    public void addUtilisateur(Utilisateur utilisateur) {
        fetchData();
        Integer[] uId = new Integer[data.utilisateursIds.length + 1];
        for (int i = 0; i < data.utilisateursIds.length; i++) {
            uId[i] = data.utilisateursIds[i];
        }
        uId[data.utilisateursIds.length] = utilisateur.getId();
        EcoleData data = new EcoleData();
        data.utilisateursIds = uId;
        updateData(data);
    }

    public void addSalle(Salle salle) {
        fetchData();
        Integer[] sId = new Integer[data.salleIds.length + 1];
        for (int i = 0; i < data.salleIds.length; i++) {
            sId[i] = data.salleIds[i];
        }
        sId[data.salleIds.length] = salle.getNumero();
        EcoleData data = new EcoleData();
        data.salleIds = sId;
        updateData(data);
    }

    public String getNom() {
        fetchData();
        return data.nom;
    }

    public void setNom(String nom) {
        EcoleData data = new EcoleData();
        data.nom = nom;
        updateData(data);
    }
}
