package aufgabe4.spiel;

import aufgabe4.spiel.util.Interaktionsbrett;

public class Spieler {

    private Spielfeld spielfeld;
    private Rechteck schleager;
    private int punkte;

    public Spieler(Spielfeld s, int x, int y) {
        this.spielfeld = s;
        schleager = new Rechteck(x, y, s.getSpielflaeche().hoehe() / 10, s.getSpielflaeche().breite() / 100);
    }

    public void aufwaerts() {
        schleager.verschiebe(0, -52);
        if (schleager.oben() < spielfeld.getSpielflaeche().oben()) abwaerts();

    }

    public void initalDraw(Interaktionsbrett ib) {
        schleager.darstellenFüllung(ib);
    }

    public void abwaerts() {
        schleager.verschiebe(0, 52);
        if (schleager.unten() > spielfeld.getSpielflaeche().unten()) aufwaerts();

    }

    public Rechteck getSchlaeger() {
        return schleager;
    }

    public void erhoehePunkte() {
        this.punkte++;
    }

    public void saetzePunkteZurueck() {
        this.punkte = 0;
    }

    public String getPunkte() {
        return String.valueOf(punkte);
    }

    public void moveBot(Ball ball) {
        if (ball.getForm().mitteInY() < spielfeld.getSpielflaeche().mitteInY())
            schleager.verschiebeNach(schleager.links(), ball.getForm().mitteInY());
        else
            schleager.verschiebeNach(schleager.links(), ball.getForm().mitteInY() - schleager.hoehe());

    }
}
