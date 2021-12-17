package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.ProfRDV;
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


    private ProfRDV profRDV;


    public EspacePersoController(ProfRDV profRDV) {
        this.profRDV = profRDV;
    }


    @FXML
    public void handleConfirmButton() {
        profRDV.getConnectedUtilisateur().setNom(this.nom.getText());
        profRDV.getConnectedUtilisateur().setPrenom(this.prenom.getText());
        profRDV.getConnectedUtilisateur().setEmail(this.email.getText());
        profRDV.getConnectedUtilisateur().setTelephone((this.telephone.getText()));
        JOptionPane.showMessageDialog(null, "Modifié avec succés", "InfoBox: " + "Modification", JOptionPane.INFORMATION_MESSAGE);
    }


    @FXML
    public void initialize() {
        this.nom.setText(profRDV.getConnectedUtilisateur().getNom());
        this.prenom.setText(profRDV.getConnectedUtilisateur().getPrenom());
        this.email.setText(profRDV.getConnectedUtilisateur().getEmail());
        this.telephone.setText(profRDV.getConnectedUtilisateur().getTelephone());
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


//    public void setProfRDV(ProfRDV profRDV) {
//        this.profRDV = profRDV;
//    }
}
