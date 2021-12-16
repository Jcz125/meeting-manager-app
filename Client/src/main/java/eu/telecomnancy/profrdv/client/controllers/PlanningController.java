package eu.telecomnancy.profrdv.client.controllers;


import eu.telecomnancy.profrdv.client.model.RendezVous;
import eu.telecomnancy.profrdv.client.model.Utilisateur;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.util.Pair;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PlanningController implements Observateur{

    @FXML private Label lundi; // = new Label("Lundi");
    @FXML private Label mardi; // = new Label("Lundi");
    @FXML private Label mercredi; // = new Label("Lundi");
    @FXML private Label jeudi; // = new Label("Lundi");
    @FXML private Label vendredi; // = new Label("Lundi");
    @FXML private Label samedi; //= new Label("Lundi");
    @FXML private Label dimanche; //= new Label("Lundi");
    @FXML private Label titre ;
    @FXML private Label description ;
    @FXML private Label lieu ;
    @FXML private ListView listViewLundi ;
    @FXML private ListView listViewMardi ;
    @FXML private ListView listViewMercredi ;
    @FXML private ListView listViewJeudi ;
    @FXML private ListView listViewVendredi ;
    @FXML private ListView listViewSamedi ;
    @FXML private ListView listViewDimanche ;

    private Utilisateur u ;
    private List<RendezVous> RDVs ;
    private LocalDate jour ;
    private Label[] listJour = {lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche};
    private int count=0;

    private ArrayList<Pair> RdvlistLundi = new ArrayList<Pair>();
    private ArrayList<Pair> RdvlistMardi = new ArrayList<Pair>();
    private ArrayList<Pair> RdvlistMercredi = new ArrayList<Pair>();
    private ArrayList<Pair> RdvlistJeudi = new ArrayList<Pair>();
    private ArrayList<Pair> RdvlistVendredi = new ArrayList<Pair>();
    private ArrayList<Pair> RdvlistSamedi = new ArrayList<Pair>();
    private ArrayList<Pair> RdvlistDimanche = new ArrayList<Pair>();

    ObservableList observableListLundi = FXCollections.observableArrayList();
    ObservableList observableListMardi = FXCollections.observableArrayList();
    ObservableList observableListMercredi = FXCollections.observableArrayList();
    ObservableList observableListJeudi = FXCollections.observableArrayList();
    ObservableList observableListVendredi = FXCollections.observableArrayList();
    ObservableList observableListSamedi = FXCollections.observableArrayList();
    ObservableList observableListDimanche = FXCollections.observableArrayList();


    private String heurRDV ;

    public PlanningController(Utilisateur u){
        this.u = u ;
        this.RDVs = u.getRDVs();
//        this.listJour.add(lundi);
//        this.listJour.add(mardi);
//        this.listJour.add(mercredi);
//        this.listJour.add(jeudi);
//        this.listJour.add(vendredi);
//        this.listJour.add(samedi);
//        this.listJour.add(dimanche);

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

//        for (int i = 0; i < 7; i++) {
//            String formattedDay = df.format(c.getTime());
//            listJour[i].setText(formattedDay);
//            c.add(Calendar.DATE, 1);
//        }
        setHours();
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

    public void setHours() throws ParseException {
        for (RendezVous rdv : RDVs) {
            String titre = rdv.getTitre();
            LocalDateTime horaire = rdv.getHoraire();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = horaire.format(formatter); // "1986-04-08 12:30"
            String[] words = formattedDateTime.split(" ");
            String date = words[0];
            DayOfWeek jour = horaire.getDayOfWeek();
            int numJour = jour.getValue();
            String heur = words[1];

            Calendar c = Calendar.getInstance();
            c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //c.add(Calendar.DATE, 1);
            //c.add(Calendar.DATE, 7 * count);
            String formattedDay1 = df.format(c.getTime());

            long diff = DaysBetween(date, formattedDay1);

            System.out.println(diff);

            if (count == diff/7) {
                switch ((int)diff) {
                    case 0 :
                        RdvlistLundi.add(new Pair(heur,titre));
                        break;
                    case 1 :
                        RdvlistMardi.add(new Pair(heur,titre));
                        break;
                    case 2 :
                        RdvlistMercredi.add(new Pair(heur,titre));
                        break;
                    case 3 :
                        RdvlistJeudi.add(new Pair(heur,titre));
                        break;
                    case 4 :
                        RdvlistVendredi.add(new Pair(heur,titre));
                        break;
                    case 5 :
                        RdvlistSamedi.add(new Pair(heur,titre));
                        break;
                    case 6 :
                        RdvlistDimanche.add(new Pair(heur,titre));
                        break;
                    default:
                        break ;
                }
            }
        }
        listViewConst(observableListLundi, RdvlistLundi, listViewLundi);
        listViewConst(observableListMardi, RdvlistMardi, listViewMardi);
        listViewConst(observableListMercredi, RdvlistMercredi, listViewMercredi);
        listViewConst(observableListJeudi, RdvlistJeudi, listViewJeudi);
        listViewConst(observableListVendredi, RdvlistVendredi, listViewVendredi);
        listViewConst(observableListSamedi, RdvlistSamedi, listViewSamedi);
        listViewConst(observableListDimanche, RdvlistDimanche, listViewDimanche);

        RdvlistLundi.clear();
        RdvlistMardi.clear();
        RdvlistMercredi.clear();
        RdvlistJeudi.clear();
        RdvlistVendredi.clear();
        RdvlistSamedi.clear();
        RdvlistDimanche.clear();

//        listViewLundi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                heurRDV = (String)newValue;
//                //System.out.println(heurRDV);
//            }
//        });

    }

    private void listViewConst(ObservableList o, ArrayList<Pair> list, ListView listView){
        o.removeAll(o) ;
        o.setAll(list);
        listView.getItems().addAll(o);
    }

    @FXML
    private void handleSemProButton() throws ParseException {
        count++;
        setCalender(count*7);
        setHours();
    }

    @FXML
    private void handleSemPrecButton() throws ParseException {
        count--;
        setCalender(count*7);
        setHours();
    }

    @Override
    public void update() {

    }

}
