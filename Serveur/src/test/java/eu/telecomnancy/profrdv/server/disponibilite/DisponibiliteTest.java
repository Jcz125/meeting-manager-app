package eu.telecomnancy.profrdv.server.disponibilite;

import eu.telecomnancy.profrdv.server.model.disponibilite.Disponibilite;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DisponibiliteTest {
    @Test
    public void testSuperTypes() {
        Disponibilite disponibilite = new Disponibilite();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.disponibilite.NouvelleDisponibilite", disponibilite);
    }


    @Test
    public void testEstDisponible() {
        LocalTime debut = LocalTime.of(8, 0);
        LocalTime fin = LocalTime.of(12, 0);
        LocalDateTime horaire = LocalDateTime.of(2021, 12, 15, 9, 0);

        Disponibilite planning = new Disponibilite();
        planning.add(DayOfWeek.MONDAY, debut, fin);
        planning.add(DayOfWeek.TUESDAY, debut, fin);
        planning.add(DayOfWeek.WEDNESDAY, debut, fin);
        assertTrue(planning.estDisponible(horaire));

        LocalDateTime debutException = LocalDateTime.of(2021, 12, 15, 9, 0);
        LocalDateTime finException = LocalDateTime.of(2021, 12, 15, 12, 0);
        planning.add(false, debutException, finException);
        assertFalse(planning.estDisponible(horaire));

        horaire = LocalDateTime.of(2021, 12, 15, 12, 0);
        assertFalse(planning.estDisponible(horaire));

        horaire = LocalDateTime.of(2021, 12, 15, 8, 0);
        assertTrue(planning.estDisponible(horaire));

        LocalDateTime debutInclusion = LocalDateTime.of(2021, 12, 15, 16, 0);
        LocalDateTime finInclusion = LocalDateTime.of(2021, 12, 15, 17, 0);
        planning.add(true, debutInclusion, finInclusion);

        horaire = LocalDateTime.of(2021, 12, 15, 16, 0);
        assertTrue(planning.estDisponible(horaire));

        horaire = LocalDateTime.of(2021, 12, 15, 16, 20);
        assertTrue(planning.estDisponible(horaire));

        horaire = LocalDateTime.of(2021, 12, 15, 17, 0);
        assertFalse(planning.estDisponible(horaire));

    }
}
