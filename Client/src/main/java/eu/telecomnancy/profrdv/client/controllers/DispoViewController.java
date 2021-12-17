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
import java.util.List;
import java.util.ResourceBundle;

public class DispoViewController implements Observateur, Initializable {

    private ListView<DisponibiliteFixe> disponibiliteFixeListView;

    private ObservableList<DisponibiliteFixe> disponibiliteFixeObservableList;

    public DispoViewController(List<DisponibiliteFixe> dispos, ListView<DisponibiliteFixe> dispoListView) {
        this.disponibiliteFixeListView = dispoListView;
        disponibiliteFixeObservableList = FXCollections.observableArrayList();
        disponibiliteFixeObservableList.addAll(dispos);
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.disponibiliteFixeListView.setItems(disponibiliteFixeObservableList);
        this.disponibiliteFixeListView.setCellFactory(listRDVView -> new DispoCellController());
    }

    public ListView<DisponibiliteFixe> getDispoList() {
        return this.disponibiliteFixeListView;
    }

    public void update() {

    }
}
