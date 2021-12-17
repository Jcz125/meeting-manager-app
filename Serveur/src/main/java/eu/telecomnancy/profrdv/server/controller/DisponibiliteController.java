package eu.telecomnancy.profrdv.server.controller;

import eu.telecomnancy.profrdv.server.model.Salle;
import eu.telecomnancy.profrdv.server.model.data.DisponibiliteFixeData;
import eu.telecomnancy.profrdv.server.model.data.ModificateurDisponibiliteData;
import eu.telecomnancy.profrdv.server.model.data.SalleData;
import eu.telecomnancy.profrdv.server.model.disponibilite.DisponibiliteFixe;
import eu.telecomnancy.profrdv.server.model.disponibilite.ModificateurDisponibilite;
import eu.telecomnancy.profrdv.server.model.utilisateur.Professeur;
import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import eu.telecomnancy.profrdv.server.repository.DisponibiliteRepositoryFixe;
import eu.telecomnancy.profrdv.server.repository.ModificateurDisponibiliteRepository;
import eu.telecomnancy.profrdv.server.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@RestController
public class DisponibiliteController {
    @Autowired
    DisponibiliteRepositoryFixe disponibiliteRepositoryFixe;
    @Autowired
    ModificateurDisponibiliteRepository modificateurDisponibiliteRepository;

    @GetMapping("/dispofixe")
    public DisponibiliteFixeData getDispoFixe(@RequestParam(value = "id") Integer id) {
        Optional<DisponibiliteFixe> disponibiliteFixe = disponibiliteRepositoryFixe.findById(id);
        if (disponibiliteFixe.isEmpty())
            return null;
        return disponibiliteFixe.get().getData();
    }

    @PostMapping("/dispofixe")
    public Integer ajouterDispoFixe(RequestEntity<DisponibiliteFixeData> dispoData) {
        DisponibiliteFixe dispo = new DisponibiliteFixe(dispoData.getBody());
        disponibiliteRepositoryFixe.save(dispo);
        return dispo.getId();
    }

    @PutMapping("/dispofixe")
    public void updateDispoFixe(RequestEntity<DisponibiliteFixeData> dispoData) {
        DisponibiliteFixeData data = dispoData.getBody();
        Optional<DisponibiliteFixe> dispo = disponibiliteRepositoryFixe.findById(data.id);
        if (dispo.isEmpty())
            return;
        dispo.get().updateData(data);
        disponibiliteRepositoryFixe.save(dispo.get());
    }

    @DeleteMapping("/dispofixe")
    public void deleteDispoFixe(@RequestParam(value = "id") Integer id) {
        Optional<DisponibiliteFixe> dispo = disponibiliteRepositoryFixe.findById(id);
        if (dispo.isEmpty())
            return;
        disponibiliteRepositoryFixe.delete(dispo.get());
    }




    @GetMapping("/modifdispo")
    public ModificateurDisponibiliteData getMofifDispo(@RequestParam(value = "id") Integer id) {
        Optional<ModificateurDisponibilite> modifDispo = modificateurDisponibiliteRepository.findById(id);
        if (modifDispo.isEmpty())
            return null;
        return modifDispo.get().getData();
    }

    @PostMapping("/modifdispo")
    public Integer ajouterMofifDispo(RequestEntity<ModificateurDisponibiliteData> dispoData) {
        ModificateurDisponibilite dispo = new ModificateurDisponibilite(dispoData.getBody());
        modificateurDisponibiliteRepository.save(dispo);
        return dispo.getId();
    }

    @PutMapping("/modifdispo")
    public void updateMofifDispo(RequestEntity<ModificateurDisponibiliteData> dispoData) {
        ModificateurDisponibiliteData data = dispoData.getBody();
        Optional<ModificateurDisponibilite> dispo = modificateurDisponibiliteRepository.findById(data.id);
        if (dispo.isEmpty())
            return;
        dispo.get().updateData(data);
        modificateurDisponibiliteRepository.save(dispo.get());
    }

    @DeleteMapping("/modifdispo")
    public void deleteMofifDispo(@RequestParam(value = "id") Integer id) {
        Optional<ModificateurDisponibilite> dispo = modificateurDisponibiliteRepository.findById(id);
        if (dispo.isEmpty())
            return;
        modificateurDisponibiliteRepository.delete(dispo.get());
    }
}
