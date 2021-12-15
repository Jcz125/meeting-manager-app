package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

import java.io.IOException;

public class RDVViewController implements Observateur {

    private Utilisateur user;

    @FXML
    private ListView<RDVInfoCellController> listRDVView;

    public RDVViewController() {

    }

    public void initialize() {
//        for (RendezVous rdv : user.getRDVs()) {
//            RDVInfoCellController rdvInfo = new RDVInfoCellController();
//            rdvInfo.setInfo(rdv);
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListRDVInfoCell.fxml"));
//            fxmlLoader.setController(this);
//            try {
//                fxmlLoader.load();
//            }
//            catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

    public void update() {

    }
}
