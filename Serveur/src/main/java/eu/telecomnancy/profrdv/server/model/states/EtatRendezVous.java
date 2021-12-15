package eu.telecomnancy.profrdv.server.model.states;

import eu.telecomnancy.profrdv.server.model.RendezVous;

public abstract class EtatRendezVous {
    protected RendezVous rendezVous;

    public EtatRendezVous() {

    }

    public void setRDV(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }


    public abstract void confirmer(RendezVous rendezVous);

    public abstract void demande(RendezVous rendezVous);

    public abstract void annuler(RendezVous rendezVous);

    public abstract void realiser(RendezVous rendezVous);
}
