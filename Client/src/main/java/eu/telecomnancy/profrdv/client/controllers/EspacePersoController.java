package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EspacePersoController implements Observateur {
    @FXML
    private AnchorPane centerPane;
    @FXML
    private AnchorPane rightPane;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField telephone;

    private Utilisateur u ;


    public EspacePersoController(Utilisateur u) {
        this.u = u ;
    }


    public void handleConfirmButton() {

    }

    @FXML
    public void initialize() {
        this.nom.setText(u.getNom());
        this.prenom.setText(u.getPrenom());
        this.email.setText(u.getEmail());
        this.telephone.setText(u.getTelephone());
    }

    @Override
    public void update() {

    }


    public void setCenter(AnchorPane center) {
        this.centerPane.getChildren().add(center);
    }


    public void setLeft(AnchorPane left) {
        this.rightPane.getChildren().add(left);
        left.setMaxHeight(300);
    }
}
