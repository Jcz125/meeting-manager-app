package eu.telecomnancy.profrdv.server.model.states;

import eu.telecomnancy.profrdv.server.model.RendezVous;

public class Demande extends EtatRendezVous {
    public Demande() {

    }


    @Override
    public void confirmer(RendezVous rendezVous) {
        // le rendez-vous a été confirmé par tous les participants
        rendezVous.setState(EtatRendezVousEnum.CONFIRME);
    }


    @Override
    public void demande(RendezVous rendezVous) {
        // le rendez-vous est déjà en attente de demande
    }


    @Override
    public void annuler(RendezVous rendezVous) {
        // le rendez-vous est annulé
        rendezVous.setState(EtatRendezVousEnum.ANNULE);
    }


    @Override
    public void realiser(RendezVous rendezVous) {
        // on ne peut pas réaliser le rendez-vous s'il est encore en demande de confirmation
    }
}
