package eu.telecomnancy.profrdv.client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.*;
import java.awt.*;

public class PriseRDVController implements Observateur{

    @FXML TextField researchBar ;
    @FXML Label lundi ;
    @FXML Label mardi ;
    @FXML Label mercredi ;
    @FXML Label jeudi ;
    @FXML Label vendredi ;
    @FXML Label samedi ;
    @FXML Label dimanche ;
    @FXML ListView listViewLundi ;
    @FXML ListView listViewMardi ;
    @FXML ListView listViewMercredi ;
    @FXML ListView listViewJeudi ;
    @FXML ListView listViewVendredi ;
    @FXML ListView listViewSamedi ;
    @FXML ListView listViewDimanche ;
    @FXML ListView listViewProfs ;


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
        }

        if (description != null) {
        }
    }


    @Override
    public void update() {

    }
}
