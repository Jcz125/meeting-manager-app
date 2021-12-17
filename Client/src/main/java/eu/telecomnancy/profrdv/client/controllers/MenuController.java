package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Ecole;
import eu.telecomnancy.profrdv.client.model.ProfRDV;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.List;

public class MenuController implements Observateur {

    private MenuController mc;
    private Utilisateur utilisateur;
    private String idToConnect;

    private BorderPane panneau;
    private Parent creation;
    private Parent planning;
    private Parent espacePerso;
    private Parent identification;
    private Parent accueil;

    private ProfRDV profRDV;


    public MenuController() {

    }


    @FXML
    private void handleAccueilButton(ActionEvent actionEvent) {
        panneau.setCenter(accueil);
    }


    @FXML
    private void handlePersonalButton(ActionEvent actionEvent) {
        panneau.setCenter(espacePerso);
    }


    @FXML
    private void handlePlanningButton(ActionEvent actionEvent) {
        panneau.setCenter(planning);
    }


    @FXML
    private void handleIdButton(ActionEvent actionEvent) {
//        String id = (String) JOptionPane.showInputDialog(new Component() {
//                                                         },
//                "Identifiant",
//                "Identifiez-Vous",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                null,
//                null);
//
//        if (id != null) {
//            this.idToConnect = id;
//        }
        panneau.setCenter(identification);
    }


    public String getIdToConnect() {
        return this.idToConnect;
    }


    @FXML
    private void handleCreateButton(ActionEvent actionEvent) throws IOException {
        panneau.setCenter(creation);
    }


    public void init(List<Utilisateur> utilisateurs, Ecole ecole) {
        this.setIdentificationNode(ecole);
        this.setCreationNode();
        this.setPlanningNode(utilisateurs);
        this.setPriseRDV(utilisateurs);
        this.setEspacePersoNode(ecole);
    }


    public void setCreationNode() {

        FXMLLoader creationLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/Creation.fxml"));
        creationLoader.setControllerFactory(iC -> new CreationController());
        Parent creationParent;
        try {
            creationParent = creationLoader.load();
            CreationController creationController = creationLoader.getController();
            creationController.setProfRDV(profRDV);
            this.creation = creationParent;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setPlanningNode(List<Utilisateur> utilisateurs) {

        FXMLLoader planningLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/Planning.fxml"));
        planningLoader.setControllerFactory(iC -> new PlanningController(utilisateurs.get(0)));
        try {
            this.planning = planningLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void setEspacePersoNode(Ecole ecole) {

        FXMLLoader espacePersoLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/EspacePerso.fxml"));
        espacePersoLoader.setControllerFactory(iC -> new EspacePersoController(ecole.getUtilisateurs().get(0)));
        try {
            this.espacePerso = espacePersoLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EspacePersoController espacePersoController = espacePersoLoader.getController();

        FXMLLoader centerPaneLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/ConfigDispo.fxml"));
        centerPaneLoader.setControllerFactory(iC -> new ConfigDispoController(ecole.getUtilisateurs().get(0)));

        FXMLLoader leftPaneLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/RDV-view.fxml"));
        leftPaneLoader.setControllerFactory(iC -> new RDVViewController(ecole.getUtilisateurs().get(0)));


        try {
            espacePersoController.setCenter(centerPaneLoader.load());
            espacePersoController.setLeft(leftPaneLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setIdentificationNode(Ecole ecole) {
        FXMLLoader identificationLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/Identification.fxml"));
        identificationLoader.setControllerFactory(iC -> new IdentificationController(ecole.getUtilisateurs()));
        try {
            this.identification = identificationLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setPriseRDV(List<Utilisateur> utilisateurs) {
        FXMLLoader priseRDVLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/PriseRDV.fxml"));
        priseRDVLoader.setControllerFactory(iC -> new PriseRDVController(utilisateurs, utilisateurs.get(0)));
        try {
            this.accueil = priseRDVLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Parent getIdentification() {
        return identification;
    }


    @Override
    public void update() {

    }


    public void setPanneau(BorderPane panneau) {
        this.panneau = panneau;
    }


    public void setProfRDV(ProfRDV profRDV) {
        this.profRDV = profRDV;
    }
}
