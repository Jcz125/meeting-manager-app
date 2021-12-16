package eu.telecomnancy.profrdv.server.model.data;

import java.util.List;

public class RDVList {
    List<RendezVousData>  rendezVousList;

    public RDVList() {}

    public RDVList(List<RendezVousData>  rendezVousList) {
        this.rendezVousList = rendezVousList;
    }
}
