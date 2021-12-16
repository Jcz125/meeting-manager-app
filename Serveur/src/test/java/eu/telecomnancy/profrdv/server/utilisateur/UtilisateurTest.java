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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilisateurTest {
    @Test
    public void testSuperTypes() {
        Utilisateur eleve = new Eleve(null, null, null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.utilisateur.Eleve", eleve);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur", eleve);
    }


    @Test
    public void testAnnulerRDV() {
        Eleve eleve = new Eleve("Dupont", "Jean", "jean.dupont@telecomnancy.net");
        LocalDateTime date = LocalDateTime.of(2021, 12, 15, 15, 5);
        RendezVous rendezVous = new RendezVous(date, null, null, null);
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
