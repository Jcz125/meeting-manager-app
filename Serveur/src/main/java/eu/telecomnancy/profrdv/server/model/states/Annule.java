package eu.telecomnancy.profrdv.server.model.states;

import eu.telecomnancy.profrdv.server.model.RendezVous;

public class Annule extends EtatRendezVous {
    public Annule(RendezVous rendezVous) {
        super(rendezVous);
    }


    @Override
    public void confirmer() {
        // on ne fait rien car on ne peut plus confirmer un rendez-vous s'il a été annulé
    }


    @Override
    public void demande() {
        // on ne fait rien car le rendez-vous ne peut pas être en demande s'il a été annulé
    }


    @Override
    public void annuler() {
        // il est déjà annulé
    }


    @Override
    public void realiser() {
        // il n'est plus possible de réaliser un rendez-vous s'il a été annulé
    }
}
