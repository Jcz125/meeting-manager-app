package eu.telecomnancy.profrdv.server;


import eu.telecomnancy.profrdv.server.model.states.Annule;
import eu.telecomnancy.profrdv.server.model.states.Confirme;
import eu.telecomnancy.profrdv.server.model.states.Demande;
import eu.telecomnancy.profrdv.server.model.states.Realise;
import org.junit.jupiter.api.Test;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;

public class ConfirmeTest {

    @Test
    public void ConfirmeSuperTypes() {
        Confirme confirme = new Confirme(null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Confirme", confirme);
    }


}
