package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Eleve;
import eu.telecomnancy.profrdv.client.model.ProfRDV;
import eu.telecomnancy.profrdv.client.model.Professeur;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.Objects;

public class CreationController implements Observateur {

    ObservableList<String> jeSuisList = FXCollections.observableArrayList("Etudiant.e", "Professeur.e");
    @FXML
    private ChoiceBox jeSuis;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField telephone;

    private ProfRDV profRDV;


    @FXML
    private void initialize() {
        jeSuis.setValue("Etudiant.e");
        jeSuis.setItems(jeSuisList);
    }


    public CreationController() {

    }


    @Override
    public void update() {

    }


    public void confirmer() {
        String nomText = nom.getText();
        String prenomText = prenom.getText();
        String emailText = email.getText();
        String telephoneText = telephone.getText();

        if (Objects.equals(nomText, "")) {
            ProfRDV.notificationProfilIncomplet();
            return;
        }

        if (Objects.equals(prenomText, "")) {
            ProfRDV.notificationProfilIncomplet();
            return;
        }

        if (Objects.equals(emailText, "")) {
            ProfRDV.notificationProfilIncomplet();
            return;
        }

        if (Objects.equals(telephoneText, "")) {
            ProfRDV.notificationProfilIncomplet();
            return;
        }

        Utilisateur utilisateur;
        if (jeSuis.getSelectionModel().getSelectedItem() == "Etudiant.e") {
            utilisateur = new Eleve(nomText, prenomText, emailText);
            utilisateur.setTelephone(telephoneText);
        } else {
            utilisateur = new Professeur(nomText, prenomText, emailText);
            utilisateur.setTelephone(telephoneText);
        }

        profRDV.ajouterUtilisateur(utilisateur);
    }


    public void setProfRDV(ProfRDV profRDV) {
        this.profRDV = profRDV;
    }
}
