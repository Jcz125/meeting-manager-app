package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.RendezVous;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.*;
import java.awt.*;

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


    public PriseRDVController(){

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
