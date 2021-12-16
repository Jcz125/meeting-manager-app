package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.skin.LabeledSkinBase;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RDVInfoCellController extends ListCell<RendezVous> implements Observateur {

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
    @FXML
    private AnchorPane anchorPaneRDVInfoCell;

    private FXMLLoader fxmlLoader;


    public RDVInfoCellController() {
        this.rdv = rdv;
//        this.titreRDV.setText(rdv.getTitre());
//        this.etatRDV.setText(rdv.getEtatRendezVoustoString()); // implementer la methode pour recuperer le string de l'etat du rdv
//        this.descriptionRDV.setText(rdv.getDescription());
//        this.dateRDV.setText("" + rdv.getHoraire().getDayOfMonth() + "/" + rdv.getHoraire().getMonthValue() + "/" + rdv.getHoraire().getYear());
//        this.heureRDV.setText("" + rdv.getHoraire().getHour() + ":" + rdv.getHoraire().getMinute());
//        this.lieuRDV.setText("" + rdv.getSalle().etage + " " + rdv.getSalle().aile + " " + rdv.getSalle().numero);
//        List<String> profs = rdv.getProfstoString();
//        List<String> eleves = rdv.getElevestoString();
//
//        for (String str : profs) {
//            listProf.getChildren().add(new Label(str));
//        }
//        for (String str : eleves) {
//            listEleve.getChildren().add(new Label(str));
//        }

//        this.titreRDV = new Label("Sans nom");
//        this.etatRDV = new Label("Sans état");
//        this.descriptionRDV = new Label("Pas de description.");
//        this.dateRDV = new Label("JJ/MM/AAAA");
//        this.heureRDV = new Label("HH:mm");
//        this.lieuRDV = new Label("Pas de lieu.");
//
//        this.listProf = new VBox();
//        this.listEleve = new VBox();
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
        this.lieuRDV.setText("" + rdv.getSalle().etage + " " + rdv.getSalle().aile + " " + rdv.getSalle().numero);
        List<String> profs = rdv.getProfstoString();
        List<String> eleves = rdv.getElevestoString();

        for (String str : profs) {
            listProf.getChildren().add(new Label(str));
        }
        for (String str : eleves) {
            listEleve.getChildren().add(new Label(str));
        }
    }

    public void confirmer() {
        rdv.confirmer();
    }

    public void modifier() {
        // faire pop une fenetre sur l'interface avec plusieurs champs à modifier
    }

    public void annuler() {
        rdv.annuler();
    }

    protected void updateItem(RendezVous rdv, boolean empty) {
        super.updateItem(rdv, empty);
        if (empty || rdv == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass().getResource("ListRDVInfoCell.fxml"));
                fxmlLoader.setController(this);
            }
            try {
                fxmlLoader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        this.rdv = rdv;
        this.titreRDV.setText(rdv.getTitre());
        this.etatRDV.setText(rdv.getEtatRendezVoustoString());
        this.descriptionRDV.setText(rdv.getDescription());
        this.dateRDV.setText("" + rdv.getHoraire().getDayOfMonth() + "/" + rdv.getHoraire().getMonthValue() + "/" + rdv.getHoraire().getYear());
        this.heureRDV.setText("" + rdv.getHoraire().getHour() + ":" + rdv.getHoraire().getMinute());
        this.lieuRDV.setText("" + rdv.getSalle().etage + " " + rdv.getSalle().aile + " " + rdv.getSalle().numero);
        List<String> profs = rdv.getProfstoString();
        List<String> eleves = rdv.getElevestoString();

        for (String str : profs) {
            listProf.getChildren().add(new Label(str));
        }
        for (String str : eleves) {
            listEleve.getChildren().add(new Label(str));
        }

        setText(null);
        setGraphic(anchorPaneRDVInfoCell);
    }

    public void update() {
//        this.titreRDV.setText(rdv.getTitre());
//        this.etatRDV.setText(rdv.getEtatRendezVoustoString()); // implementer la methode pour recuperer le string de l'etat du rdv
//        this.descriptionRDV.setText(rdv.getDescription());
//        this.dateRDV.setText("" + rdv.getHoraire().getDayOfMonth() + "/" + rdv.getHoraire().getMonthValue() + "/" + rdv.getHoraire().getYear());
//        this.heureRDV.setText("" + rdv.getHoraire().getHour() + ":" + rdv.getHoraire().getMinute());
//        this.lieuRDV.setText("" + rdv.getSalle().etage + " " + rdv.getSalle().aile + " " + rdv.getSalle().numero);
//        List<String> profs = rdv.getProfstoString();
//        List<String> eleves = rdv.getElevestoString();
//        this.listProf.getChildren().removeAll();
//        this.listEleve.getChildren().removeAll();
//        // ajouter à la base de données
//        for (String str : profs) {
//            listProf.getChildren().add(new Label(str));
//        }
//        for (String str : eleves) {
//            listEleve.getChildren().add(new Label(str));
//        }
    }
}
