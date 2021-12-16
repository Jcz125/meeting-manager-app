package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.skin.LabeledSkinBase;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class RDVInfoCellController implements Observateur {

    private RendezVous rdv;
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
    private VBox listProf;
    @FXML
    private VBox listEleve;


    public RDVInfoCellController() {

    }

    public void initialize() {

    }

    public void setInfo(RendezVous rdv) {
        this.rdv = rdv;
        this.titreRDV.setText(rdv.getTitre());
        this.etatRDV.setText(rdv.getEtatRendezVoustoString()); // implementer la methode pour recuperer le string de l'etat du rdv
        this.descriptionRDV.setText(rdv.getDescription());
        this.dateRDV.setText("" + rdv.getHoraire().getDayOfMonth() + "/" + rdv.getHoraire().getMonthValue() + "/" + rdv.getHoraire().getYear());
        this.heureRDV.setText("" + rdv.getHoraire().getHour() + ":" + rdv.getHoraire().getMinute());
        this.lieuRDV.setText("" + rdv.getSalle().getEtage() + " " + rdv.getSalle().getAile() + " " + rdv.getSalle().getNumero());
        List<String> profs = rdv.getProfstoString();
        List<String> eleves = rdv.getElevestoString();

        for (String str : profs) {
            listProf.getChildren().add(new Label(str));
        }
        for (String str : eleves) {
            listEleve.getChildren().add(new Label(str));
        }
    }

    public void modifier() {
        // faire pop une fenetre sur l'interface avec plusieurs champs à modifier
    }

    public void annuler() {
        rdv.annuler();
    }

    public void update() {
        this.titreRDV.setText(rdv.getTitre());
        this.etatRDV.setText(rdv.getEtatRendezVoustoString()); // implementer la methode pour recuperer le string de l'etat du rdv
        this.descriptionRDV.setText(rdv.getDescription());
        this.dateRDV.setText("" + rdv.getHoraire().getDayOfMonth() + "/" + rdv.getHoraire().getMonthValue() + "/" + rdv.getHoraire().getYear());
        this.heureRDV.setText("" + rdv.getHoraire().getHour() + ":" + rdv.getHoraire().getMinute());
        this.lieuRDV.setText("" + rdv.getSalle().getEtage() + " " + rdv.getSalle().getAile() + " " + rdv.getSalle().getNumero());
        List<String> profs = rdv.getProfstoString();
        List<String> eleves = rdv.getElevestoString();
        this.listProf.getChildren().removeAll();
        this.listEleve.getChildren().removeAll();
        // ajouter à la base de données
        for (String str : profs) {
            listProf.getChildren().add(new Label(str));
        }
        for (String str : eleves) {
            listEleve.getChildren().add(new Label(str));
        }
    }
}
