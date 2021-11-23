package aufgabe4.spiel;

import aufgabe4.spiel.util.Interaktionsbrett;

public class Ball {
    private Rechteck form;
    private int bewegungInYProFrame;
    private int bewegungInXProFrame;

    public Ball() {
        form = new Rechteck(270, 250, 10, 10);
        bewegungInXProFrame = -4;
        bewegungInYProFrame = -1;
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
        if (bewegungInXProFrame < 0) bewegungInXProFrame = 4;
        else bewegungInXProFrame = -4;
    }

    public void umkehrenDerBewegungInY() {
        if (bewegungInYProFrame < 0) bewegungInYProFrame = 1;
        else bewegungInYProFrame = -1;
    }

    public Rechteck getForm() {
        return form;
    }
}
