package eu.telecomnancy.profrdv.server.model.states;

import eu.telecomnancy.profrdv.server.model.RendezVous;

public class Annule extends EtatRendezVous {
    public Annule() {

    }


    @Override
    public void confirmer(RendezVous rendezVous) {
        // on ne fait rien car on ne peut plus confirmer un rendez-vous s'il a été annulé
    }


    @Override
    public void demande(RendezVous rendezVous) {
        // on ne fait rien car le rendez-vous ne peut pas être en demande s'il a été annulé
    }


    @Override
    public void annuler(RendezVous rendezVous) {
        // il est déjà annulé
    }


    @Override
    public void realiser(RendezVous rendezVous) {
        // il n'est plus possible de réaliser un rendez-vous s'il a été annulé
    }
}
