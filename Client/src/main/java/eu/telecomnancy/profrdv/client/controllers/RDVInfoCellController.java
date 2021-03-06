package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class RDVInfoCellController extends ListCell<RendezVous> implements Observateur {

    private RendezVous rdv;
    private Utilisateur u;
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


    public RDVInfoCellController(Utilisateur u) {
        this.u = u;
    }


    public void setInfo(RendezVous rdv) {
        this.rdv = rdv;
        this.titreRDV.setText(rdv.getTitre());
        this.etatRDV.setText(rdv.getEtatRendezVoustoString()); // implementer la methode pour recuperer le string de l'etat du rdv
        this.descriptionRDV.setText(rdv.getDescription());
        this.dateRDV.setText("" + rdv.getHoraire().getDayOfMonth() + "/" + rdv.getHoraire().getMonthValue() + "/" + rdv.getHoraire().getYear());
        this.heureRDV.setText("" + rdv.getHoraire().getHour() + ":" + rdv.getHoraire().getMinute());
        this.lieuRDV.setText("etg:" + rdv.getSalle().getEtage() + " aile:" + rdv.getSalle().getAile() + " salle:" + rdv.getSalle().getNumero());
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
        u.confirmerRDV(rdv);
    }


    public void modifier() {
        // faire pop une fenetre sur l'interface avec plusieurs champs ?? modifier
        String titre = (String) JOptionPane.showInputDialog(new Component() {
                                                            },
                "Titre",
                "Titre du Rendez-vous",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        String description = (String) JOptionPane.showInputDialog(new Component() {
                                                                  },
                "Description",
                "Description du rendez-vous",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        if (titre != null) {
            this.rdv.setTitre(titre);
//            this.rdv.setTitre(this.rdv.getTitre());
        }

        if (description != null) {
            this.rdv.setDescription(description);
//            this.rdv.setDescription(this.rdv.getDescription());
        }


        this.getListView().refresh();
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
                fxmlLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/ListRDVInfoCell.fxml"));
                fxmlLoader.setController(this);
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.rdv = rdv;
            this.titreRDV.setText(rdv.getTitre());
            this.etatRDV.setText(rdv.getEtatRendezVoustoString());
            this.descriptionRDV.setText(rdv.getDescription());
            this.dateRDV.setText("" + rdv.getHoraire().getDayOfMonth() + "/" + rdv.getHoraire().getMonthValue() + "/" + rdv.getHoraire().getYear());
            this.heureRDV.setText("" + rdv.getHoraire().getHour() + ":" + ((rdv.getHoraire().getMinute() >= 10) ? rdv.getHoraire().getMinute() : "" + 0 + rdv.getHoraire().getMinute()));
            this.lieuRDV.setText("etg:" + rdv.getSalle().getEtage() + " aile:" + rdv.getSalle().getAile() + " salle:" + rdv.getSalle().getNumero());
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
    }


    public void update() {

        this.titreRDV.setText(rdv.getTitre());
        this.etatRDV.setText(rdv.getEtatRendezVoustoString());
        this.descriptionRDV.setText(rdv.getDescription());
        this.dateRDV.setText("" + rdv.getHoraire().getDayOfMonth() + "/" + rdv.getHoraire().getMonthValue() + "/" + rdv.getHoraire().getYear());
        this.heureRDV.setText("" + rdv.getHoraire().getHour() + ":" + ((rdv.getHoraire().getMinute() >= 10) ? rdv.getHoraire().getMinute() : "" + 0 + rdv.getHoraire().getMinute()));
        this.lieuRDV.setText("etg:" + rdv.getSalle().getEtage() + " aile:" + rdv.getSalle().getAile() + " salle:" + rdv.getSalle().getNumero());
    }
}
