package eu.telecomnancy.profrdv.server.states;


import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.states.Realise;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealiseTest {

    @Test
    public void testSuperTypes() {
        Realise realise = new Realise();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Realise", realise);
    }


    @Test
    public void testAnnulation() {
        RendezVous rdv = new RendezVous(null, null, null, null);
        rdv.confirmer();
        rdv.realiser();
        rdv.annuler();
        assertEquals(rdv.getEtatRendezVous().name(), "REALISE");
    }


    @Test
    public void testConfirmation() {
        RendezVous rdv = new RendezVous(null, null, null, null);
        rdv.confirmer();
        rdv.realiser();
        rdv.realiser();
        assertEquals(rdv.getEtatRendezVous().name(), "REALISE");
    }


    @Test
    public void testDemande() {
        RendezVous rdv = new RendezVous(null, null, null, null);
        rdv.confirmer();
        rdv.realiser();
        rdv.demande();
        assertEquals(rdv.getEtatRendezVous().name(), "REALISE");
    }


    @Test
    public void testRealise() {
        RendezVous rdv = new RendezVous(null, null, null, null);
        rdv.confirmer();
        rdv.realiser();
        rdv.realiser();
        assertEquals(rdv.getEtatRendezVous().name(), "REALISE");
    }
}
