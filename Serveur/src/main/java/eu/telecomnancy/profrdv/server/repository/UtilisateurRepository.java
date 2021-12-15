package eu.telecomnancy.profrdv.server.repository;

import eu.telecomnancy.profrdv.server.model.utilisateur.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>  {
}
