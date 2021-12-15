package eu.telecomnancy.profrdv.server;


import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.states.Realise;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;

public class RealiseTest {

    @Test
    public void testSuperTypes() {
        Realise realise = new Realise();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Realise", realise);
    }


    @Test
    public void testAnnulation() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.confirmer();
        rdv.realiser();
        rdv.annuler();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Realise", rdv.getEtatRendezVous());
    }


    @Test
    public void testConfirmation() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.confirmer();
        rdv.realiser();
        rdv.realiser();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Realise", rdv.getEtatRendezVous());
    }


    @Test
    public void testDemande() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.confirmer();
        rdv.realiser();
        rdv.demande();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Realise", rdv.getEtatRendezVous());
    }


    @Test
    public void testRealise() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.confirmer();
        rdv.realiser();
        rdv.realiser();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Realise", rdv.getEtatRendezVous());
    }
}
