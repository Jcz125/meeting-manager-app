package eu.telecomnancy.profrdv.server.disponibilite;

import eu.telecomnancy.profrdv.server.model.disponibilite.DisponibiliteFixe;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisponibiliteFixeTest {
    @Test
    public void testSuperTypes() {
        DisponibiliteFixe disponibiliteFixe = new DisponibiliteFixe(null, null, null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.disponibilite.DisponibiliteFixe", disponibiliteFixe);
    }


    @Test
    public void testEstDisponible() {
        LocalDateTime horaire = LocalDateTime.of(2021, 12, 15, 15, 0);
        DayOfWeek jour = DayOfWeek.WEDNESDAY;
        LocalTime debut = LocalTime.of(14, 0);
        LocalTime fin = LocalTime.of(16, 0);
        DisponibiliteFixe dispo = new DisponibiliteFixe(jour, debut, fin);
        assertTrue(dispo.estDedans(horaire));


        horaire = LocalDateTime.of(2021, 12, 15, 15, 0);
        jour = DayOfWeek.MONDAY;
        debut = LocalTime.of(14, 0);
        fin = LocalTime.of(16, 0);
        dispo = new DisponibiliteFixe(jour, debut, fin);
        assertFalse(dispo.estDedans(horaire));


        horaire = LocalDateTime.of(2021, 12, 15, 16, 0);
        jour = DayOfWeek.WEDNESDAY;
        debut = LocalTime.of(14, 0);
        fin = LocalTime.of(16, 0);
        dispo = new DisponibiliteFixe(jour, debut, fin);
        assertFalse(dispo.estDedans(horaire));


        horaire = LocalDateTime.of(2021, 12, 16, 15, 0);
        jour = DayOfWeek.WEDNESDAY;
        debut = LocalTime.of(14, 0);
        fin = LocalTime.of(16, 0);
        dispo = new DisponibiliteFixe(jour, debut, fin);
        assertFalse(dispo.estDedans(horaire));
    }

}
