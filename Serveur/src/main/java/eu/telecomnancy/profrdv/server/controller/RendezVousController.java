package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.Salle;
import eu.telecomnancy.profrdv.server.model.data.RechercheRDVData;
import eu.telecomnancy.profrdv.server.model.data.RendezVousData;
import eu.telecomnancy.profrdv.server.model.data.SalleData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.RendezVousRepository;
import eu.telecomnancy.profrdv.server.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.ui.context.support.UiApplicationContextUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RendezVousController {
    @Autowired
    RendezVousRepository rendezVousRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

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

    @PostMapping("/genererRendezVous")
    public List<RendezVous>  genererRendezVous(RequestEntity<RechercheRDVData> monRDV) {
        RechercheRDVData data = monRDV.getBody();

        List<Utilisateur> utilisateurs = new ArrayList<>();
        for (Integer id : data.utilisateursIds) {
            Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
            if (utilisateurOptional.isEmpty())
                return new ArrayList<>();
            utilisateurs.add(utilisateurOptional.get());
        }

        List<RendezVous> crenaux = RendezVous.genererRendezVous(utilisateurs, data.debut, data.fin);

        return crenaux;
    }
}
