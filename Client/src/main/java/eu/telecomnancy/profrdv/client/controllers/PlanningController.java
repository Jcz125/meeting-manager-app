package eu.telecomnancy.profrdv.client.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class PlanningController implements Observateur{

    @FXML private TableView tableView;
    @FXML private TableColumn lundi;
    @FXML private TableColumn mardi;
    @FXML private TableColumn mercredi;
    @FXML private TableColumn jeudi;
    @FXML private TableColumn vendredi;
    @FXML private TableColumn samedi;
    @FXML private TableColumn dimanche;


    public PlanningController(){

    }




    @Override
    public void update() {

    }

}
