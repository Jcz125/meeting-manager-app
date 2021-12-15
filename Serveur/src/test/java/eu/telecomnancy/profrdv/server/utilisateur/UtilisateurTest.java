package eu.telecomnancy.profrdv.server.utilisateur;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.Salle;
import eu.telecomnancy.profrdv.server.model.utilisateur.Eleve;
import eu.telecomnancy.profrdv.server.model.utilisateur.Professeur;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.*;

public class UtilisateurTest {
    @Test
    public void testSuperTypes() {
        Utilisateur eleve = new Eleve(null, null, null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.utilisateur.Eleve", eleve);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur", eleve);
    }


    @Test
    public void testGetNom() {
        String nom = "Dupont";
        Utilisateur eleve = new Eleve(nom, null, null);
        assertEquals(eleve.getNom(), nom);
    }


    @Test
    public void testGetPrenom() {
        String prenom = "Roger";
        Utilisateur eleve = new Eleve(null, prenom, null);
        assertEquals(eleve.getPrenom(), prenom);
    }


    @Test
    public void testGetEmail() {
        String email = "littleboy@outlook.com";
        Utilisateur eleve = new Eleve(null, null, email);
        assertEquals(eleve.getEmail(), email);
    }


    @Test
    public void testSetGetTelephone() {
        String telephone = "06 51 84 62 64";
        Utilisateur eleve = new Eleve(null, null, null);
        eleve.setTelephone(telephone);
        assertEquals(eleve.getTelephone(), telephone);
    }


    @Test
    public void testGetTelephone() {
        String email = "littleboy@outlook.com";
        Utilisateur eleve = new Eleve(null, null, email);
        assertEquals(eleve.getEmail(), email);
    }


    @Test
    public void testSetNom() {
        String nom = "Dupont";
        String nouveauNom = "Dubois";
        Utilisateur eleve = new Eleve(nom, null, null);
        eleve.setNom(nouveauNom);
        assertEquals(eleve.getNom(), nouveauNom);
    }


    @Test
    public void testSetPrenom() {
        String prenom = "Roger";
        String nouveauPrenom = "Jean";
        Utilisateur eleve = new Eleve(null, prenom, null);
        eleve.setPrenom(nouveauPrenom);
        assertEquals(eleve.getPrenom(), nouveauPrenom);
    }


    @Test
    public void testSetEmail() {
        String email = "littleboy@outlook.com";
        String nouveauEmail = "bigBoy03@gmail.com";
        Utilisateur eleve = new Eleve(null, null, email);
        eleve.setEmail(nouveauEmail);
        assertEquals(eleve.getEmail(), nouveauEmail);
    }


    @Test
    public void testAnnulerRDV() {
        Eleve eleve = new Eleve("Dupont", "Jean", "jean.dupont@telecomnancy.net");
        LocalDateTime date = LocalDateTime.of(2021, 12, 15, 15, 5);
        RendezVous rendezVous = new RendezVous(date, new ArrayList<>(), null, null, null);
        assertFalse(eleve.annulerRDV(rendezVous));

        eleve.ajouterRDV(rendezVous);
        assertTrue(eleve.annulerRDV(rendezVous));
    }


    @Test
    public void testPrendreRDV() {
        Eleve jean = new Eleve("Dupont", "Jean", "jean.dupont@gmail.com");
        Eleve george = new Eleve("Bubois", "George", "george.dubois@outlook.com");

        Professeur gerald = new Professeur("Oster", "Gerald", "gerald.oster@telecomnancy.net");
        Professeur christophe = new Professeur("Bouthier", "Christophe", "christophe.bouthier@telecomnancy.net");

        LocalTime debut = LocalTime.of(8, 0);
        LocalTime fin = LocalTime.of(12, 0);
        gerald.add(DayOfWeek.WEDNESDAY, debut, fin);
        christophe.add(DayOfWeek.THURSDAY, debut, fin);


        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurs.add(gerald);
        utilisateurs.add(george);

        Salle salle = new Salle(2, 1, "ouest");
        LocalDateTime date1 = LocalDateTime.of(2021, 12, 15, 14, 20);
        assertFalse(jean.prendreRDV(utilisateurs, salle, date1, "RDV", "Test"));

        LocalDateTime date2 = LocalDateTime.of(2021, 12, 15, 9, 20);
        assertTrue(jean.prendreRDV(utilisateurs, salle, date2, "RDV", "Test"));
    }
}
