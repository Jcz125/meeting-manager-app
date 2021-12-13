module eu.telecomnancy.profrdv {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.telecomnancy.profrdv to javafx.fxml;
    exports eu.telecomnancy.profrdv;
    exports eu.telecomnancy.profrdv.Controllers;
    opens eu.telecomnancy.profrdv.Controllers to javafx.fxml;
    exports eu.telecomnancy.profrdv.Model.States;
    opens eu.telecomnancy.profrdv.Model.States to javafx.fxml;
    exports eu.telecomnancy.profrdv.Model;
    opens eu.telecomnancy.profrdv.Model to javafx.fxml;
}