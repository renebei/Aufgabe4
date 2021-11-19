package aufgabe4;

import aufgabe4.spiel.Ball;
import aufgabe4.spiel.Rechteck;
import aufgabe4.spiel.Spieler;
import aufgabe4.spiel.Spielfeld;
import aufgabe4.spiel.util.Interaktionsbrett;

public class PongSpiel {

    private Spielfeld spielfeld;
    private Spieler rSpieler;
    private Spieler lSpieler;
    private Interaktionsbrett ib;
    private Ball ball;
    private final long FPMS = 17;

    public PongSpiel() {
        ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        startAufstellung();

    }

    private void startAufstellung() {
        spielfeld = new Spielfeld();
        rSpieler = new Spieler(spielfeld, 500, 190);
        lSpieler = new Spieler(spielfeld, 30, 190);
        ball = new Ball();
    }

    public void tasteGedrueckt(String s) {
        switch (s) {
            case "Oben":
                rSpieler.aufwaerts();
                break;
            case "Unten":
                rSpieler.abwaerts();
                break;
            case "a":
                lSpieler.aufwaerts();
                break;
            case "y":
                lSpieler.abwaerts();
                break;
            case "e":
                System.exit(1);
                break;
        }
    }

    public void spielen() {
        while (true) {
            ib.abwischen();
            spielfeld.darstellen(ib);
            rSpieler.initalDraw(ib);
            lSpieler.initalDraw(ib);
            ball.bewegen((int) (System.currentTimeMillis() / FPMS));
            if (System.currentTimeMillis() < FPMS) {
                try {
                    Thread.sleep(FPMS - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }
    }


}
