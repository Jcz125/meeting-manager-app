package eu.telecomnancy.profrdv.server;

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
import java.util.List;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RendezVousTest {

    @Test
    public void testSuperTypes() {
        RendezVous rendezVous = new RendezVous(null, new ArrayList<>());
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.RendezVous", rendezVous);
    }


    @Test
    public void testGenererRendezVous() {
        Eleve eleve1 = new Eleve("a", "b", "c");
        Eleve eleve2 = new Eleve("a", "b", "c");
        Professeur professeur1 = new Professeur("a", "b", "c");
        Professeur professeur2 = new Professeur("a", "b", "c");

        professeur1.add(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(12, 0));
        professeur2.add(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(14, 0));

        LocalDateTime debut = LocalDateTime.of(2021, 12, 13, 0, 0);
        LocalDateTime fin = LocalDateTime.of(2021, 12, 20, 0, 0);

        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurs.add(eleve1);
        utilisateurs.add(eleve2);
        utilisateurs.add(professeur1);
        utilisateurs.add(professeur2);
        List<RendezVous> creneaux = RendezVous.genererRendezVous(utilisateurs, debut, fin);

        assertEquals(creneaux.size(), 6);
        Salle salle = new Salle(2, 2, "nord");
        assertTrue(eleve1.prendreRDV(utilisateurs, salle, creneaux.get(0).getHoraire(), null, null));


        creneaux = RendezVous.genererRendezVous(utilisateurs, debut, fin);
        assertEquals(creneaux.size(), 5);

    }
}
