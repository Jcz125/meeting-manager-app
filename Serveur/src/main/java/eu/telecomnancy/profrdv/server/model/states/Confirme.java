package eu.telecomnancy.profrdv.server.model.states;

import eu.telecomnancy.profrdv.server.model.RendezVous;

public class Confirme extends EtatRendezVous {
    public Confirme() {

    }

    @Override
    public void confirmer(RendezVous rendezVous) {
        // il est déjà confirmé
    }


    @Override
    public void demande(RendezVous rendezVous) {
        // il est déjà confirmé
    }


    @Override
    public void annuler(RendezVous rendezVous) {
        // on annule le rendez-vous dans ce cas
        this.rendezVous.setState(EtatRendezVousEnum.ANNULE);

    }


    @Override
    public void realiser(RendezVous rendezVous) {
        // le rendez-vous a été réalisé
        this.rendezVous.setState(EtatRendezVousEnum.REALISE);
    }
}
