package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.data.UtilisateurData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/utilisateur")
    public UtilisateurData getSalle(@RequestParam(value = "id") Integer id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isEmpty())
            return null;
        return utilisateur.get().getData();
    }

    /*@PostMapping("/ecole")
    public void setEcole(RequestEntity<Ecole> maSalleRequest) {
        this.maSalle = maSalleRequest.getBody();
    }*/
}

