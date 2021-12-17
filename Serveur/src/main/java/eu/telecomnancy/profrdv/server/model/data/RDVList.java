package eu.telecomnancy.profrdv.server.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class RDVList {
    public RendezVousData[]  rendezVousList;

    public RDVList() {}

    public RDVList(RendezVousData[]  rendezVousList) {
        this.rendezVousList = rendezVousList;
    }
}
