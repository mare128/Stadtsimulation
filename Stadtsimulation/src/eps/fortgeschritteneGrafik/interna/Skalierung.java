package eps.fortgeschritteneGrafik.interna;

/**
 * Implementiert eine Skalierungstransformation
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public class Skalierung
        extends Transformation {
    private double xZentrum;

    private double yZentrum;

    private double xFaktor;

    private double yFaktor;

    public Skalierung(double xFaktor, double yFaktor, double xZentrum,
            double yZentrum) {
        this.xZentrum = xZentrum;
        this.yZentrum = yZentrum;
        this.xFaktor = xFaktor;
        this.yFaktor = yFaktor;
        transformationGeben().translate(xZentrum, yZentrum);
        transformationGeben().scale(xFaktor, yFaktor);
        transformationGeben().translate(-xZentrum, -yZentrum);
    }

    public double xZentrumGeben() {
        return xZentrum;
    }

    public double yZentrumGeben() {
        return yZentrum;
    }

    public double xFaktorGeben() {
        return xFaktor;
    }

    public double yFaktorGeben() {
        return yFaktor;
    }
}
