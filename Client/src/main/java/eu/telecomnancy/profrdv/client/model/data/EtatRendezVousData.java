package eu.telecomnancy.profrdv.client.model.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum EtatRendezVousData {
    ANNULE,
    CONFIRME,
    DEMANDE,
    REALISE;

    @Override
    public String toString() {
        switch (this) {
            case ANNULE -> {
                return "Annulé";
            }
            case DEMANDE -> {
                return "Demandé";
            }
            case REALISE -> {
                return "Réalisé";
            }
            case CONFIRME -> {
                return "Confirmé";
            }
        }
        return "";
    }
}
