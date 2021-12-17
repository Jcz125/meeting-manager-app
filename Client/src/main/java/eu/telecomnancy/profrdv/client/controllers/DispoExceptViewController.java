package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import eu.telecomnancy.profrdv.client.model.disponibilite.ModificateurDisponibilite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class DispoExceptViewController implements Observateur {

    private ListView<ModificateurDisponibilite> disponibiliteExceptListView;

    private ObservableList<ModificateurDisponibilite> disponibiliteExceptObservableList;

    public DispoExceptViewController(List<ModificateurDisponibilite> dispos, ListView<ModificateurDisponibilite> dispoListView) {
        this.disponibiliteExceptListView = dispoListView;
        this.disponibiliteExceptObservableList = FXCollections.observableArrayList();
        this.disponibiliteExceptObservableList.addAll(dispos);

        this.disponibiliteExceptListView.setItems(disponibiliteExceptObservableList);
        this.disponibiliteExceptListView.setCellFactory(listRDVView -> new DispoExceptCellController());

    }

    public ListView<ModificateurDisponibilite> getDispoList() {
        return this.disponibiliteExceptListView;
    }


    public void update() {

    }
}
