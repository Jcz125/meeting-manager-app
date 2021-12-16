package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;

public class Eleve extends Utilisateur {
    public Eleve(UtilisateurData response) {
        super(response);
    }


    public Eleve(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }
}
