package eu.telecomnancy.profrdv.server.disponibilite;

import eu.telecomnancy.profrdv.server.model.disponibilite.DisponibiliteFlexible;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisponibiliteFlexibleTest {

    @Test
    public void testSuperTypes() {
        DisponibiliteFlexible disponibiliteFlexible = new DisponibiliteFlexible(true, null, null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.disponibilite.DisponibiliteFlexible", disponibiliteFlexible);
    }


    @Test
    public void testEstDisponible() {
        LocalDateTime horaire = LocalDateTime.of(2021, 12, 15, 15, 0);
        LocalDateTime debut = LocalDateTime.of(2021, 12, 15, 15, 0);
        LocalDateTime fin = LocalDateTime.of(2021, 12, 15, 16, 0);
        DisponibiliteFlexible dispo = new DisponibiliteFlexible(true, debut, fin);
        assertTrue(dispo.estDedans(horaire));


        horaire = LocalDateTime.of(2021, 12, 15, 14, 0);
        debut = LocalDateTime.of(2021, 12, 15, 15, 0);
        fin = LocalDateTime.of(2021, 12, 15, 16, 0);
        dispo = new DisponibiliteFlexible(true, debut, fin);
        assertFalse(dispo.estDedans(horaire));


        horaire = LocalDateTime.of(2021, 12, 15, 15, 0);
        debut = LocalDateTime.of(2021, 12, 15, 15, 0);
        fin = LocalDateTime.of(2021, 12, 15, 16, 0);
        dispo = new DisponibiliteFlexible(false, debut, fin);
        assertFalse(dispo.estDedans(horaire));


        horaire = LocalDateTime.of(2021, 12, 15, 14, 0);
        debut = LocalDateTime.of(2021, 12, 15, 15, 0);
        fin = LocalDateTime.of(2021, 12, 15, 16, 0);
        dispo = new DisponibiliteFlexible(false, debut, fin);
        assertFalse(dispo.estDedans(horaire));
    }
}
