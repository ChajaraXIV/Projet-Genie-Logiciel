package org.m1;
public class BorneDeRecharge {
    private int id;
    private String Etat;

    public BorneDeRecharge(int id, String Etat) {
        this.id = id;
        this.Etat = Etat;
    }

    public int getId() {
        return id;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }
}
