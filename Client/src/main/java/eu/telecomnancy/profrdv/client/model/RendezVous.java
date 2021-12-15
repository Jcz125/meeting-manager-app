package eu.telecomnancy.profrdv.client.model;


import eu.telecomnancy.profrdv.client.model.data.EtatRendezVousData;
import eu.telecomnancy.profrdv.client.model.data.RendezVousData;
import eu.telecomnancy.profrdv.client.model.data.SalleData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> getProfstoString() {
        List<String> profs = new ArrayList<>();
        return profs;
    }

    public List<String> getElevestoString() {
        List<String> eleves = new ArrayList<>();
        return eleves;
    }
    //endregion
}
