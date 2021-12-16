package eu.telecomnancy.profrdv.client.model.data;

import java.util.List;

public class RDVList {
    public List<RendezVousData>  rendezVousList;

    public RDVList() {}

    public RDVList(List<RendezVousData>  rendezVousList) {
        this.rendezVousList = rendezVousList;
    }
}
