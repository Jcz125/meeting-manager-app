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
    private Ecole ecole;

    private BorderPane panneau;
    private Parent creation;
    private Parent planning;
    private Parent espacePerso;
    private Parent identification;
    private Parent priseRDV;

    private Parent menuProf;
    private Parent menuEleve;

    private ProfRDV profRDV;


    public MenuController() {

    }


    @FXML
    private void handleAccueilButton(ActionEvent actionEvent) {
        panneau.setCenter(priseRDV);
    }


    @FXML
    private void handlePersonalButton(ActionEvent actionEvent) {
        this.setEspacePersoNode();
        panneau.setCenter(espacePerso);
    }


    @FXML
    private void handlePlanningButton(ActionEvent actionEvent) {
        panneau.setCenter(planning);
    }


    @FXML
    private void handleIdButton(ActionEvent actionEvent) {
        panneau.setCenter(identification);
    }


    @FXML
    private void handleDecoButton(ActionEvent actionEvent) {
//        panneau.setCenter(identification);
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
        this.setMenuProf();
        this.setMenuEleve();

        this.ecole = ecole;
    }


    private void setCreationNode() {

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


    private void setPlanningNode(List<Utilisateur> utilisateurs) {

        FXMLLoader planningLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/Planning.fxml"));
        planningLoader.setControllerFactory(iC -> new PlanningController(utilisateurs.get(0)));
        try {
            this.planning = planningLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void setEspacePersoNode() {

        FXMLLoader espacePersoLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/EspacePerso.fxml"));
        espacePersoLoader.setControllerFactory(iC -> new EspacePersoController(profRDV));
        try {
            this.espacePerso = espacePersoLoader.load();
            EspacePersoController controller = espacePersoLoader.getController();
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


    private void setIdentificationNode(Ecole ecole) {
        FXMLLoader identificationLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/Identification.fxml"));
        identificationLoader.setControllerFactory(iC -> new IdentificationController(ecole.getUtilisateurs()));

        try {
            this.identification = identificationLoader.load();
            IdentificationController controller = identificationLoader.getController();
            controller.setProfRDV(this.profRDV);
            controller.setMenuController(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setPriseRDV(List<Utilisateur> utilisateurs) {
        FXMLLoader priseRDVLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/PriseRDV.fxml"));
        priseRDVLoader.setControllerFactory(iC -> new PriseRDVController(utilisateurs, utilisateurs.get(0)));
        try {
            this.priseRDV = priseRDVLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setMenuProf() {
        FXMLLoader profLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/MenuProf.fxml"));
        profLoader.setControllerFactory(iC -> this);
        try {
            this.menuProf = profLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setMenuEleve() {
        FXMLLoader eleveLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/MenuEleve.fxml"));
        eleveLoader.setControllerFactory(iC -> this);
        try {
            this.menuEleve = eleveLoader.load();
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


    public void chargerProfMenu() {
        this.panneau.setTop(menuProf);
        this.panneau.setCenter(planning);
    }


    public void chargerEleveMenu() {
        this.panneau.setTop(menuEleve);
        this.panneau.setCenter(priseRDV);
    }
}
