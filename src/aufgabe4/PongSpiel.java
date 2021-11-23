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
    private boolean training;
    private boolean game;

    public PongSpiel() {
        ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        startAufstellung();

    }

    private void startAufstellung() {
        spielfeld = new Spielfeld();
        rSpieler = new Spieler(spielfeld, 740, 300);
        lSpieler = new Spieler(spielfeld, 50, 300);
        k = new KollisionsDetektion(spielfeld, lSpieler, rSpieler);
        ball = new Ball();
        training = false;
        game = false;

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
            case "t":
                training = !training;
                lSpieler.saetzePunkteZurueck();
                rSpieler.saetzePunkteZurueck();
                break;
            case "s":
                game = !game;
                break;
        }
    }

    public void spielen() {
        while (true) {
            ib.abwischen();
            if (!training) {
                ib.neuerText(340, 35, lSpieler.getPunkte());
                ib.neuerText(445, 35, rSpieler.getPunkte());
                if (rSpieler.getPunkte().equals("15") || lSpieler.getPunkte().equals("15")) break;
            }
            spielfeld.darstellen(ib);
            rSpieler.initalDraw(ib);
            lSpieler.initalDraw(ib);
            ball.darstellen(ib);
            try {
                Thread.sleep(FPMS);
            } catch (InterruptedException e) {

            }
            if (game) {
                ball.bewegen(1);
                k.checkBeruehungBallMitSchleager(ball);
                k.checkBeruehungSpielfeld(ball);
                if (training) lSpieler.moveBot(ball);
            }
        }
        ib.abwischen();
        ib.neuerText(375, 300, "Spiel beendet");
    }
}
