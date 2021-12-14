package eu.telecomnancy.profrdv.client.model.states;

import eu.telecomnancy.profrdv.client.model.RendezVous;

public class Realise extends EtatRendezVous {
    public Realise(RendezVous rendezVous) {
        super(rendezVous);
    }


    @Override
    public void confirmer() {
        // il est déjà réalisé on ne fait rien de plus
    }


    @Override
    public void demande() {
        // il est déjà réalisé on ne fait rien de plus
    }


    @Override
    public void annuler() {
        // il est déjà réalisé on ne fait rien de plus
    }


    @Override
    public void realiser() {
        // il est déjà réalisé on ne fait rien de plus
    }
}
