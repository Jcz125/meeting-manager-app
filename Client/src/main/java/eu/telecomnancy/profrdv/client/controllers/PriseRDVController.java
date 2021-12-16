package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

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
    private Set<String> stringSet;
    ObservableList observableList = FXCollections.observableArrayList();


    public PriseRDVController(){

    }

    public void setListView()
    {
        stringSet.add("String 1");
        stringSet.add("String 2");
        stringSet.add("String 3");
        stringSet.add("String 4");
        observableList.setAll(stringSet);
        listViewLundi.setItems(observableList);
        listViewLundi.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
        {
            @Override
            public ListCell<String> call(ListView<String> listView)
            {
                return new PriseRDVCell();
            }
        });
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
