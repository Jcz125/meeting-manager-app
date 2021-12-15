package eu.telecomnancy.profrdv.server;


import eu.telecomnancy.profrdv.server.model.states.Annule;
import org.junit.jupiter.api.Test;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;

public class AnnuleTest {

    @Test
    public void AnnuleSuperTypes() {
        Annule annule = new Annule(null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Annule", annule);
    }

}
