package aufgabe4.spiel;

import aufgabe4.spiel.util.Interaktionsbrett;

public class Ball {
    private Rechteck form;
    private int bewegungInYProFrame;
    private int bewegungInXProFrame;

    public Ball() {
        form = new Rechteck(40, 40, 30, 30, 0);
        bewegungInXProFrame = 4;
        bewegungInYProFrame = 1;
    }

    public void bewegen(int anzahlFrames) {
        for (int i = 0; i < anzahlFrames; i++) {
            form.verschiebe(bewegungInXProFrame, bewegungInYProFrame);
        }
    }

    void darstellen(Interaktionsbrett ib) {
        form.darstellenFüllung(ib);
    }

    public void umkehrenDerBewegungInX() {
        bewegungInXProFrame = (bewegungInXProFrame > 0) ? -bewegungInXProFrame : bewegungInXProFrame;
    }

    public void umkehrenDerBewegungInY() {
        bewegungInYProFrame = (bewegungInYProFrame > 0) ? -bewegungInYProFrame : bewegungInYProFrame;
    }
}
