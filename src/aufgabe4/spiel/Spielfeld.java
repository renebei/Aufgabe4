package aufgabe4.spiel;

import aufgabe4.spiel.util.Interaktionsbrett;

import java.awt.*;

public class Spielfeld {

    private int hoehe = 600;
    private int breite = 750;
    private Rechteck spielflaeche;



    public Spielfeld() {
        this.spielflaeche = new Rechteck(20, 20, hoehe, breite);
    }

    public void darstellen(Interaktionsbrett ib) {
        spielflaeche.darstellenFeld(ib);

    }

    public Rechteck getSpielflaeche() {
        return spielflaeche;
    }
}
