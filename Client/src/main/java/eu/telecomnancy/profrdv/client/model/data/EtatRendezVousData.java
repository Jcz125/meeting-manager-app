package eu.telecomnancy.profrdv.client.model.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum EtatRendezVousData {
    ANNULE,
    CONFIRME,
    DEMANDE,
    REALISE
}
