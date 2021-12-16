package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PriseRDVController implements Observateur{

    @FXML private TextField researchBar ;
    @FXML private Label lundi ;
    @FXML private Label mardi ;
    @FXML private Label mercredi ;
    @FXML private Label jeudi ;
    @FXML private Label vendredi ;
    @FXML private Label samedi ;
    @FXML private Label dimanche ;
    @FXML private ListView listViewLundi ;
    @FXML private ListView listViewMardi ;
    @FXML private ListView listViewMercredi ;
    @FXML private ListView listViewJeudi ;
    @FXML private ListView listViewVendredi ;
    @FXML private ListView listViewSamedi ;
    @FXML private ListView listViewDimanche ;
    @FXML private ListView listViewProfs ;
    private RendezVous RDV ;
    private Utilisateur u ;
    private ArrayList<String> dispoList = new ArrayList<String>();
    private List<RendezVous> RDVList = new ArrayList<RendezVous>();
    ObservableList observableList = FXCollections.observableArrayList();
    private String heurRDV ;
    private List<Utilisateur> listUtilisateur;


    public PriseRDVController(Utilisateur u){
        this.u = u ;
    }

    private void loadData() {
        RDVList = this.u.getRDVs();
        for (RendezVous rdv : RDVList) {
            LocalDateTime horaire = rdv.getHoraire();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = horaire.format(formatter); // "1986-04-08 12:30"
            String[] words = formattedDateTime.split(" ");
            String date = words[0];
            DayOfWeek jour = horaire.getDayOfWeek();
            int numJour = jour.getValue();
            String heur = words[1];
            dispoList.add(heur);
        }
        observableList.removeAll(observableList) ;
        observableList.setAll(dispoList);
        listViewLundi.getItems().addAll(observableList);

        listViewLundi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                heurRDV = (String)newValue;
                //System.out.println(heurRDV);
                //u.prendreRDV(listUtilisateur, heurRDV);
            }
        });
    }

//    public void setListView()
//    {
//        stringList.add("String 1");
//        stringList.add("String 2");
//        stringList.add("String 3");
//        stringList.add("String 4");
//        observableList.setAll(stringList);
//        listViewLundi.setItems(observableList);
//        listViewLundi.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
//        {
//            @Override
//            public ListCell<String> call(ListView<String> listViewLundi)
//            {
//                return new PriseRDVCell();
//            }
//        });
//    }

    @FXML
    void initialize() {
        loadData();
    }

    @FXML
    private void handleResearchButton(){

    }


    @FXML
    private void handlePriseRDVButton(){
        String titre = (String) JOptionPane.showInputDialog(new Component(){},
                "Titre",
                "Titre du Rendez-vous",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        String description = (String) JOptionPane.showInputDialog(new Component(){},
                "Description",
                "Description du rendez-vous",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        if (titre != null) {
            this.RDV.setTitre(titre);
        }

        if (description != null) {
            this.RDV.setDescription(description);
        }

        //Create RDV ;

    }


    @Override
    public void update() {

    }
}
