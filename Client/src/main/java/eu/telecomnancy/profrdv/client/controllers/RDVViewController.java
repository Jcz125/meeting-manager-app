package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RDVViewController implements Observateur, Initializable {

    private Utilisateur user;

    @FXML
    private ListView<RendezVous> listRDVView;

    private ObservableList<RendezVous> rdvObservableList;

    public RDVViewController(Utilisateur user) {
        this.user = user;
        rdvObservableList = FXCollections.observableArrayList();
        rdvObservableList.addAll(user.getRDVs());
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.listRDVView.setItems(rdvObservableList);
        this.listRDVView.setCellFactory(listRDVView -> new RDVInfoCellController());
    }

    public void update() {

    }
}
