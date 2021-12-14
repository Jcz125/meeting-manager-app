module eu.telecomnancy.profrdv {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.telecomnancy.profrdv.client to javafx.fxml;
    exports eu.telecomnancy.profrdv.client;
    exports eu.telecomnancy.profrdv.client.controllers;
    opens eu.telecomnancy.profrdv.client.controllers to javafx.fxml;
    exports eu.telecomnancy.profrdv.client.model.states;
    opens eu.telecomnancy.profrdv.client.model.states to javafx.fxml;
    exports eu.telecomnancy.profrdv.client.model;
    opens eu.telecomnancy.profrdv.client.model to javafx.fxml;
}