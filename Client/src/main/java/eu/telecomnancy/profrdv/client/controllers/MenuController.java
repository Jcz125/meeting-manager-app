package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MenuController implements Observateur {

    private MenuController mc;
    private Utilisateur utilisateur;
    private String idToConnect;

    private BorderPane panneau;
    private Parent creation;
    private Parent planning;
    private Parent espacePerso;
    private Parent identification;
    private Parent accueil;


    public MenuController() {

    }


    @FXML
    private void handleAccueilButton(ActionEvent actionEvent) {
        panneau.setCenter(accueil);
    }


    @FXML
    private void handlePersonalButton(ActionEvent actionEvent) {
        panneau.setCenter(espacePerso);
    }


    @FXML
    private void handlePlanningButton(ActionEvent actionEvent) {
        panneau.setCenter(planning);
    }


    @FXML
    private void handleIdButton(ActionEvent actionEvent) {
//        String id = (String) JOptionPane.showInputDialog(new Component() {
//                                                         },
//                "Identifiant",
//                "Identifiez-Vous",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                null,
//                null);
//
//        if (id != null) {
//            this.idToConnect = id;
//        }
        panneau.setCenter(identification);
    }


    public String getIdToConnect() {
        return this.idToConnect;
    }


    @FXML
    private void handleCreateButton(ActionEvent actionEvent) throws IOException {
        panneau.setCenter(creation);
    }


    public void setCreationNode(Parent parent) {
        this.creation = parent;
    }


    public void setPlanningNode(Parent parent) {
        this.planning = parent;
    }


    public void setEspacePersoNode(Parent parent) {
        this.espacePerso = parent;
    }


    public void setIdentificationNode(Parent parent) {
        this.identification = parent;
    }


    public void setPriseRDV(Parent parent) {
        this.accueil = parent;
    }


    @Override
    public void update() {

    }


    public void setPanneau(BorderPane panneau) {
        this.panneau = panneau;
    }
}
