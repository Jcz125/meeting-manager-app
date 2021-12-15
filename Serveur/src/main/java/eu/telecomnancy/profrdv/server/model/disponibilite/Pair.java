package eu.telecomnancy.profrdv.server.model.disponibilite;

import eu.telecomnancy.profrdv.server.model.data.DisponibiliteFixeData;
import eu.telecomnancy.profrdv.server.model.data.ModificateurDisponibiliteData;

import java.util.ArrayList;

public class Pair {
    DisponibiliteFixeData[] disponibiliteFixeData;
    ModificateurDisponibiliteData[] modificateurDisponibiliteData;


    protected Pair(int s1, int s2) {
        disponibiliteFixeData = new DisponibiliteFixeData[s1];
        modificateurDisponibiliteData = new ModificateurDisponibiliteData[s2];
    }


    protected void addDispo(ArrayList<DisponibiliteFixe> dispos, ArrayList<ModificateurDisponibilite> modifs) {
        for (int i = 0; i < disponibiliteFixeData.length; i++) {
            disponibiliteFixeData[i] = dispos.get(i).getData();
        }

        for (int i = 0; i < modificateurDisponibiliteData.length; i++) {
            modificateurDisponibiliteData[i] = modifs.get(i).getData();
        }
    }


    public DisponibiliteFixeData[] getDisponibiliteFixeData() {
        return disponibiliteFixeData;
    }


    public ModificateurDisponibiliteData[] getModificateurDisponibiliteData() {
        return modificateurDisponibiliteData;
    }
}
