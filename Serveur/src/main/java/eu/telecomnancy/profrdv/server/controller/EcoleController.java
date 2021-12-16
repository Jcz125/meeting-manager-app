package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.Ecole;
import eu.telecomnancy.profrdv.server.model.Salle;
import eu.telecomnancy.profrdv.server.model.data.EcoleData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Eleve;
import eu.telecomnancy.profrdv.server.model.utilisateur.Professeur;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.EcoleRepository;
import eu.telecomnancy.profrdv.server.repository.SalleRepository;
import eu.telecomnancy.profrdv.server.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@RestController
public class EcoleController {
    @Autowired
    EcoleRepository ecoleRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    SalleRepository salleRepository;

    @GetMapping("/ecole")
    public EcoleData getEcole() {
        if (ecoleRepository.count() == 0) {
            Ecole monEcole = new Ecole("TELECOM Nancy");
            Professeur a = new Professeur("Bouthier", "Christophe", "littlegirl@gmail.com");
            Professeur b = new Professeur("Oster", "Gérald", "littleboy@gmail.com");
            Eleve c = new Eleve("BG", "Clément", "jeff.bezos@amazon.com");
            monEcole.addUtilisateur(a);
            monEcole.addUtilisateur(b);
            monEcole.addUtilisateur(c);
            Salle s = new Salle();
            s.setNumero(107);
            monEcole.addSalle(s);
            a.add(DayOfWeek.MONDAY, LocalTime.MIN, LocalTime.MAX);
            a.add(DayOfWeek.FRIDAY, LocalTime.MIN, LocalTime.MAX);
            Utilisateur[] l = {a, c};
            ArrayList<Utilisateur> list = new ArrayList<>(Arrays.asList(l));
            a.prendreRDV(list, s, LocalDateTime.of(2021, 12, 13, 12, 00), "Ma réu", "Test");
            a.prendreRDV(list, s, LocalDateTime.of(2021, 12, 13, 14, 00), "Ma réu plus tard", "Test");
            a.prendreRDV(list, s, LocalDateTime.of(2021, 12, 06, 12, 00), "Un autre lundi", "Test");
            a.prendreRDV(list, s, LocalDateTime.of(2021, 12, 10, 12, 00), "Un autre jour", "Test");
            ecoleRepository.save(monEcole);
            System.out.println(monEcole.getId());
        }
        Optional<Ecole> monEcole = ecoleRepository.findById(1);
        if (monEcole.isEmpty())
            return null;
        return monEcole.get().getData();
    }

    @PostMapping("/ecole/addUtilisateur")
    public void addUtilisateur(@RequestParam(value = "ecoleId") Integer ecoleId, @RequestParam(value = "userId") Integer userId) {
        Optional<Ecole> ecole = ecoleRepository.findById(ecoleId);
        if (ecole.isEmpty())
            return;
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(userId);
        if (utilisateur.isEmpty())
            return;
        ecole.get().addUtilisateur(utilisateur.get());
    }

    @PostMapping("/ecole/addSalle")
    public void addSalle(@RequestParam(value = "ecoleId") Integer ecoleId, @RequestParam(value = "salleId") Integer salleId) {
        Optional<Ecole> ecole = ecoleRepository.findById(ecoleId);
        if (ecole.isEmpty())
            return;
        Optional<Salle> salle = salleRepository.findById(salleId);
        if (salle.isEmpty())
            return;
        ecole.get().addSalle(salle.get());
    }


    /*@PostMapping("/ecole")
    public void setEcole(RequestEntity<Ecole> maSalleRequest) {
        this.maSalle = maSalleRequest.getBody();
    }*/
}

