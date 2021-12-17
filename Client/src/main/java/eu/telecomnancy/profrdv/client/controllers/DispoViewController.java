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

import java.util.List;

public class DispoViewController implements Observateur {

    private ListView<DisponibiliteFixe> disponibiliteFixeListView;

    private ObservableList<DisponibiliteFixe> disponibiliteFixeObservableList;

    public DispoViewController(List<DisponibiliteFixe> dispos, ListView<DisponibiliteFixe> dispoListView) {
        this.disponibiliteFixeListView = dispoListView;
        this.disponibiliteFixeObservableList = FXCollections.observableArrayList();
        this.disponibiliteFixeObservableList.addAll(dispos);

        this.disponibiliteFixeListView.setItems(disponibiliteFixeObservableList);
        this.disponibiliteFixeListView.setCellFactory(disponibiliteFixeListView -> new DispoCellController());

    }

    /*
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        this.disponibiliteFixeListView.setItems(disponibiliteFixeObservableList);
        this.disponibiliteFixeListView.setCellFactory(listRDVView -> new DispoCellController());
    }
    */


    public ListView<DisponibiliteFixe> getDispoList() {
        return this.disponibiliteFixeListView;
    }

    public void update() {

    }


}
