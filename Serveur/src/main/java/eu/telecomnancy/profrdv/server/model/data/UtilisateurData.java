package eu.telecomnancy.profrdv.server.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UtilisateurData {
    public int id;
    public String nom;
    public String prenom;
    public String email;
    public String telephone;
    public boolean notification;
    public boolean estProf;
    public Integer[] RDVsIds;

    public UtilisateurData() {

    }

    public UtilisateurData(int id, String nom, String prenom, String email, String telephone, boolean notification, Integer[] RDVsIds, boolean estProf) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.notification = notification;
        this.RDVsIds = RDVsIds;
        this.estProf = estProf;
    }
}
