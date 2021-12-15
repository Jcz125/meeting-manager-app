package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.Ecole;
import eu.telecomnancy.profrdv.server.model.data.EcoleData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Eleve;
import eu.telecomnancy.profrdv.server.model.utilisateur.Professeur;
import eu.telecomnancy.profrdv.server.repository.EcoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EcoleController {
    @Autowired
    EcoleRepository ecoleRepository;

    @GetMapping("/ecole")
    public EcoleData getEcole() {
        if (ecoleRepository.count() == 0) {
            Ecole monEcole = new Ecole("TELECOM Nancy");
            monEcole.addUtilisateur(new Professeur("Bouthier", "Christophe", "littlegirl@gmail.com"));
            monEcole.addUtilisateur(new Professeur("Oster", "Gérald", "littleboy@gmail.com"));
            monEcole.addUtilisateur(new Eleve("BG", "Clément", "jeff.bezos@amazon.com"));
            ecoleRepository.save(monEcole);
            System.out.println(monEcole.getId());
        }
        Optional<Ecole> monEcole = ecoleRepository.findById(1);
        if (monEcole.isEmpty())
            return null;
        return monEcole.get().getData();
    }

    /*@PostMapping("/ecole")
    public void setEcole(RequestEntity<Ecole> maSalleRequest) {
        this.maSalle = maSalleRequest.getBody();
    }*/
}

