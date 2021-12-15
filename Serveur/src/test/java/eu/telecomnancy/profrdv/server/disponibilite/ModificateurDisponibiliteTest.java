package eu.telecomnancy.profrdv.server.disponibilite;

import eu.telecomnancy.profrdv.server.model.disponibilite.ModificateurDisponibilite;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModificateurDisponibiliteTest {

    @Test
    public void testSuperTypes() {
        ModificateurDisponibilite modificateurDisponibilite = new ModificateurDisponibilite(true, null, null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.disponibilite.ModificateurDisponibilite", modificateurDisponibilite);
    }


    @Test
    public void testEstDisponible() {
        LocalDateTime horaire = LocalDateTime.of(2021, 12, 15, 15, 0);
        LocalDateTime debut = LocalDateTime.of(2021, 12, 15, 15, 0);
        LocalDateTime fin = LocalDateTime.of(2021, 12, 15, 16, 0);
        ModificateurDisponibilite dispo = new ModificateurDisponibilite(true, debut, fin);
        assertTrue(dispo.estDansLeCreneau(horaire));


        horaire = LocalDateTime.of(2021, 12, 15, 14, 0);
        debut = LocalDateTime.of(2021, 12, 15, 15, 0);
        fin = LocalDateTime.of(2021, 12, 15, 16, 0);
        dispo = new ModificateurDisponibilite(true, debut, fin);
        assertFalse(dispo.estDansLeCreneau(horaire));


        horaire = LocalDateTime.of(2021, 12, 15, 16, 0);
        debut = LocalDateTime.of(2021, 12, 15, 15, 0);
        fin = LocalDateTime.of(2021, 12, 15, 16, 0);
        dispo = new ModificateurDisponibilite(true, debut, fin);
        assertFalse(dispo.estDansLeCreneau(horaire));


        horaire = LocalDateTime.of(2021, 12, 15, 17, 0);
        debut = LocalDateTime.of(2021, 12, 15, 15, 0);
        fin = LocalDateTime.of(2021, 12, 15, 16, 0);
        dispo = new ModificateurDisponibilite(true, debut, fin);
        assertFalse(dispo.estDansLeCreneau(horaire));
    }
}
