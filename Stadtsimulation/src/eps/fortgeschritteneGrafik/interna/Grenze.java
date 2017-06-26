package eps.fortgeschritteneGrafik.interna;

/**
 * Die Grenzen des Ueberdeckenden Rechtecks einer Grafik
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public class Grenze {
    /**
     * Der Aufpunkt
     */
    private double x;

    /**
     * Der Aufpunkt
     */
    private double y;

    /**
     * Die Breite des Rechtecks
     */
    private double breite;

    /**
     * Die Hoehe des Rechtecks
     */
    private double hoehe;

    /**
     * Erzeugt eine neue Grenze
     */
    public Grenze(double x, double y, double breite, double hoehe) {
        this.x = x;
        this.y = y;
        this.breite = breite;
        this.hoehe = hoehe;
    }

    /**
     * Liefert den Aufpunkt
     */
    public double xGeben() {
        return x;
    }

    /**
     * Liefert den Aufpunkt
     */
    public double yGeben() {
        return y;
    }

    /**
     * Liefert die Breite des Rechtecks
     */
    public double breiteGeben() {
        return breite;
    }

    /**
     * Liefert die Hoehe des Rechtecks
     */
    public double hoeheGeben() {
        return hoehe;
    }
}
