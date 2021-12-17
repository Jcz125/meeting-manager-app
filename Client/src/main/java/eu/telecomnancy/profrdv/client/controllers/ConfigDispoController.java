package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Professeur;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import eu.telecomnancy.profrdv.client.model.disponibilite.DisponibiliteFixe;
import eu.telecomnancy.profrdv.client.model.disponibilite.ModificateurDisponibilite;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private ListView<ModificateurDisponibilite> exceptionsDispo;
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
        DispoViewController dpLundi = new DispoViewController(((Professeur) user).getDispoJour(DayOfWeek.MONDAY), this.lundiDispo);
        DispoViewController dpMardi = new DispoViewController(((Professeur) user).getDispoJour(DayOfWeek.TUESDAY), this.mardiDispo);
        DispoViewController dpMercredi = new DispoViewController(((Professeur) user).getDispoJour(DayOfWeek.WEDNESDAY), this.mercrediDispo);
        DispoViewController dpJeudi = new DispoViewController(((Professeur) user).getDispoJour(DayOfWeek.THURSDAY), this.jeudiDispo);
        DispoViewController dpVendredi = new DispoViewController(((Professeur) user).getDispoJour(DayOfWeek.FRIDAY), this.vendrediDispo);
        DispoViewController dpSamedi = new DispoViewController(((Professeur) user).getDispoJour(DayOfWeek.SATURDAY), this.samediDispo);
        DispoViewController dpDimanche = new DispoViewController(((Professeur) user).getDispoJour(DayOfWeek.SUNDAY), this.dimancheDispo);
//        ModificateurDisponibilite mod = new ModificateurDisponibilite(true, LocalDateTime.of(LocalDate.of(1999, 2, 7), LocalTime.of(13,0,0)), LocalDateTime.of(LocalDate.of(1999, 2, 7), LocalTime.of(14,0,0)));
//        ((Professeur) user).getDispoExcept((Professeur) user).add(0, mod);
        DispoExceptViewController dpExceptions = new DispoExceptViewController(((Professeur) user).getDispoExcept((Professeur) user), this.exceptionsDispo);
        System.out.println("dpExcept size=" + (((Professeur) user).getDispoExcept((Professeur) user)).size());
        System.out.println("dpExcept:" + dpExceptions);
    }

    public void update() {

    }
}
