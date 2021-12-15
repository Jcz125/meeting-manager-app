package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.data.UtilisateurData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController {
    @GetMapping("/utilisateur")
    public UtilisateurData getSalle(@RequestParam(value = "id") Integer id) {
        if (id == 0)
            return new UtilisateurData(id, "Bouthier", "Christophe", "littlegirl@gmail.com", "3630", false, 0, true, null, null);
        if (id == 1)
            return new UtilisateurData(id, "Oster", "Gérald", "littleboy@gmail.com", "3630", false, 0, true, null, null);
        return new UtilisateurData(id, "BG", "Clément", "jeff.bezos@amazon.com", "3630", false, 0, false, null, null);
    }

    /*@PostMapping("/ecole")
    public void setEcole(RequestEntity<Ecole> maSalleRequest) {
        this.maSalle = maSalleRequest.getBody();
    }*/
}

