package eu.telecomnancy.profrdv.server.states;


import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.states.Confirme;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfirmeTest {

    @Test
    public void testSuperTypes() {
        Confirme confirme = new Confirme();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Confirme", confirme);
    }


    @Test
    public void testAnnulation() {
        RendezVous rdv = new RendezVous(LocalDateTime.now(), new ArrayList<>(), null, "", "");
        rdv.annuler();
        assertEquals(rdv.getEtatRendezVous().name(), "ANNULE");
    }


    @Test
    public void testConfirmation() {
        RendezVous rdv = new RendezVous(LocalDateTime.now(), new ArrayList<>(), null, "", "");
        rdv.confirmer();
        assertEquals(rdv.getEtatRendezVous().name(), "CONFIRME");
    }


    @Test
    public void testDemande() {
        RendezVous rdv = new RendezVous(LocalDateTime.now(), new ArrayList<>(), null, "", "");
        rdv.confirmer();
        rdv.demande();
        assertEquals(rdv.getEtatRendezVous().name(), "CONFIRME");
    }


    @Test
    public void testRealise() {
        RendezVous rdv = new RendezVous(LocalDateTime.now(), new ArrayList<>(), null, "", "");
        rdv.confirmer();
        rdv.realiser();
        assertEquals(rdv.getEtatRendezVous().name(), "REALISE");
    }
}
