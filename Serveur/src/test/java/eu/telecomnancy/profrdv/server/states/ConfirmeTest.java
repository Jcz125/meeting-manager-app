package eu.telecomnancy.profrdv.server.states;


import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.states.Confirme;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;

public class ConfirmeTest {

    @Test
    public void testSuperTypes() {
        Confirme confirme = new Confirme(null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Confirme", confirme);
    }


    @Test
    public void testAnnulation() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.annuler();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Annule", rdv.getEtatRendezVous());
    }


    @Test
    public void testConfirmation() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.confirmer();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Confirme", rdv.getEtatRendezVous());
    }


    @Test
    public void testDemande() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.confirmer();
        rdv.demande();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Confirme", rdv.getEtatRendezVous());
    }


    @Test
    public void testRealise() {
        RendezVous rdv = new RendezVous(null, new ArrayList<>(), null, null, null);
        rdv.confirmer();
        rdv.realiser();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Realise", rdv.getEtatRendezVous());
    }
}
