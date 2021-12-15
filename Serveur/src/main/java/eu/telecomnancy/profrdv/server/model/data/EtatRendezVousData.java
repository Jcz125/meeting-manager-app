package eu.telecomnancy.profrdv.server.model.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum EtatRendezVousData {
    ANNULE,
    CONFIRME,
    DEMANDE,
    REALISE
}
