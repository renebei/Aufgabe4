package aufgabe4.spiel;

import aufgabe4.spiel.util.Interaktionsbrett;

public class Spieler {

    private Spielfeld spielfeld;
    private Rechteck schleager;
    private int punkte;

    public Spieler(Spielfeld s, int links, int rechts) {
        this.spielfeld = s;
        schleager = new Rechteck(links, rechts,s.getSpielflaeche().hoehe() / 10, s.getSpielflaeche().breite() / 100);
    }

    public void aufwaerts() {
        schleager.verschiebe(0, -33);
        if (schleager.oben()<spielfeld.getSpielflaeche().oben()) abwaerts();

    }

    public void initalDraw(Interaktionsbrett ib) {
        schleager.darstellenFüllung(ib);
    }

    public void abwaerts() {
        schleager.verschiebe(0, 33);
        if (schleager.unten()>spielfeld.getSpielflaeche().unten()) aufwaerts();

    }

    public Rechteck getSchlaeger() {
        return schleager;
    }

    public void erhoehePunkte() {

    }

    public void saetzePunkteZurueck() {

    }
}
