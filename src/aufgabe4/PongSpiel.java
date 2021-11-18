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
        rSpieler = new Spieler(spielfeld, 480, 490);
        lSpieler = new Spieler(spielfeld, 30, 40);
        ball = new Ball();
    }

    public void spielen() {
        while (true) {
            ib.abwischen();
            spielfeld.darstellen(ib);
            rSpieler.initalDraw(ib);
            lSpieler.initalDraw(ib);
            ball.bewegen((int)(System.currentTimeMillis() / FPMS));
        }
    }


}
