package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.skin.LabeledSkinBase;

import java.util.List;

public class RDVInfoCellController implements Observateur {

    private Utilisateur user;
    @FXML
    private Label titreRDV;
    @FXML
    private Label etatRDV;
    @FXML
    private Label descriptionRDV;
    @FXML
    private Label dateRDV;
    @FXML
    private Label heureRDV;
    @FXML
    private Label lieuRDV;
    @FXML
    private Button b_confirmer;
    @FXML
    private Button b_modifier;
    @FXML
    private Button b_annuler;
    @FXML
    private List<Label> listProf;
    @FXML
    private List<Label> listEleve;

    public void RDVInfoCellController() {

    }

    public void initialize() {

    }

    public void setInfo(RendezVous rdv) {
        this.titreRDV.setText(rdv.getTitre());
        this.etatRDV.setText("");
        this.descriptionRDV.setText(rdv.getDescription());
        this.dateRDV.setText("" + rdv.getHoraire().getDayOfMonth() + "/" + rdv.getHoraire().getMonthValue() + "/" + rdv.getHoraire().getYear());

    }

    public void update() {

    }
}
