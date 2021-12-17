package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalTime;

public class DispoCellController extends ListCell<DisponibiliteFixe> implements Observateur{

    private DisponibiliteFixe dispo;
    @FXML
    private TextField debut_heure;
    @FXML
    private TextField debut_minute;
    @FXML
    private TextField fin_heure;
    @FXML
    private TextField fin_minute;
    @FXML
    private Button b_modifier;
    @FXML
    private Button b_supprimer;
    @FXML
    private AnchorPane anchorPaneDispoCell;

    private FXMLLoader fxmlLoader;

    public DispoCellController() {

    }

    public void updateItem(DisponibiliteFixe dispo, boolean empty) {
        super.updateItem(dispo, empty);
        if (empty || dispo == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/DispoCell.fxml"));
                fxmlLoader.setController(this);
                try {
                    fxmlLoader.load();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            this.dispo = dispo;
            this.debut_heure.setText(""+dispo.getDebut().getHour());
            this.debut_minute.setText(""+dispo.getDebut().getMinute());
            this.fin_heure.setText(""+dispo.getFin().getHour());
            System.out.println("##############debut:"+this.debut_heure+" fin:"+this.fin_heure);
            this.fin_minute.setText(""+((dispo.getFin().getMinute() >= 10) ? dispo.getFin().getMinute() : ""+0+dispo.getFin().getMinute()));
            setText(null);
            setGraphic(anchorPaneDispoCell);
        }
    }

    @FXML
    public void handle_modifier() {
        LocalTime debut_horaire = LocalTime.of(Integer.valueOf(this.debut_heure.getText()), Integer.valueOf(this.debut_minute.getText()));
        this.dispo.setDebut(debut_horaire);
        LocalTime fin_horaire = LocalTime.of(Integer.valueOf(this.fin_heure.getText()), Integer.valueOf(this.fin_minute.getText()));
        this.dispo.setFin(fin_horaire);
    }

    @FXML
    public void handle_supprimer() {

    }

    public void update() {

    }

}
