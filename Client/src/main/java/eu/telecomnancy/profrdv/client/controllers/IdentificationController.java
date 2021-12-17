package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.ProfRDV;
import eu.telecomnancy.profrdv.client.model.Professeur;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class IdentificationController implements Observateur {

    private ProfRDV profRDV;

    ObservableList<String> jeSuisList = FXCollections.observableArrayList("Etudant.e", "Professeu.e");
    private List<Utilisateur> utilis = new ArrayList<Utilisateur>();
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;

    private MenuController menuController;


    @FXML
    private void initialize() {

    }


    public IdentificationController(List<Utilisateur> u) {
        this.utilis = u;
    }


    public void handleConfirmer() {
        String mail = this.email.getText();
        for (Utilisateur u : utilis) {
            if ((u.getEmail().equals(mail))){
                if (u instanceof Professeur) {
                    this.menuController.chargerProfMenu();
                    this.profRDV.setConnectedUtilisateur(u);
                    break;
                } else {
                    this.menuController.chargerEleveMenu();
                    this.profRDV.setConnectedUtilisateur(u);
                    break;
                }
            }
        }
    }


    @Override
    public void update() {

    }


    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }


    public void setProfRDV(ProfRDV profRDV) {
        this.profRDV = profRDV;
    }
}
