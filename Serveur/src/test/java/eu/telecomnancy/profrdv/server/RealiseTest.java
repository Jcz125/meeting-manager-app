package eu.telecomnancy.profrdv.server;


import eu.telecomnancy.profrdv.server.model.states.Realise;
import org.junit.jupiter.api.Test;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;

public class RealiseTest {

    @Test
    public void RealiseSuperTypes() {
        Realise realise = new Realise(null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.states.Realise", realise);
    }
}
