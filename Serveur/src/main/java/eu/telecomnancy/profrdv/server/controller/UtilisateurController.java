package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.RendezVous;
import eu.telecomnancy.profrdv.server.model.Salle;
import eu.telecomnancy.profrdv.server.model.data.BooleanResult;
import eu.telecomnancy.profrdv.server.model.data.RendezVousData;
import eu.telecomnancy.profrdv.server.model.data.UtilisateurData;
import eu.telecomnancy.profrdv.server.model.utilisateur.Eleve;
import eu.telecomnancy.profrdv.server.model.utilisateur.Professeur;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.RendezVousRepository;
import eu.telecomnancy.profrdv.server.repository.SalleRepository;
import eu.telecomnancy.profrdv.server.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    SalleRepository salleRepository;

    @GetMapping("/utilisateur")
    public UtilisateurData getUtilisateur(@RequestParam(value = "id") Integer id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isEmpty())
            return null;
        return utilisateur.get().getData();
    }

    @PostMapping("/utilisateur")
    public Integer setUtilisateur(RequestEntity<UtilisateurData> monUtilisateur) {
        UtilisateurData data = monUtilisateur.getBody();
        data.id = null;
        Utilisateur utilisateur;
        if (data.estProf)
            utilisateur = new Professeur(data);
        else
            utilisateur = new Eleve(data);
        utilisateurRepository.save(utilisateur);
        return utilisateur.getId();
    }

    @PutMapping("/utilisateur")
    public void updateUtilisateur(RequestEntity<UtilisateurData> monUtilisateur) {
        UtilisateurData data = monUtilisateur.getBody();
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(data.id);
        if (utilisateur.isEmpty())
            return;
        utilisateur.get().updateData(monUtilisateur.getBody());
        utilisateurRepository.save(utilisateur.get());
    }

    @DeleteMapping("/utilisateur")
    public void deleteUtilisateur(@RequestParam(value = "id") Integer id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isEmpty())
            return;
        utilisateurRepository.delete(utilisateur.get());
    }

    @PostMapping("/utilisateur/prendreRDV")
    public BooleanResult prendreRDV(@RequestParam(value = "id") Integer userid, RequestEntity<RendezVousData> rendezVousEntity) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(userid);
        if (utilisateur.isEmpty())
            return new BooleanResult(false);
        Utilisateur monUtilisateur = utilisateur.get();
        RendezVousData data = rendezVousEntity.getBody();

        Optional<Salle> salle = salleRepository.findById(data.salle.numero);
        if (salle.isEmpty())
            return new BooleanResult(false);

        List<Utilisateur> utilisateurs = new ArrayList<>();
        for (Integer id: data.utilisateursIdsConfirmed.keySet()) {
            Optional<Utilisateur> user = utilisateurRepository.findById(id);
            if (user.isEmpty())
                return new BooleanResult(false);
            utilisateurs.add(user.get());
        }

        boolean result = monUtilisateur.prendreRDV(utilisateurs, salle.get(), data.horaire, data.titre, data.description);
        utilisateurRepository.save(monUtilisateur);
        return new BooleanResult(result);
    }
}

