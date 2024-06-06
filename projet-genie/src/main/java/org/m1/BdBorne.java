package org.m1;
import java.util.ArrayList;
import java.util.List;

public class BdBorne {
    private List<BorneDeRecharge> borneDeRecharge;

    public BdBorne() {
        this.borneDeRecharge = new ArrayList<>();
        initialiserBornesDeRecharge();
    }

    public List<BorneDeRecharge> getBornes(){
        return this.borneDeRecharge;
    }

    private void initialiserBornesDeRecharge() {
        // Créez et ajoutez vos bornes de recharge à la liste ici
        BorneDeRecharge borne1 = new BorneDeRecharge(1, "disponible");
        BorneDeRecharge borne2 = new BorneDeRecharge(2, "disponible");
        BorneDeRecharge borne3 = new BorneDeRecharge(3, "disponible");
        BorneDeRecharge borne4 = new BorneDeRecharge(4, "disponible");
        enregistrerBorne(borne1);
        enregistrerBorne(borne2);
        enregistrerBorne(borne3);
        enregistrerBorne(borne4);
    }

    public void enregistrerBorne(BorneDeRecharge Borne) {
        borneDeRecharge.add(Borne);
    }

    public int getSize(){
        return borneDeRecharge.size();
    }

    public BorneDeRecharge getBorne(int index) {
        return borneDeRecharge.get(index);
    }

    public BorneDeRecharge rechercherBorne(int id){
        for (BorneDeRecharge borne : borneDeRecharge) {
            if (borne.getId() == id) {
                return borne;
            }
        }
        return null;
    }

    public BorneDeRecharge trouverBorneDisponible() {
        for (BorneDeRecharge borne : borneDeRecharge) {
            if (borne.getEtat() == "disponible") {
                return borne;
            }
        }
        return null;
    }
}
