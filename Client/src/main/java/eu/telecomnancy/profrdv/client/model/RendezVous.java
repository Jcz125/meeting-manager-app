package eu.telecomnancy.profrdv.client.model;


import eu.telecomnancy.profrdv.client.model.data.EtatRendezVousData;
import eu.telecomnancy.profrdv.client.model.data.RendezVousData;
import eu.telecomnancy.profrdv.client.model.data.SalleData;
import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RendezVous {
    private RendezVousData rendezVousREST;

    public RendezVous(RendezVousData rendezVousREST) {
        this.rendezVousREST = rendezVousREST;
    }

    /*public RendezVous(LocalDateTime horaire, ArrayList<Utilisateur> utilisateurs, String titre, String description) {
        this.rendezVousREST = new RendezVousREST(horaire, utilisateurs, titre, description)
    }*/

    /*public void ajoutConfirmation(Utilisateur CurrentUtilisateur) {
        utilisateurs.put(CurrentUtilisateur, true);
    }*/


    //region état rendez-vous
    public void annuler() {

    }


    public void confirmer() {

    }


    public void demande() {

    }


    public void realiser() {

    }
    //endregion




    //region assesseurs
    public EtatRendezVousData getEtatRendezVous() {
        return rendezVousREST.etatRendezVous;
    }

    public String getEtatRendezVoustoString() { // utiliser instanceof
        return "";
    }


    public LocalDateTime getHoraire() {
        return rendezVousREST.horaire;
    }


    public String getDescription() {
        return rendezVousREST.description;
    }


    public String getTitre() {
        return rendezVousREST.titre;
    }


    public void setTitre(String titre) {
        rendezVousREST.titre = titre;
    }


    public void setDescription(String description) {
        rendezVousREST.description = description;
    }

    public void setEtatRendezVous(EtatRendezVousData etatRendezVous) {
        rendezVousREST.etatRendezVous = etatRendezVous;
    }

    public void setHoraire(LocalDateTime horaire) {
        rendezVousREST.horaire = horaire;
    }

    public SalleData getSalle() {return this.rendezVousREST.salle;}

    public void setSalle(SalleData salle) {
        rendezVousREST.salle = salle;
    }

    /*public void setUtilisateurs(HashMap<UtilisateurREST, Boolean> utilisateurs) {
        rendezVousREST.utilisateurs = utilisateurs;
    }

    public SalleREST getSalle() {
        return salle;
    }
    public void setState(EtatRendezVousREST etatRendezVous) {
        this.etatRendezVous = etatRendezVous;
    }*/

    public List<Utilisateur> getUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for (Map.Entry<Integer, Boolean> entry : this.rendezVousREST.utilisateursIdsConfirmed.entrySet()) {
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
        for (Map.Entry<Integer, Boolean> entry : this.rendezVousREST.utilisateursIdsConfirmed.entrySet()) {
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
        for (Map.Entry<Integer, Boolean> entry : this.rendezVousREST.utilisateursIdsConfirmed.entrySet()) {
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
    //endregion
}
