package eu.telecomnancy.profrdv.server;

import eu.telecomnancy.profrdv.server.model.utilisateur.Eleve;
import org.junit.jupiter.api.Test;

import static eu.telecomnancy.junit.ReflectionAssertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EleveTest {

    @Test
    public void testSuperTypes() {
        Eleve eleve = new Eleve(null, null, null);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.utilisateur.Eleve", eleve);
        assertInstanceOf("eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur", eleve);
    }


    @Test
    public void testGetNom() {
        String nom = "Dupont";
        Eleve eleve = new Eleve(nom, null, null);
        assertEquals(eleve.getNom(), nom);
    }


    @Test
    public void testGetPrenom() {
        String prenom = "Roger";
        Eleve eleve = new Eleve(null, prenom, null);
        assertEquals(eleve.getPrenom(), prenom);
    }


    @Test
    public void testGetEmail() {
        String email = "littleboy@outlook.com";
        Eleve eleve = new Eleve(null, null, email);
        assertEquals(eleve.getEmail(), email);
    }


    @Test
    public void testSetGetTelephone() {
        String telephone = "06 51 84 62 64";
        Eleve eleve = new Eleve(null, null, null);
        eleve.setTelephone(telephone);
        assertEquals(eleve.getTelephone(), telephone);
    }


    @Test
    public void testGetTelephone() {
        String email = "littleboy@outlook.com";
        Eleve eleve = new Eleve(null, null, email);
        assertEquals(eleve.getEmail(), email);
    }


    @Test
    public void testSetNom() {
        String nom = "Dupont";
        String nouveauNom = "Dubois";
        Eleve eleve = new Eleve(nom, null, null);
        eleve.setNom(nouveauNom);
        assertEquals(eleve.getNom(), nouveauNom);
    }


    @Test
    public void testSetPrenom() {
        String prenom = "Roger";
        String nouveauPrenom = "Jean";
        Eleve eleve = new Eleve(null, prenom, null);
        eleve.setPrenom(nouveauPrenom);
        assertEquals(eleve.getPrenom(), nouveauPrenom);
    }


    @Test
    public void testSetEmail() {
        String email = "littleboy@outlook.com";
        String nouveauEmail = "bigBoy03@gmail.com";
        Eleve eleve = new Eleve(null, null, email);
        eleve.setEmail(nouveauEmail);
        assertEquals(eleve.getEmail(), nouveauEmail);
    }
}
