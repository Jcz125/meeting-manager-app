package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;

public class Professeur extends Utilisateur {

    public Professeur(UtilisateurData response) {
        super(response);
    }


    public Professeur(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }
}
