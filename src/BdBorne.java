import java.util.ArrayList;
import java.util.List;

public class BdBorne {
    private List<BorneDeRecharge> borneDeRecharge;

    public BdBorne() {
        this.borneDeRecharge = new ArrayList<>();
        initialiserBornesDeRecharge();
    }

    private void initialiserBornesDeRecharge() {
        // Créez et ajoutez vos bornes de recharge à la liste ici
        BorneDeRecharge borne1 = new BorneDeRecharge(1, true);
        BorneDeRecharge borne2 = new BorneDeRecharge(2, true);
        BorneDeRecharge borne3 = new BorneDeRecharge(3, true);
        BorneDeRecharge borne4 = new BorneDeRecharge(4, true);
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

    public BorneDeRecharge trouverBorneDisponible() {
        for (BorneDeRecharge borne : borneDeRecharge) {
            if (borne.isDisponible() == true) {
                return borne;
            }
        }
        return null;
    }
}
