package eu.telecomnancy.profrdv.client;

import eu.telecomnancy.profrdv.client.controllers.MenuController;
import eu.telecomnancy.profrdv.client.model.*;
import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Main extends Application {
    private MenuController mc;


    @Override
    public void start(Stage stage) throws IOException {
        Ecole ecole = new Ecole();
        List<Utilisateur> utilisateurs = ecole.getUtilisateurs();
        for (Utilisateur u : utilisateurs) {
            System.out.println("L'utilisateur : " + u.getNom() + " " + u.getPrenom() + " " + u.getEmail());
            if (u instanceof Professeur) {
                System.out.println("est un prof avec comme dispo fixe : ");
                for (DisponibiliteFixe d : u.getDisponibiliteFixe()) {
                    System.out.println("Le " + d.getJour() + " de " + d.getDebut() + " à " + d.getFin());
                }
            } else
                System.out.println("est un élève");
            System.out.println("Et a comme RDV :");
            for (RendezVous rdv : u.getRDVs()) {
                System.out.println("\"" + rdv.getTitre() + "\"" + "  " + rdv.getHoraire());
            }
        }

//        Utilisateur u = new Eleve("a", "a", "aaa");
//        u.setTelephone("3660");

        ProfRDV profRDV = new ProfRDV(stage);

        BorderPane panneau = new BorderPane();

        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("MenuProf.fxml"));
        menuLoader.setControllerFactory(iC -> new MenuController());
        panneau.setTop(menuLoader.load());
        MenuController menuController = menuLoader.getController();
        menuController.init(utilisateurs, ecole);
        menuController.setPanneau(panneau);
        menuController.setProfRDV(profRDV);


        panneau.setCenter(menuController.getIdentification());


        Scene scene = new Scene(panneau, 1400, 750);
        stage.setTitle("ProfRDV");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
