package eu.telecomnancy.profrdv.client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class IdentificationController implements Observateur {

    ObservableList<String> jeSuisList = FXCollections.observableArrayList("Etudant.e", "Professeu.e");
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;


    @FXML
    private void initialize() {
        
    }


    public IdentificationController() {

    }


    @Override
    public void update() {

    }

}
