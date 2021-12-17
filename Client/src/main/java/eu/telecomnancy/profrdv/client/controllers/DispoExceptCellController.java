package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import eu.telecomnancy.profrdv.client.model.disponibilite.ModificateurDisponibilite;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DispoExceptCellController extends ListCell<ModificateurDisponibilite> implements Observateur {

    private ModificateurDisponibilite dispo;
    @FXML
    private TextField debut_heure;
    @FXML
    private TextField debut_minute;
    @FXML
    private TextField fin_heure;
    @FXML
    private TextField fin_minute;
    @FXML
    private Label label_date;
    @FXML
    private Button b_modifier;
    @FXML
    private Button b_supprimer;
    @FXML
    private GridPane gridPaneDispoCell;

    private FXMLLoader fxmlLoader;

    public DispoExceptCellController() {
        System.out.println("#############Step1#############");
    }

    public void updateItem(ModificateurDisponibilite dispo, boolean empty) {
        super.updateItem(dispo, empty);
        if (empty || dispo == null) {
            setText(null);
            setGraphic(null);
            System.out.println("#############Step2#############");
        } else {
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/DispoExceptCell.fxml"));
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
            this.label_date.setText(""+dispo.getDebut().getDayOfYear());
            setText(null);
            setGraphic(gridPaneDispoCell);
        }
    }

    @FXML
    public void handle_modifier() {
        LocalTime debut_horaire = LocalTime.of(Integer.valueOf(this.debut_heure.getText()), Integer.valueOf(this.debut_minute.getText()));
        this.dispo.setDebut(LocalDateTime.of(dispo.getDebut().toLocalDate(), debut_horaire));
        LocalTime fin_horaire = LocalTime.of(Integer.valueOf(this.fin_heure.getText()), Integer.valueOf(this.fin_minute.getText()));
        this.dispo.setDebut(LocalDateTime.of(dispo.getFin().toLocalDate(), fin_horaire));
    }

    @FXML
    public void handle_supprimer() {

    }

    public void update() {

    }

}