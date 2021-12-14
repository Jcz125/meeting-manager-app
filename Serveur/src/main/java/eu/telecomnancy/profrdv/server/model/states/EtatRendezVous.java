package eu.telecomnancy.profrdv.server.model.states;

import eu.telecomnancy.profrdv.server.model.RendezVous;

public abstract class EtatRendezVous {
    protected final RendezVous rendezVous;


    public EtatRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }


    public abstract void confirmer();

    public abstract void demande();

    public abstract void annuler();

    public abstract void realiser();
}
