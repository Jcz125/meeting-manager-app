package eu.telecomnancy.profrdv.client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.time.temporal.Temporal;

public class CreationController implements Observateur{

    ObservableList<String> jeSuisList = FXCollections.observableArrayList("Etudant.e", "Professeu.e");
    @FXML private ChoiceBox jeSuis;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField email;
    @FXML private TextField telephone;
    @FXML private TextField id;

    @FXML
    private void initialize(){
        jeSuis.setValue("Etudiant.e") ;
        jeSuis.setItems(jeSuisList) ;
    }

    public CreationController(){

    }

    @Override
    public void update() {

    }

}
