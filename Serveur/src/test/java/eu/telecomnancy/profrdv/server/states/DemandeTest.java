package eu.telecomnancy.profrdv.server.states;


import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.states.Demande;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemandeTest {

    @Test
    public void testSuperTypes() {
        Demande demande = new Demande();
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Demande", demande);
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
        rdv.demande();
        assertEquals(rdv.getEtatRendezVous().name(), "DEMANDE");
    }


    @Test
    public void testRealise() {
        RendezVous rdv = new RendezVous(LocalDateTime.now(), new ArrayList<>(), null, "", "");
        rdv.realiser();
        assertEquals(rdv.getEtatRendezVous().name(), "DEMANDE");
    }

}
