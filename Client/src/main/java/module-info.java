module eu.telecomnancy.profrdv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires spring.boot;
    requires spring.web;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    exports eu.telecomnancy.profrdv.client;
    exports eu.telecomnancy.profrdv.client.controllers;
    exports eu.telecomnancy.profrdv.client.model;
    exports eu.telecomnancy.profrdv.client.model.data;
    opens eu.telecomnancy.profrdv.client to javafx.fxml;
    opens eu.telecomnancy.profrdv.client.controllers to javafx.fxml;
}
