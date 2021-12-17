package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;

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

    private Utilisateur u;

    public EspacePersoController(Utilisateur u) {
        this.u = u;
    }

    @FXML
    public void handleConfirmButton() {
        u.setNom(this.nom.getText());
        u.setPrenom(this.prenom.getText());
        u.setEmail(this.email.getText());
        u.setTelephone((this.telephone.getText()));
        JOptionPane.showMessageDialog(null, "Modifié avec succés", "InfoBox: " + "Modification", JOptionPane.INFORMATION_MESSAGE);
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
