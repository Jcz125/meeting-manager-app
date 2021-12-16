package eu.telecomnancy.profrdv.client.controllers;


import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PlanningController implements Observateur{

    @FXML private Label lundi; // = new Label("Lundi");
    @FXML private Label mardi; // = new Label("Lundi");
    @FXML private Label mercredi; // = new Label("Lundi");
    @FXML private Label jeudi; // = new Label("Lundi");
    @FXML private Label vendredi; // = new Label("Lundi");
    @FXML private Label samedi; //= new Label("Lundi");
    @FXML private Label dimanche; //= new Label("Lundi");
    @FXML private ListView listViewLundi ;
    @FXML private ListView listViewMardi ;
    @FXML private ListView listViewMercredi ;
    @FXML private ListView listViewJeudi ;
    @FXML private ListView listViewVendredi ;
    @FXML private ListView listViewSamedi ;
    @FXML private ListView listViewDimanche ;

    private Utilisateur u ;
    private List<RendezVous> RDVs ;
    private LocalDate jour ;
    private Label[] listJour = {lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche};
    private int count=0;

    public PlanningController(Utilisateur u){
        this.u = u ;
        this.RDVs = u.getRDVs();
//        this.listJour.add(lundi);
//        this.listJour.add(mardi);
//        this.listJour.add(mercredi);
//        this.listJour.add(jeudi);
//        this.listJour.add(vendredi);
//        this.listJour.add(samedi);
//        this.listJour.add(dimanche);

    }

    @FXML
    void initialize() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String formattedDay1 = df.format(c.getTime());
        lundi.setText(formattedDay1);
        c.add(Calendar.DATE, 1);

        String formattedDay2 = df.format(c.getTime());
        mardi.setText(formattedDay2);
        c.add(Calendar.DATE, 1);

        String formattedDay3 = df.format(c.getTime());
        mercredi.setText(formattedDay3);
        c.add(Calendar.DATE, 1);

        String formattedDay4 = df.format(c.getTime());
        jeudi.setText(formattedDay4);
        c.add(Calendar.DATE, 1);

        String formattedDay5 = df.format(c.getTime());
        vendredi.setText(formattedDay5);
        c.add(Calendar.DATE, 1);

        String formattedDay6 = df.format(c.getTime());
        samedi.setText(formattedDay6);
        c.add(Calendar.DATE, 1);

        String formattedDay7 = df.format(c.getTime());
        dimanche.setText(formattedDay7);
        c.add(Calendar.DATE, 1);

//        for (int i = 0; i < 7; i++) {
//            String formattedDay = df.format(c.getTime());
//            listJour[i].setText(formattedDay);
//            c.add(Calendar.DATE, 1);
//        }
    }

    public void setCalender(int param){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        c.add(Calendar.DATE, param);
        String formattedDay1 = df.format(c.getTime());
        lundi.setText(formattedDay1);

        c.add(Calendar.DATE, 1);
        String formattedDay2 = df.format(c.getTime());
        mardi.setText(formattedDay2);

        c.add(Calendar.DATE, 1);
        String formattedDay3 = df.format(c.getTime());
        mercredi.setText(formattedDay3);

        c.add(Calendar.DATE, 1);
        String formattedDay4 = df.format(c.getTime());
        jeudi.setText(formattedDay4);

        c.add(Calendar.DATE, 1);
        String formattedDay5 = df.format(c.getTime());
        vendredi.setText(formattedDay5);

        c.add(Calendar.DATE, 1);
        String formattedDay6 = df.format(c.getTime());
        samedi.setText(formattedDay6);

        c.add(Calendar.DATE, 1);
        String formattedDay7 = df.format(c.getTime());
        dimanche.setText(formattedDay7);
    }

    public void setHours() {
        for (RendezVous rdv : RDVs) {

            LocalDateTime horaire = rdv.getHoraire();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = horaire.format(formatter); // "1986-04-08 12:30"

            String[] words = formattedDateTime.split(" ");
            String date = words[0];
            String heur = words[1];

            DayOfWeek jour = horaire.getDayOfWeek();
            int numJour = jour.getValue();
//
//            String[] HeurMin = heur.split(":");
//            int numHeur = Integer.parseInt(HeurMin[0]);
//            int numMin = Integer.parseInt(HeurMin[1]);
//            int numMinTotal = (numHeur*60)+numMin ;
        }
    }

    @FXML
    private void handleSemProButton(){
        count++;
        setCalender(count*7);
    }

    @FXML
    private void handleSemPrecButton(){
        count--;
        setCalender(count*7);
    }

    @Override
    public void update() {

    }

}
