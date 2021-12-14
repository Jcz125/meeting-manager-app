package eu.telecomnancy.profrdv.client;

import eu.telecomnancy.profrdv.client.controllers.MainController;
import eu.telecomnancy.profrdv.client.controllers.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane panneau = new BorderPane() ;

        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("MenuEleve.fxml"));
        loader1.setControllerFactory(iC->new MenuController());
        panneau.setTop(loader1.load());

        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("PriseRDV.fxml"));
        loader2.setControllerFactory(iC->new MainController());
        panneau.setBottom(loader2.load());

        Scene scene = new Scene(panneau, 1400, 750);
        scene.getStylesheets().add("bootstrap.min.css");
        stage.setTitle("Album Photo");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
