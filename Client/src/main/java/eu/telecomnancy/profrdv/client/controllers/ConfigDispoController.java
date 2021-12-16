package eu.telecomnancy.profrdv.client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ConfigDispoController implements Observateur {
    @FXML
    private ListView<CreneauCell> lundiDispo;
    @FXML
    private ListView<CreneauCell> mardiDispo;
    @FXML
    private ListView<CreneauCell> mercrediDispo;
    @FXML
    private ListView<CreneauCell> jeudiDispo;
    @FXML
    private ListView<CreneauCell> vendrediDispo;
    @FXML
    private ListView<CreneauCell> samediDispo;
    @FXML
    private ListView<CreneauCell> dimancheDispo;
    @FXML
    private Button lundiAdd;
    @FXML
    private Button mardiAdd;
    @FXML
    private Button mercrediAdd;
    @FXML
    private Button jeudiAdd;
    @FXML
    private Button vendrediAdd;
    @FXML
    private Button samediAdd;
    @FXML
    private Button dimancheAdd;

    public void update() {

    }
}
