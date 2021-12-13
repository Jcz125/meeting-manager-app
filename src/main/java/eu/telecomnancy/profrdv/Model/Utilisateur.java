package eu.telecomnancy.profrdv.Model;

public abstract class Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private boolean notification;
    
    public Utilisateur(String nom, String prenom, String email) {}
    public void notifier(RendezVous rendezVous) {}
    public void ajouterRDV(RendezVous rendezVous) {}
    public void annulerRDV(RendezVous rendezVous) {}
}
