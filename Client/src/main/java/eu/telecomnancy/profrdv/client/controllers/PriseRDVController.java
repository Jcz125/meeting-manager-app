package eu.telecomnancy.profrdv.client.controllers;

import eu.telecomnancy.profrdv.client.model.Ecole;
import eu.telecomnancy.profrdv.client.model.Professeur;
import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PriseRDVController implements Observateur{

    @FXML private TextField researchBar ;
    @FXML private Label lundi ;
    @FXML private Label mardi ;
    @FXML private Label mercredi ;
    @FXML private Label jeudi ;
    @FXML private Label vendredi ;
    @FXML private Label samedi ;
    @FXML private Label dimanche ;
    @FXML private ListView listViewLundi ;
    @FXML private ListView listViewMardi ;
    @FXML private ListView listViewMercredi ;
    @FXML private ListView listViewJeudi ;
    @FXML private ListView listViewVendredi ;
    @FXML private ListView listViewSamedi ;
    @FXML private ListView listViewDimanche ;
    @FXML private ListView listViewProfs ;
    private List<Utilisateur> u ;
    private List<RendezVous> dispo = new ArrayList<>() ;
    private ArrayList<String> dispoList = new ArrayList<String>();
    private List<RendezVous> RDVList = new ArrayList<RendezVous>();
    ObservableList observableList = FXCollections.observableArrayList();
    private String heurRDV ;
    private LocalDateTime horaireRDV ;
    private List<Utilisateur> listUtilisateur;
    private List<String> listString;
    private int count = 0;
    private Utilisateur util ;

    private ArrayList<String> RdvlistLundi = new ArrayList<String>();
    private ArrayList<String> RdvlistMardi = new ArrayList<String>();
    private ArrayList<String> RdvlistMercredi = new ArrayList<String>();
    private ArrayList<String> RdvlistJeudi = new ArrayList<String>();
    private ArrayList<String> RdvlistVendredi = new ArrayList<String>();
    private ArrayList<String> RdvlistSamedi = new ArrayList<String>();
    private ArrayList<String> RdvlistDimanche = new ArrayList<String>();
    private ArrayList<String> Rdvlist = new ArrayList<String>();

    ObservableList observableListLundi = FXCollections.observableArrayList();
    ObservableList observableListMardi = FXCollections.observableArrayList();
    ObservableList observableListMercredi = FXCollections.observableArrayList();
    ObservableList observableListJeudi = FXCollections.observableArrayList();
    ObservableList observableListVendredi = FXCollections.observableArrayList();
    ObservableList observableListSamedi = FXCollections.observableArrayList();
    ObservableList observableListDimanche = FXCollections.observableArrayList();
    ObservableList observableListUtil = FXCollections.observableArrayList();

    public PriseRDVController(List<Utilisateur> u, Utilisateur util){
        this.u = u ;
        this.util = util ;
    }

    @FXML
    void initialize() throws ParseException {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String formattedDay1 = df.format(c.getTime());
        lundi.setText(formattedDay1);
        c.add(Calendar.DATE, 1);

        String formattedDay2 = df.format(c.getTime());
        mardi.setText(formattedDay2);
        c.add(Calendar.DATE, 1);

        String formattedDay3 = df.format(c.getTime());
        mercredi.setText(formattedDay3);
        c.add(Calendar.DATE, 1);

        String formattedDay4 = df.format(c.getTime());
        jeudi.setText(formattedDay4);
        c.add(Calendar.DATE, 1);

        String formattedDay5 = df.format(c.getTime());
        vendredi.setText(formattedDay5);
        c.add(Calendar.DATE, 1);

        String formattedDay6 = df.format(c.getTime());
        samedi.setText(formattedDay6);
        c.add(Calendar.DATE, 1);

        String formattedDay7 = df.format(c.getTime());
        dimanche.setText(formattedDay7);
        c.add(Calendar.DATE, 1);

        loadData();
    }

    private long DaysBetween(String str1, String str2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
        Date firstDate = sdf.parse(str1);
        Date secondDate = sdf.parse(str2);

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        //System.out.println("The difference in days is : "+diffrence);
        return diffrence ;
    }

    private void LoadUtilisateur(String u) {
        //observableListUtil.removeAll(observableListUtil) ;
        observableListUtil.add(u);
        listViewProfs.setItems(observableListUtil);
//        listViewProfs.setCellFactory(new Callback<ListView, ListCell>() {
//            @Override
//            public ListCell call(ListView param) {
//                return new PriseRDVCell();
//            }
//        });
    }

    private void loadData() throws ParseException {

        listViewLundi.getItems().clear();
        listViewMardi.getItems().clear();
        listViewMercredi.getItems().clear();
        listViewJeudi.getItems().clear();
        listViewVendredi.getItems().clear();
        listViewSamedi.getItems().clear();
        listViewDimanche.getItems().clear();

        LocalDateTime debut = LocalDateTime.now();
        int hour = debut.getHour();
        int min = debut.getMinute();

        if ( min%20 == 0 ) {
            debut = LocalDateTime.of(debut.getYear(), debut.getMonthValue(), debut.getDayOfMonth(), hour, min, 00);
        }
        else {
            debut = debut.plusMinutes(20-(min%20));
        }
        System.out.println(" what "+(20-(min%20)));

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c1.add(Calendar.DATE, 6);
        Date finX = c1.getTime();

        LocalDateTime fin = LocalDateTime.of(finX.getYear()+1900, finX.getMonth()+1, finX.getDate(), 23, 40, 00);

//        System.out.println("sund "+fin);
//        System.out.println("auj "+debut);

        dispo = RendezVous.genererRendezVous(u, debut, fin);

        for (RendezVous rdv : dispo) {
            LocalDateTime horaire = rdv.getHoraire();
            //System.out.println("RDV "+ horaire);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = horaire.format(formatter); // "1986-04-08 12:30"

            System.out.println("RDV "+ formattedDateTime);

            String[] words = formattedDateTime.split(" ");
            String date = words[0];
            DayOfWeek jour = horaire.getDayOfWeek();
            int numJour = jour.getValue();
            String heur = words[1];

            System.out.println("hour "+ heur);

//            Calendar c = Calendar.getInstance();
//            c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//            String formattedDay1 = df.format(c.getTime());

            //long diff = DaysBetween(date, formattedDay1);

            //System.out.println("diff  "+ diff);

            //if (count == Integer.parseInt(String.valueOf(diff/7))) {
                //switch ((int)(diff%7)) {
                switch (numJour) {
                    case 1 :
                        RdvlistLundi.add(heur);
                        break;
                    case 2 :
                        RdvlistMardi.add(heur);
                        break;
                    case 3 :
                        RdvlistMercredi.add(heur);
                        break;
                    case 4 :
                        RdvlistJeudi.add(heur);
                        break;
                    case 5 :
                        RdvlistVendredi.add(heur);
                        break;
                    case 6 :
                        RdvlistSamedi.add(heur);
                        break;
                    case 7 :
                        RdvlistDimanche.add(heur);
                        break;
                    default:
                        break ;
                }

        }
        listViewConst(observableListLundi, RdvlistLundi, listViewLundi);
        listViewConst(observableListMardi, RdvlistMardi, listViewMardi);
        listViewConst(observableListMercredi, RdvlistMercredi, listViewMercredi);
        listViewConst(observableListJeudi, RdvlistJeudi, listViewJeudi);
        listViewConst(observableListVendredi, RdvlistVendredi, listViewVendredi);
        listViewConst(observableListSamedi, RdvlistSamedi, listViewSamedi);
        listViewConst(observableListDimanche, RdvlistDimanche, listViewDimanche);
    }

    public void setCalender(int param){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        c.add(Calendar.DATE, param);
        String formattedDay1 = df.format(c.getTime());
        lundi.setText(formattedDay1);

        c.add(Calendar.DATE, 1);
        String formattedDay2 = df.format(c.getTime());
        mardi.setText(formattedDay2);

        c.add(Calendar.DATE, 1);
        String formattedDay3 = df.format(c.getTime());
        mercredi.setText(formattedDay3);

        c.add(Calendar.DATE, 1);
        String formattedDay4 = df.format(c.getTime());
        jeudi.setText(formattedDay4);

        c.add(Calendar.DATE, 1);
        String formattedDay5 = df.format(c.getTime());
        vendredi.setText(formattedDay5);

        c.add(Calendar.DATE, 1);
        String formattedDay6 = df.format(c.getTime());
        samedi.setText(formattedDay6);

        c.add(Calendar.DATE, 1);
        String formattedDay7 = df.format(c.getTime());
        dimanche.setText(formattedDay7);
    }

    @FXML
    private void handleSemProButton() throws ParseException {
        count++;
        setCalender(count*7);
        loadData();
    }

    @FXML
    private void handleSemPrecButton() throws ParseException {
        count--;
        setCalender(count*7);
        loadData();
    }

    private void listViewConst(ObservableList o, ArrayList<String> list, ListView listView){
        o.removeAll(o) ;
        o.setAll(list);
        listView.getItems().addAll(o);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                heurRDV = (String)newValue;
                String[] heurMin= heurRDV.split(":");
                int heur = Integer.parseInt(heurMin[0]);
                int min = Integer.parseInt(heurMin[1]);

                Label label = new Label() ;

                if (listView == listViewLundi) {
                    label.setText(lundi.getText());
                }
                else if (listView == listViewMardi) {
                    label.setText(mardi.getText());
                }
                else if (listView == listViewMercredi) {
                    label.setText(mercredi.getText());
                }
                else if(listView == listViewJeudi) {
                    label.setText(jeudi.getText());
                }
                else if(listView == listViewVendredi) {
                    label.setText(vendredi.getText());
                }
                else if(listView == listViewSamedi) {
                    label.setText(samedi.getText());
                }else if (listView == listViewDimanche){
                    label.setText(dimanche.getText());
                }

                String[] jourMoisAn= label.getText().split("/");
                int jour = Integer.parseInt(jourMoisAn[0]);
                int mois = Integer.parseInt(jourMoisAn[1]);
                int an = Integer.parseInt(jourMoisAn[2]);
                horaireRDV = LocalDateTime.of(an, mois, jour, heur, min, 00);
            }
        });
        list.clear();
    }

