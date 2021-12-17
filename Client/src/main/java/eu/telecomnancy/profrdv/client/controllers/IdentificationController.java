package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Professeur;
import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class IdentificationController implements Observateur {

    ObservableList<String> jeSuisList = FXCollections.observableArrayList("Etudant.e", "Professeu.e");
    private List<Utilisateur> utilis = new ArrayList<Utilisateur>();
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;


    @FXML
    private void initialize() {
        
    }


    public IdentificationController(List<Utilisateur> u) {
        this.utilis = u ;
    }

    public void handleConfirmer() {
        String mail = this.email.getText();
        for (Utilisateur u : utilis) {
            if (u.getEmail().equals(email)){
                if (u instanceof Professeur) {

                } else {

                }
            }
        }
    }

    @Override
    public void update() {

    }

}
