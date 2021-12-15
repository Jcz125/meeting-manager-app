package eu.telecomnancy.profrdv.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuController implements Observateur{
    MenuController mc;

    public MenuController(){

    }

    @FXML
    private void handleAccueilButton (ActionEvent actionEvent) {

    }

    @FXML
    private void handlePersonalButton (ActionEvent actionEvent) {

    }

    @FXML
    private void handlePlanningButton (ActionEvent actionEvent) {

    }

    @FXML
    private void handleIdButton (ActionEvent actionEvent) {
        String id = (String) JOptionPane.showInputDialog(new Component(){},
                "Identifiant",
                "Identifiez-Vous",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        if (id != null) {
        }
    }

    @FXML
    private void handleCreateButton (ActionEvent actionEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("Creation.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//        Stage stage = new Stage();
//        stage.setTitle("Creation de compte");
//        stage.setScene(scene);
//        stage.show();
    }

    @Override
    public void update() {

    }
}
