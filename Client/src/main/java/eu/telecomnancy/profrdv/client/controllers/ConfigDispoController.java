package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Professeur;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.time.DayOfWeek;

public class ConfigDispoController implements Observateur {
    private Utilisateur user;
    @FXML
    private ListView<DisponibiliteFixe> lundiDispo;
    @FXML
    private ListView<DisponibiliteFixe> mardiDispo;
    @FXML
    private ListView<DisponibiliteFixe> mercrediDispo;
    @FXML
    private ListView<DisponibiliteFixe> jeudiDispo;
    @FXML
    private ListView<DisponibiliteFixe> vendrediDispo;
    @FXML
    private ListView<DisponibiliteFixe> samediDispo;
    @FXML
    private ListView<DisponibiliteFixe> dimancheDispo;
    @FXML
    private ListView<DisponibiliteFixe> exceptionsDispo;
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

    public ConfigDispoController(Utilisateur user) {
        this.user = user;
    }

    @FXML
    public void initialize() {
        DispoViewController dp = new DispoViewController(((Professeur) user).getDispoJour(DayOfWeek.MONDAY), this.lundiDispo);
    }

    public void update() {

    }
}
