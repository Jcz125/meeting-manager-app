module eu.telecomnancy.profrdv {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.telecomnancy.profrdv to javafx.fxml;
    exports eu.telecomnancy.profrdv;
    exports eu.telecomnancy.profrdv.controllers;
    opens eu.telecomnancy.profrdv.controllers to javafx.fxml;
    exports eu.telecomnancy.profrdv.model.states;
    opens eu.telecomnancy.profrdv.model.states to javafx.fxml;
    exports eu.telecomnancy.profrdv.model;
    opens eu.telecomnancy.profrdv.model to javafx.fxml;
}