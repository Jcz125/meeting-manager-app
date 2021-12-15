package eu.telecomnancy.profrdv.server.states;


import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.states.Annule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;

@SuppressWarnings("ALL")
public class AnnuleTest {

    @Test
    public void testSuperTypes() {
        Annule annule = new Annule();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Annule", annule);
    }


    @Test
    public void testAnnulation() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.annuler();
        rdv.annuler();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Annule", rdv.getEtatRendezVous());
    }


    @Test
    public void testConfirmation() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.annuler();
        rdv.confirmer();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Annule", rdv.getEtatRendezVous());
    }


    @Test
    public void testDemande() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.annuler();
        rdv.demande();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Annule", rdv.getEtatRendezVous());
    }


    @Test
    public void testRealise() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.annuler();
        rdv.realiser();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Annule", rdv.getEtatRendezVous());
    }
}
