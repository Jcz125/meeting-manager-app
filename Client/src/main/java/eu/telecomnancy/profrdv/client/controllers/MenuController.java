package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Ecole;
import eu.telecomnancy.profrdv.client.model.ProfRDV;
import eu.telecomnancy.profrdv.client.model.Professeur;
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
    private Parent menuIdentification;

    private ProfRDV profRDV;
    private List<Utilisateur> utilisateurs;


    public MenuController() {

    }


    @FXML
    private void handleAccueilButton(ActionEvent actionEvent) {
        panneau.setCenter(priseRDV);
    }


    @FXML
    private void handlePersonalButton(ActionEvent actionEvent) {
        this.profRDV.updateListView();
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
    private void handleCreateButton(ActionEvent actionEvent) throws IOException {
        panneau.setCenter(creation);
    }


    @FXML
    private void handleDecoButton(ActionEvent actionEvent) {
        this.profRDV.setConnectedUtilisateur(null);
        this.panneau.setTop(menuIdentification);
        this.panneau.setCenter(identification);
    }


    public void init(List<Utilisateur> utilisateurs, Ecole ecole) {
        this.ecole = ecole;
        this.utilisateurs = utilisateurs;

        this.setIdentificationNode();
        this.setCreationNode();
        this.setMenuProf();
        this.setMenuEleve();
    }


    public void initConnection() {
        this.setPlanningNode();
        this.setEspacePersoNode();
        this.setPriseRDV();
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


    private void setPlanningNode() {

        FXMLLoader planningLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/Planning.fxml"));
        planningLoader.setControllerFactory(iC -> new PlanningController(this.profRDV.getConnectedUtilisateur()));
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


        FXMLLoader leftPaneLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/RDV-view.fxml"));
        leftPaneLoader.setControllerFactory(iC -> new RDVViewController(profRDV.getConnectedUtilisateur()));


        try {
            if (this.profRDV.getConnectedUtilisateur() instanceof Professeur) {
                FXMLLoader centerPaneLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/ConfigDispo.fxml"));
                centerPaneLoader.setControllerFactory(iC -> new ConfigDispoController(profRDV.getConnectedUtilisateur()));
                espacePersoController.setCenter(centerPaneLoader.load());
                espacePersoController.setLeft(leftPaneLoader.load());
            } else {
                espacePersoController.setCenter(leftPaneLoader.load());
            }
            this.profRDV.setRdvViewController(leftPaneLoader.getController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setIdentificationNode() {
        FXMLLoader identificationLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/Identification.fxml"));
        identificationLoader.setControllerFactory(iC -> new IdentificationController(this.ecole.getUtilisateurs()));

        try {
            this.identification = identificationLoader.load();
            IdentificationController controller = identificationLoader.getController();
            controller.setProfRDV(this.profRDV);
            controller.setMenuController(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setPriseRDV() {
        FXMLLoader priseRDVLoader = new FXMLLoader(getClass().getResource("/eu/telecomnancy/profrdv/client/PriseRDV.fxml"));
        priseRDVLoader.setControllerFactory(iC -> new PriseRDVController(utilisateurs, this.profRDV.getConnectedUtilisateur(), this.profRDV));

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
        initConnection();
        this.panneau.setTop(menuProf);
        this.panneau.setCenter(priseRDV);
    }


    public void chargerEleveMenu() {
        initConnection();
        this.panneau.setTop(menuEleve);
        this.panneau.setCenter(priseRDV);
    }


    public void setMenuIdentification(Parent menuIdentification) {
        this.menuIdentification = menuIdentification;
    }
}
