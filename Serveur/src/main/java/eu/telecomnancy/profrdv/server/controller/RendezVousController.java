package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.data.RDVList;
import eu.telecomnancy.profrdv.server.model.data.RechercheRDVData;
import eu.telecomnancy.profrdv.server.model.data.RendezVousData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.RendezVousRepository;
import eu.telecomnancy.profrdv.server.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

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
    public Integer createRDV(RequestEntity<RendezVousData> monRDV) {
        RendezVousData data = monRDV.getBody();
        RendezVous rdv = new RendezVous(data);
        rendezVousRepository.save(rdv);
        return rdv.getId();
    }

    @PutMapping("/rdv")
    public void updateRDV(RequestEntity<RendezVousData> monRDV) {
        RendezVousData data = monRDV.getBody();
        Optional<RendezVous> rendezVous = rendezVousRepository.findById(data.id);
        if (rendezVous.isEmpty())
            return;
        rendezVous.get().updateData(data);
        rendezVousRepository.save(rendezVous.get());
    }

    @DeleteMapping("/rdv")
    public void deleteRendezVous(@RequestParam(value = "id") Integer id) {
        Optional<RendezVous> rendezVous = rendezVousRepository.findById(id);
        if (rendezVous.isEmpty())
            return;
        if (rendezVous.get().peutEtreSupprimer())
            rendezVousRepository.delete(rendezVous.get());
    }

    @PostMapping("/rdv/confirmer")
    public void confirmerdv(@RequestParam(value = "userid") Integer userid, @RequestParam(value = "rdvid") Integer rdvid) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(userid);
        if (utilisateur.isEmpty())
            return;
        Optional<RendezVous> rdv = rendezVousRepository.findById(rdvid);
        if (rdv.isEmpty())
            return;
        rdv.get().confirme(utilisateur.get());
        rendezVousRepository.save(rdv.get());
    }

    @PostMapping("/genererRendezVous")
    public RDVList genererRendezVous(RequestEntity<RechercheRDVData> monRDV) {
        RechercheRDVData data = monRDV.getBody();

        List<Utilisateur> utilisateurs = new ArrayList<>();
        for (Integer id : data.utilisateursIds) {
            Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
            if (utilisateurOptional.isEmpty())
                return new RDVList(new RendezVousData[0]);
            utilisateurs.add(utilisateurOptional.get());
        }

        List<RendezVous> crenaux = RendezVous.genererRendezVous(utilisateurs, data.debut, data.fin);

        List<RendezVousData> rendezVousList = new ArrayList<>(crenaux.size());
        for (RendezVous rdv : crenaux) {
            rendezVousList.add(rdv.getData());
        }

        return new RDVList(rendezVousList.toArray(new RendezVousData[0]));
    }

    @PostMapping("/rdv/annuler")
    public void annulerRendezVous(@RequestParam(value = "id") Integer id) {
        Optional<RendezVous> rendezVous = rendezVousRepository.findById(id);
        if (rendezVous.isEmpty())
            return;
        RendezVous rdv = rendezVous.get();
        rdv.annuler();
        rendezVousRepository.save(rdv);
    }
}
