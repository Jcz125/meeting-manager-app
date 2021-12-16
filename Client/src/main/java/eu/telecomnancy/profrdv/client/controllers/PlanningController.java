package eu.telecomnancy.profrdv.client.controllers;


import eu.telecomnancy.profrdv.client.model.Utilisateur;

public class PlanningController implements Observateur{

    private Utilisateur u ;

    public PlanningController(Utilisateur u){
        this.u = u ;
    }


    @Override
    public void update() {

    }

}
