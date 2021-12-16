package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.Salle;
import eu.telecomnancy.profrdv.server.model.data.RendezVousData;
import eu.telecomnancy.profrdv.server.model.data.SalleData;
import eu.telecomnancy.profrdv.server.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RendezVousController {
    @Autowired
    RendezVousRepository rendezVousRepository;

    @GetMapping("/rdv")
    public RendezVousData getRendezVous(@RequestParam(value = "id") Integer id) {
        Optional<RendezVous> rendezVous = rendezVousRepository.findById(id);
        if (rendezVous.isEmpty())
            return null;
        return rendezVous.get().getData();
    }

    @PostMapping("/rdv")
    public void createRDV(RequestEntity<RendezVousData> monRDV) {
        RendezVousData data = monRDV.getBody();
        RendezVous rdv = new RendezVous(data);
        rendezVousRepository.save(rdv);
    }
}
