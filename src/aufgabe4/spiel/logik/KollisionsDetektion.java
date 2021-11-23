package aufgabe4.spiel.logik;

import aufgabe4.spiel.Ball;
import aufgabe4.spiel.Spieler;
import aufgabe4.spiel.Spielfeld;

import java.util.Random;

public class KollisionsDetektion {
    private Spielfeld spielfeld;
    private Spieler rSpieler;
    private Spieler lSpieler;

    public KollisionsDetektion(Spielfeld f, Spieler l, Spieler r) {
        spielfeld = f;
        rSpieler = r;
        lSpieler = l;
    }

    public void checkBeruehungBallMitSchleager(Ball ball) {
        if (ball.getForm().ueberschneidet(lSpieler.getSchlaeger()) || ball.getForm().ueberschneidet(rSpieler.getSchlaeger())) {
            ballRandom(ball);
        }
    }

    private void ballRandom(Ball ball) {
        Random rand = new Random();
        if ((rand.nextInt(100)+1) < 50) {
            ball.umkehrenDerBewegungInX();
        } else {
            ball.umkehrenDerBewegungInX();
            ball.umkehrenDerBewegungInY();
        }
    }

    public void checkBeruehungSpielfeld(Ball ball) {
        if (ball.getForm().oben() <= spielfeld.getSpielflaeche().oben() || ball.getForm().unten() >= spielfeld.getSpielflaeche().unten()) {
            ball.umkehrenDerBewegungInY();
        }
        if (ball.getForm().links() <= spielfeld.getSpielflaeche().links()) {
            ball.getForm().verschiebeNach(375, 300);
            ballRandom(ball);
            rSpieler.erhoehePunkte();
        }
        if (ball.getForm().rechts() >= spielfeld.getSpielflaeche().rechts()) {
            ball.getForm().verschiebeNach(375, 300);
            ballRandom(ball);
            lSpieler.erhoehePunkte();
        }
    }

}
