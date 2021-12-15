package eu.telecomnancy.profrdv.client.model;

import eu.telecomnancy.profrdv.client.model.data.UtilisateurData;

public abstract class Utilisateur {
    private UtilisateurData utilisateurREST;

    public Utilisateur(UtilisateurData utilisateurREST) {
        this.utilisateurREST = utilisateurREST;
    }

    public Utilisateur(String nom, String prenom, String email) {
        utilisateurREST = new UtilisateurData();
        utilisateurREST.nom = nom;
        utilisateurREST.prenom = prenom;
        utilisateurREST.email = email;
    }


    /*public void notifier(RendezVous rendezVous) {
        // fonction pour notifier l'utilisateur d'un changement d'état d'un rendez-vous auquel il participe
        if (notification) {
        }
    }*/


    /*public void ajouterRDV(RendezVous rendezVous) {
        if (!this.RDVs.containsKey(rendezVous.getHoraire())) {
            this.RDVs.put(rendezVous.getHoraire(), rendezVous);
        }
    }*/


    /*public boolean annulerRDV(RendezVous rendezVous) {
        if (this.RDVs.containsKey(rendezVous.getHoraire())) {
            rendezVous.annuler();
            return true;
        }
        return false;
    }*/


    //public abstract boolean estDisponible(RendezVous rendezVous);


    /*public boolean prendreRDV(List<Professeur> profs, List<Eleve> eleves, LocalDateTime date, String titre, String description) {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurs.addAll(profs);
        utilisateurs.addAll(eleves);
        RendezVous rendezVous = new RendezVous(date, utilisateurs, titre, description);

        for (Professeur professeur : profs) {
            if (!professeur.estDisponible(rendezVous))
                return false;
        }

        for (Eleve eleve : eleves) {
            if (!eleve.estDisponible(rendezVous))
                return false;
        }

        for (Utilisateur utilisateur : utilisateurs)
            utilisateur.ajouterRDV(rendezVous);

        return true;
    }*/


    //region assesseurs
    public String getNom() {
        return utilisateurREST.nom;
    }


    public void setNom(String nom) {
        utilisateurREST.nom = nom;
    }


    public String getPrenom() {
        return utilisateurREST.prenom;
    }


    public void setPrenom(String prenom) {
        utilisateurREST.prenom = prenom;
    }


    public String getEmail() {
        return utilisateurREST.email;
    }


    public void setEmail(String email) {
        utilisateurREST.email = email;
    }


    public String getTelephone() {
        return utilisateurREST.telephone;
    }


    public void setTelephone(String telephone) {
        utilisateurREST.telephone = telephone;
    }


    public void setNotification(boolean notification) {
        utilisateurREST.notification = notification;
    }

    public RendezVous[] getRDVs() {
        return new RendezVous[0];
    }
    //endregion
}
