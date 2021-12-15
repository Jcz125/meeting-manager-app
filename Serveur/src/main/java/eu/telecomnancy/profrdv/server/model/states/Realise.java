package eu.telecomnancy.profrdv.server.model.states;

import eu.telecomnancy.profrdv.server.model.RendezVous;

public class Realise extends EtatRendezVous {
    public Realise() {

    }


    @Override
    public void confirmer(RendezVous rendezVous) {
        // il est déjà réalisé on ne fait rien de plus
    }


    @Override
    public void demande(RendezVous rendezVous) {
        // il est déjà réalisé on ne fait rien de plus
    }


    @Override
    public void annuler(RendezVous rendezVous) {
        // il est déjà réalisé on ne fait rien de plus
    }


    @Override
    public void realiser(RendezVous rendezVous) {
        // il est déjà réalisé on ne fait rien de plus
    }
}