//    public void setListView()
//    {
//        stringList.add("String 1");
//        stringList.add("String 2");
//        stringList.add("String 3");
//        stringList.add("String 4");
//        observableList.setAll(stringList);
//        listViewLundi.setItems(observableList);
//        listViewLundi.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
//        {
//            @Override
//            public ListCell<String> call(ListView<String> listViewLundi)
//            {
//                return new PriseRDVCell();
//            }
//        });
//    }


    @FXML
    private void handleResearchButton() throws ParseException {
        String prof = this.researchBar.getText() ;
        LoadUtilisateur(prof);
        // chercher l'utilisateur correspondant
        loadData();
    }


    @FXML
    private void handlePriseRDVButton(){
        String titre = (String) JOptionPane.showInputDialog(new Component(){},
                "Titre",
                "Titre du Rendez-vous",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        String description = (String) JOptionPane.showInputDialog(new Component(){},
                "Description",
                "Description du rendez-vous",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);


        //Create RDV ;
        Ecole ecole = new Ecole();
        listUtilisateur = new ArrayList<>();
        listString = listViewProfs.getItems();
        for (String mail  : listString){
            for (Utilisateur u : ecole.getUtilisateurs()) {
                if (u.getEmail().equals(mail)){
                    listUtilisateur.add(u);
                }
            }
        }
        util.prendreRDV(listUtilisateur, horaireRDV, titre, description, ecole.getSalles().get(0));
    }


    @Override
    public void update() {

    }
}
