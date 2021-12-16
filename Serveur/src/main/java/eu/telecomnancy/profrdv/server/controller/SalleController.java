package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.Salle;
import eu.telecomnancy.profrdv.server.model.data.SalleData;
import eu.telecomnancy.profrdv.server.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

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
    public Integer createSalle(RequestEntity<SalleData> maSalle) {
        SalleData data = maSalle.getBody();
        Salle salle = new Salle(data);
        salleRepository.save(salle);
        return salle.getNumero();
    }

    @PutMapping("/salle")
    public void updateSalle(RequestEntity<SalleData> maSalle) {
        SalleData data = maSalle.getBody();
        Optional<Salle> salle = salleRepository.findById(data.numero);
        if (salle.isEmpty())
            return;
        salle.get().updateData(data);
        salleRepository.save(salle.get());
    }
}
