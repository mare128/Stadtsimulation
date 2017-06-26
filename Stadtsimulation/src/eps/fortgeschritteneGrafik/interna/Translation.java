package eps.fortgeschritteneGrafik.interna;

/**
 * Implementiert eine Translationstransformation
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public class Translation
        extends Transformation {
    private double xVerschiebung;

    private double yVerschiebung;

    public Translation(double xVerschiebung, double yVerschiebung) {
        this.xVerschiebung = xVerschiebung;
        this.yVerschiebung = yVerschiebung;
        transformationGeben().translate(xVerschiebung, yVerschiebung);
    }

    public double xVerschiebungGeben() {
        return xVerschiebung;
    }

    public double yVerschiebungGeben() {
        return yVerschiebung;
    }
}
