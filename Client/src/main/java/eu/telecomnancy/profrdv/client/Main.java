package eu.telecomnancy.profrdv.client;

import eu.telecomnancy.profrdv.client.controllers.MainController;
import eu.telecomnancy.profrdv.client.controllers.MenuController;
import eu.telecomnancy.profrdv.client.controllers.PlanningController;
import eu.telecomnancy.profrdv.client.controllers.PriseRDVController;
import eu.telecomnancy.profrdv.client.model.Ecole;
import eu.telecomnancy.profrdv.client.model.Professeur;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.application.Application;
import javafx.fxml.FXML;
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
        for (Utilisateur u: utilisateurs) {
            System.out.println(u.getNom() +  " " + u.getPrenom());
//            if (mc.getIdToConnect().equals(u.getId())){
//                if (u instanceof Professeur){                           // identifiant donnée est un id d'un professeur
//
//                }
//                else {                                                  // identifiant donnée est un id d'un eleve
//
//                }
//
//            }
        }

        BorderPane panneau = new BorderPane() ;

        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("MenuEleve.fxml"));
        loader1.setControllerFactory(iC->new MenuController());
        panneau.setTop(loader1.load());

        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("PriseRDV.fxml"));
        loader2.setControllerFactory(iC->new PriseRDVController());
        panneau.setBottom(loader2.load());

//        FXMLLoader loader3 = new FXMLLoader();
//        loader3.setLocation(getClass().getResource("Planning.fxml"));
//        loader3.setControllerFactory(iC->new PlanningController());
//        panneau.setCenter(loader3.load());

        Scene scene = new Scene(panneau, 1400, 750);
        stage.setTitle("ProfRDV");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
