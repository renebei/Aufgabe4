package aufgabe4.spiel;

import aufgabe4.spiel.util.Interaktionsbrett;

public class Ball {
    private Rechteck form;
    private int bewegungInYProFrame;
    private int bewegungInXProFrame;

    public Ball() {
        form = new Rechteck(375, 300, 10, 10);
        bewegungInXProFrame = -7;
        bewegungInYProFrame = -3;
    }

    public void bewegen(long anzahlFrames) {
        for (int i = 0; i < anzahlFrames; i++) {
            form.verschiebe(bewegungInXProFrame, bewegungInYProFrame);
        }
    }

    public void darstellen(Interaktionsbrett ib) {
        form.darstellenFüllung(ib);
    }

    public void umkehrenDerBewegungInX() {
        if (bewegungInXProFrame < 0) bewegungInXProFrame = 7;
        else bewegungInXProFrame = -7;
    }

    public void umkehrenDerBewegungInY() {
        if (bewegungInYProFrame < 0) bewegungInYProFrame = 3;
        else bewegungInYProFrame = -3;
    }

    public Rechteck getForm() {
        return form;
    }
}
