package eu.telecomnancy.profrdv.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.swing.*;
import java.awt.*;

public class MenuController implements Observateur{

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
    private void handleCreateButton (ActionEvent actionEvent) {

    }


    @Override
    public void update() {

    }
}
