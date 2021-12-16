package eu.telecomnancy.profrdv.client.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class EspacePerso implements Observateur {
    @FXML
    private AnchorPane centerPane;
    @FXML
    private AnchorPane rightPane;


    public EspacePerso() {

    }


    @Override
    public void update() {

    }


    public void setCenter(AnchorPane center) {
        this.centerPane.getChildren().add(center);
    }


    public void setLeft(AnchorPane left) {
        this.rightPane.getChildren().add(left);
    }
}
