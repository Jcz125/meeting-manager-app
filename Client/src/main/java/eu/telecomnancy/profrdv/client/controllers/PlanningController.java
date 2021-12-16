package eu.telecomnancy.profrdv.client.controllers;


import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PlanningController implements Observateur{

    @FXML private GridPane myGrid;
    @FXML private Label lundi;
    @FXML private Label mardi;
    @FXML private Label mercredi;
    @FXML private Label jeudi;
    @FXML private Label vendredi;
    @FXML private Label samedi;
    @FXML private Label dimanche;

    private Utilisateur u ;
    private List<RendezVous> RDVs ;

    public PlanningController(Utilisateur u){
        this.u = u ;
        this.RDVs = u.getRDVs();
    }

    private void AddToGrid(int numJour, int numMinTotal){

    }

    public void setHours() {
        for (RendezVous rdv : RDVs) {
            LocalDateTime horaire = rdv.getHoraire();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = horaire.format(formatter); // "1986-04-08 12:30"
            String[] words = formattedDateTime.split(" ");
            String date = words[0];
            DayOfWeek jour = horaire.getDayOfWeek();
            int numJour = jour.getValue();
            String heur = words[1];
            String[] HeurMin = heur.split(":");
            int numHeur = Integer.parseInt(HeurMin[0]);
            int numMin = Integer.parseInt(HeurMin[1]);
            int numMinTotal = (numHeur*60)+numMin ;
            AddToGrid(numJour, numMinTotal);
        }
    }

    @FXML
    private void handleSemPrecButton(){

    }

    @FXML
    private void handleSemProButton(){

    }

    @Override
    public void update() {

    }

}
