module eu.telecomnancy.profrdv {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.telecomnancy.profrdv to javafx.fxml;
    exports eu.telecomnancy.profrdv;
}