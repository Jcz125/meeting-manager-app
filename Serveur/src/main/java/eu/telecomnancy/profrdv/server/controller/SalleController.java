package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.Salle;
import eu.telecomnancy.profrdv.server.model.data.SalleData;
import eu.telecomnancy.profrdv.server.model.data.UtilisateurData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Eleve;
import eu.telecomnancy.profrdv.server.model.utilisateur.Professeur;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SalleController {
    @Autowired
    SalleRepository salleRepository;

    @GetMapping("/salle")
    public SalleData getSalle(@RequestParam(value = "id") Integer id) {
        Optional<Salle> salle = salleRepository.findById(id);
        if (salle.isEmpty())
            return null;
        return salle.get().getData();
    }

    @PostMapping("/salle")
    public void createSalle(RequestEntity<SalleData> maSalle) {
        SalleData data = maSalle.getBody();
        Salle salle = new Salle(data);
        salleRepository.save(salle);
    }
}
