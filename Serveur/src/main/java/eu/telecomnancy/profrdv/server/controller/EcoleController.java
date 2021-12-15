package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.Ecole;
import eu.telecomnancy.profrdv.server.model.data.EcoleData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoleController {
    private Ecole monEcole = null;

    @GetMapping("/ecole")
    public EcoleData getEcole() {
        if (monEcole == null) {
            monEcole = new Ecole("TELECOM Nancy");
            monEcole.addUtilisateur(0);
            monEcole.addUtilisateur(1);
            monEcole.addUtilisateur(2);
        }
        return monEcole.getData();
    }

    /*@PostMapping("/ecole")
    public void setEcole(RequestEntity<Ecole> maSalleRequest) {
        this.maSalle = maSalleRequest.getBody();
    }*/
}

