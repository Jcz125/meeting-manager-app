package eu.telecomnancy.profrdv.server;

import eu.telecomnancy.profrdv.server.model.utilisateur.Professeur;
import org.junit.jupiter.api.Test;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfesseurTest {

    @Test
    public void testSuperTypes() {
        Professeur Professeur = new Professeur(null, null, null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.utilisateur.Professeur", Professeur);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur", Professeur);
    }


    @Test
    public void testGetNom() {
        String nom = "Dupont";
        Professeur Professeur = new Professeur(nom, null, null);
        assertEquals(Professeur.getNom(), nom);
    }


    @Test
    public void testGetPrenom() {
        String prenom = "Roger";
        Professeur Professeur = new Professeur(null, prenom, null);
        assertEquals(Professeur.getPrenom(), prenom);
    }


    @Test
    public void testGetEmail() {
        String email = "littleboy@outlook.com";
        Professeur Professeur = new Professeur(null, null, email);
        assertEquals(Professeur.getEmail(), email);
    }


    @Test
    public void testSetGetTelephone() {
        String telephone = "06 51 84 62 64";
        Professeur Professeur = new Professeur(null, null, null);
        Professeur.setTelephone(telephone);
        assertEquals(Professeur.getTelephone(), telephone);
    }


    @Test
    public void testGetTelephone() {
        String email = "littleboy@outlook.com";
        Professeur Professeur = new Professeur(null, null, email);
        assertEquals(Professeur.getEmail(), email);
    }


    @Test
    public void testSetNom() {
        String nom = "Dupont";
        String nouveauNom = "Dubois";
        Professeur Professeur = new Professeur(nom, null, null);
        Professeur.setNom(nouveauNom);
        assertEquals(Professeur.getNom(), nouveauNom);
    }


    @Test
    public void testSetPrenom() {
        String prenom = "Roger";
        String nouveauPrenom = "Jean";
        Professeur Professeur = new Professeur(null, prenom, null);
        Professeur.setPrenom(nouveauPrenom);
        assertEquals(Professeur.getPrenom(), nouveauPrenom);
    }


    @Test
    public void testSetEmail() {
        String email = "littleboy@outlook.com";
        String nouveauEmail = "bigBoy03@gmail.com";
        Professeur Professeur = new Professeur(null, null, email);
        Professeur.setEmail(nouveauEmail);
        assertEquals(Professeur.getEmail(), nouveauEmail);
    }
}
