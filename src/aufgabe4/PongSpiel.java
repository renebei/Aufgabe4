package aufgabe4;

import aufgabe4.spiel.Ball;
import aufgabe4.spiel.Rechteck;
import aufgabe4.spiel.Spieler;
import aufgabe4.spiel.Spielfeld;
import aufgabe4.spiel.logik.KollisionsDetektion;
import aufgabe4.spiel.util.Interaktionsbrett;

public class PongSpiel {

    private Spielfeld spielfeld;
    private Spieler rSpieler;
    private Spieler lSpieler;
    private Interaktionsbrett ib;
    private Ball ball;
    private final long FPMS = 17;
    private KollisionsDetektion k;

    public PongSpiel() {
        ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        startAufstellung();

    }

    private void startAufstellung() {
        spielfeld = new Spielfeld();
        rSpieler = new Spieler(spielfeld, 480, 190);
        lSpieler = new Spieler(spielfeld, 50, 190);
        k = new KollisionsDetektion(spielfeld, lSpieler, rSpieler);
        ball = new Ball();

    }

    public void tasteGedrueckt(String s) {
        switch (s) {
            case "k":
                rSpieler.aufwaerts();
                break;
            case "m":
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
            ball.darstellen(ib);
            try {
                Thread.sleep(FPMS);
            } catch (InterruptedException e) {

            }
            ball.bewegen(1);
            k.checkBeruehungBallMitSchleager(ball);
            k.checkBeruehungSpielfeld(ball);
        }
    }
}
