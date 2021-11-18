package aufgabe4.spiel;

import aufgabe4.spiel.util.Interaktionsbrett;

public class Rechteck {
    private int x;
    private int y;
    private int hoehe;
    private int breite;


    public Rechteck(int x, int y, int hoehe, int breite) {
        this.x = x;
        this.y = y;
        this.hoehe = hoehe;
        this.breite = breite;
    }

    public int oben() {
        return y;
    }

    public int unten() {
        return y + hoehe;
    }

    public int links() {
        return x;
    }

    public int rechts() {
        return x + breite;
    }

    public int hoehe() {
        return hoehe;
    }

    public int breite() {
        return breite;
    }

    public void darstellenFuellung(Interaktionsbrett ib) {
        //Linien zwischen das Quadrat
        ib.neuesRechteck(links(), rechts(), oben(), unten());
        for (int i = 0; i < breite; i++) {
            ib.neueLinie(x, y + i, x + breite, y + i);
        }
    }

    public void verschiebe() {

    }
}
