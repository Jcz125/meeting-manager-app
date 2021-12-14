package eu.telecomnancy.profrdv.model.states;

import eu.telecomnancy.profrdv.model.RendezVous;

public class Demande extends EtatRendezVous {
    public Demande(RendezVous rendezVous) {
        super(rendezVous);
    }


    @Override
    public void confirmer() {
        // le rendez-vous a été confirmé par tous les participants
        this.rendezVous.setState(new Confirme(this.rendezVous));
    }


    @Override
    public void demande() {
        // le rendez-vous est déjà en attente de demande
    }


    @Override
    public void annuler() {
        // le rendez-vous est annulé
        this.rendezVous.setState(new Annule(this.rendezVous));
    }


    @Override
    public void realiser() {
        // on ne peut pas réaliser le rendez-vous s'il est encore en demande de confirmation
    }
}
