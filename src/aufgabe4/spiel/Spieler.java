package aufgabe4.spiel;

import aufgabe4.spiel.util.Interaktionsbrett;

public class Spieler {

    private Spielfeld spielfeld;
    private Rechteck schleager;
    private int punkte;

    public Spieler(Spielfeld s, int links, int rechts) {
        this.spielfeld = s;
        schleager = new Rechteck(links, rechts, s.getSpielflaeche().breite() / 100, s.getSpielflaeche().hoehe() / 10);
    }

    public void aufwaerts() {
        schleager.verschiebe(0, -30);
    }

    public void initalDraw(Interaktionsbrett ib) {
        schleager.darstellenFüllung(ib);
    }

    public void abwaerts() {
        schleager.verschiebe(0, 30);

    }

    public Rechteck getSchlaeger() {
        return schleager;
    }

    public void erhoehePunkte() {

    }

    public void saetzePunkteZurueck() {

    }
}
