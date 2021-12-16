package eu.telecomnancy.profrdv.server.states;


import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.states.Annule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SuppressWarnings("ALL")
public class AnnuleTest {

    @Test
    public void testSuperTypes() {
        Annule annule = new Annule();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Annule", annule);
    }


    @Test
    public void testAnnulation() {
        RendezVous rdv = new RendezVous(null, null, null, null);
        rdv.annuler();
        rdv.annuler();
        assertEquals(rdv.getEtatRendezVous().name(), "ANNULE");
    }


    @Test
    public void testConfirmation() {
        RendezVous rdv = new RendezVous(null, null, null, null);
        rdv.annuler();
        rdv.confirmer();
        assertEquals(rdv.getEtatRendezVous().name(), "ANNULE");
    }


    @Test
    public void testDemande() {
        RendezVous rdv = new RendezVous(null, null, null, null);
        rdv.annuler();
        rdv.demande();
        assertEquals(rdv.getEtatRendezVous().name(), "ANNULE");
    }


    @Test
    public void testRealise() {
        RendezVous rdv = new RendezVous(null, null, null, null);
        rdv.annuler();
        rdv.realiser();
        assertEquals(rdv.getEtatRendezVous().name(), "ANNULE");
    }
}
