package eu.telecomnancy.profrdv.model.states;

import eu.telecomnancy.profrdv.model.RendezVous;

public class Confirme extends EtatRendezVous {
    public Confirme(RendezVous rendezVous) {
        super(rendezVous);
    }


    @Override
    public void confirmer() {
        // il est déjà confirmé
    }


    @Override
    public void demande() {
        // il est déjà confirmé
    }


    @Override
    public void annuler() {
        // on annule le rendez-vous dans ce cas
        this.rendezVous.setState(new Annule(this.rendezVous));

    }


    @Override
    public void realiser() {
        // le rendez-vous a été réalisé
        this.rendezVous.setState(new Realise(this.rendezVous));
    }
}
