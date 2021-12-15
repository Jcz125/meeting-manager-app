package eu.telecomnancy.profrdv.server;


import eu.telecomnancy.profrdv.server.model.states.Demande;
import org.junit.jupiter.api.Test;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;

public class DemandeTest {

    @Test
    public void DemandeSuperTypes() {
        Demande demande = new Demande(null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Demande", demande);
    }

}
