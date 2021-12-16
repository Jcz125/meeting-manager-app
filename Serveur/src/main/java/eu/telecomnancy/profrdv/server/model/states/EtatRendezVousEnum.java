package eu.telecomnancy.profrdv.server.model.states;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.data.EtatRendezVousData;

public enum EtatRendezVousEnum {
    ANNULE(new Annule()),
    CONFIRME(new Confirme()),
    DEMANDE(new Demande()),
    REALISE(new Realise());

    private final EtatRendezVous state;


    EtatRendezVousEnum(EtatRendezVous state) {
        this.state = state;
    }


    public void setRDV(RendezVous rendezVous) {
        state.setRDV(rendezVous);
    }


    public void confirmer(RendezVous rendezVous) {
        state.confirmer(rendezVous);
    }


    public void demande(RendezVous rendezVous) {
        state.demande(rendezVous);
    }


    public void annuler(RendezVous rendezVous) {
        state.annuler(rendezVous);
    }


    public void realiser(RendezVous rendezVous)  { state.realiser(rendezVous);}

    public EtatRendezVousData getData() {
        switch (this) {
            case ANNULE -> {
                return EtatRendezVousData.ANNULE;
            }
            case CONFIRME -> {
                return EtatRendezVousData.CONFIRME;
            }
            case DEMANDE -> {
                return EtatRendezVousData.DEMANDE;
            }
            case REALISE -> {
                return EtatRendezVousData.REALISE;
            }
        }
        return EtatRendezVousData.DEMANDE;
    }
}
