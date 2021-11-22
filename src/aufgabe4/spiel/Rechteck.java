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

    public Rechteck(Rechteck r) {
        this.x = r.x;
        this.y = r.y;
        this.hoehe = r.hoehe;
        this.breite = r.breite;
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

    public int mitteInY() {
        return (hoehe / 2 + y);
    }

    public int mitteInX() {
        return (breite / 2 + x);
    }

    public void verschiebe(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void verschiebeNach(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean ueberschneidet(Rechteck r) {
        return x < r.x + r.breite && x + breite > r.x && y < r.y + r.hoehe && y + hoehe > r.y;
    }

    public void darstellenFeld(Interaktionsbrett ib) {
        //Linien zwischen das Quadrat
        ib.neuesRechteck(links(), oben(), breite(), hoehe());
        ib.neueLinie(mitteInX(), oben(), mitteInX(), unten());
    }

    public void darstellenFüllung(Interaktionsbrett ib) {
        for (int i = 0; i < hoehe; i++) {
            ib.neueLinie(links() + i, oben(), links() + i, y + breite());
        }
    }
}
