package eu.telecomnancy.profrdv.client.model;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ProfRDV {
    private Stage stage;
    private Ecole ecole;


    public ProfRDV(Stage stage) {
        this.ecole = new Ecole();
        this.stage = stage;
    }


    public static void notificationProfilIncomplet() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Profil incomplet");
        alert.setContentText("Les données que vous avez entré pour la création du profil ne sont pas complètes.");
        alert.showAndWait();
    }


    public void ajouterUtilisateur(Utilisateur utilisateur) {
        this.ecole.ajouterUtilisateur(utilisateur);
    }
}
