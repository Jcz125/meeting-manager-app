package eu.telecomnancy.profrdv.client;

import eu.telecomnancy.profrdv.client.controllers.CreationController;
import eu.telecomnancy.profrdv.client.controllers.EspacePerso;
import eu.telecomnancy.profrdv.client.controllers.MenuController;
import eu.telecomnancy.profrdv.client.controllers.PriseRDVController;
import eu.telecomnancy.profrdv.client.model.Ecole;
import eu.telecomnancy.profrdv.client.model.Professeur;
import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
            System.out.println("L'utilisateur : " + u.getNom() + " " + u.getPrenom() + (u instanceof Professeur ? " est Prof" : " est Eleve"));
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

        BorderPane panneau = new BorderPane();

        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("MenuEleve.fxml"));
        menuLoader.setControllerFactory(iC -> new MenuController());
        panneau.setTop(menuLoader.load());


        FXMLLoader priseRDVLoader = new FXMLLoader(getClass().getResource("PriseRDV.fxml"));
        priseRDVLoader.setControllerFactory(iC -> new PriseRDVController(utilisateurs.get(0)));
        Parent priseRDVParent = priseRDVLoader.load();


        FXMLLoader creationLoader = new FXMLLoader(getClass().getResource("Creation.fxml"));
        creationLoader.setControllerFactory(iC -> new CreationController());
        Parent creationParent = creationLoader.load();


        FXMLLoader espacePersoLoader = new FXMLLoader(getClass().getResource("EspacePerso.fxml"));
        espacePersoLoader.setControllerFactory(iC -> new EspacePerso());
        Parent espacePersoParent = espacePersoLoader.load();


        MenuController menuController = menuLoader.getController();

        menuController.setPlanningNode(priseRDVParent);
        menuController.setCreationNode(creationParent);
        menuController.setEspacePersoNode(espacePersoParent);

        menuController.setPanneau(panneau);

        panneau.setBottom(priseRDVParent);


//        creationLoader.setControllerFactory(iC -> new MenuController());

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
