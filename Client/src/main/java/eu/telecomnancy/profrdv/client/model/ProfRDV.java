package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.controllers.Observateur;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ProfRDV {
    private Stage stage ;
    private Ecole ecole;
    private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
    private Utilisateur connectedUtilisateur;


    public ProfRDV(Stage stage) {
        this.ecole = new Ecole();
        this.stage = stage;
    }


    public void ajouterObservateur(Observateur ob) {
        listObservateur.add(ob);
    }


    public void notifierObservateur() {
        for (Observateur o : this.listObservateur) o.update();
    }


    public static void notificationProfilIncomplet() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Profil incomplet");
        alert.setContentText("Les données que vous avez entré pour la création du profil ne sont pas complètes.");
        alert.showAndWait();
    }


    public void ajouterUtilisateur(Utilisateur utilisateur) {
        this.ecole.addUtilisateur(utilisateur);
    }


    public void setConnectedUtilisateur(Utilisateur connectedUtilisateur) {
        this.connectedUtilisateur = connectedUtilisateur;
    }


    public Utilisateur getConnectedUtilisateur() {
        return connectedUtilisateur;
    }
}
