package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class DispoViewController implements Observateur, Initializable {
    private Utilisateur user;

    @FXML
    private ListView<DisponibiliteFixe> disponibiliteFixeListView;

    private ObservableList<DisponibiliteFixe> disponibiliteFixeObservableList;

    public DispoViewController(Utilisateur user) {
        this.user = user;
        disponibiliteFixeObservableList = FXCollections.observableArrayList();
        disponibiliteFixeObservableList.addAll(user.getDisponibiliteFixe());
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.disponibiliteFixeListView.setItems(disponibiliteFixeObservableList);
        this.disponibiliteFixeListView.setCellFactory(listRDVView -> new DispoCellController());
    }

    public void update() {

    }
}
