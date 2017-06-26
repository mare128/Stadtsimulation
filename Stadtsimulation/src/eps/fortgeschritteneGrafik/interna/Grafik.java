package eps.fortgeschritteneGrafik.interna;


import java.awt.Graphics2D;

/**
 * Abstrakte Klasse Grafik - Dienste, die alle Grafiken zum Darstellen auf einem
 * Zeichenfenster anbieten, werden festgelegt
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public abstract class Grafik {
    /**
     * Der Wert, der zum Zeitpunkt der Erzeugung eingenommen wird.
     */
    protected double standardBreite;

    /**
     * Der Wert, der zum Zeitpunkt der Erzeugung eingenommen wird.
     */
    protected double standardHoehe;

    /**
     * Zaehlt die Identifikationsnummern der Grafiken. Entspricht ihrer
     * Gesamtanzahl
     */
    private static int idzaehler;

    /**
     * Die eindeutige ID der Grafik
     */
    private int id;

    /**
     * Das Zeichenfenster, welches wir zur Darstellung der Grafik benutzen
     */
    private Zeichenfenster zeichenfenster;

    /**
     * x-Koordinate der linken oberen Ecke des die Grafik ueberdeckenden
     * (waagrecht ausgerichteten) Rechtecks
     */
    private double xPosition;

    /**
     * y-Koordinate der linken oberen Ecke des die Grafik ueberdeckenden
     * (waagrecht ausgerichteten) Rechtecks
     */
    private double yPosition;

    /**
     * Breite des, die Grafik ueberdeckenden (waagrecht ausgerichteten) Rechtecks
     */
    private double breite;

    /**
     * Hoehe des, die Grafik ueberdeckenden (waagrecht ausgerichteten) Rechtecks
     */
    private double hoehe;

    /**
     * Speichert die bisherigen Transformationen
     */
    private TransformationsSpeicher transformationen;
    
    public Grafik(boolean anmelden, 
            Zeichenfenster fenster) {
        xPosition = 0;
        yPosition = 0;

        id = idzaehler++;
        transformationen = new TransformationsSpeicher();
        if (fenster == null) {
            zeichenfenster = Zeichenfenster.zeichenfensterGeben();
        } else {
            zeichenfenster = fenster;
        }
        if (anmelden)
            zeichenfenster.grafikHinzufuegen(this);
    }

    /**
     * Liefert einen Zeiger auf das Zeichenfenster der Grafik
     */
    public Zeichenfenster fensterGeben() {
        return zeichenfenster;
    }

    /**
     * Fuegt die Grafik dem Zeichenfenster hinzu. Ruft der Nutzer den Dienst
     * zeichnen() des Zeichenfensters auf, wird die Grafik vor alle bisherigen
     * Grafiken gezeichnet.
     */
    public void anmelden() {
        zeichenfenster.grafikHinzufuegen(this);
    }

    /**
     * Entfernt unsere Grafikreferenz aus der Liste des Zeichenfensters.
     */
    public void abmelden() {
        zeichenfenster.grafikEntfernen(this);
    }

    /**
     * Veraendert den Aufpunkt der Grafik. Der Aufpunkt ist die linke obere Ecke
     * des die Grafik ueberdeckenden (waagrecht ausgerichteten) Rechtecks.
     */
    public void positionSetzen(int neueXPosition, int neueYPosition) {
        double xDifferenz = (double) neueXPosition - xPosition;
        double yDifferenz = (double) neueYPosition - yPosition;
        verschieben((int) xDifferenz, (int) yDifferenz);
    }

    /**
     * Wird von Grafikunterklasseobjekten intern genutzt.
     * Liefert die bisherigen Transformationen.
     */
    protected TransformationsSpeicher transformationenGeben() {
        return transformationen;
    }

    /**
     * Breite und Hoehe der Grafik koennen gewaehlt werden. Nicht
     * positive (unsinnige) Angaben werden automatisch auf den kleinsten
     * noch sinnvollen Wert fuer eine Grafik gesetzt, hier 1. Die Grafik ist dann
     * entsprechend auf dem Zeichenfenster zu sehen.
     */
    public void groesseSetzen(int neueBreite, int neueHoehe) {
        double nB, nH;
        nB = neueBreite;
        nH = neueHoehe;
        if (nB < 1) {
            nB = 1;
        }
        if (nH < 1) {
            nH = 1;
        }
//         if (!(neueBreite > 0 && neueHoehe > 0))
//             return;
        if (breite == 0 && hoehe == 0) {// falls noch nicht initialisiert wurde, dies jetzt tun
            breite = nB;
            hoehe = nH;
            return;
        } else {
            double xFaktor = nB / breite;
            double yFaktor = nH / hoehe;
            verzerrenAn(xPosition, yPosition, xFaktor, yFaktor);
        }
    }

    /**
     * Streckt die Grafik um den gegebenen Faktor an dem gegebenen Zentrum.
     * Negative Streckfaktoren werden hier ignoriert. Verwenden Sie bei Bedarf erst
     * eine Drehung und strecken Sie dann...
     */
    public void streckenAn(int xZentrum, int yZentrum, double faktor) {
        if (faktor < 0)
            return;
        transformationen.transformationHinzufuegen(new Skalierung(faktor,
                faktor, (double) xZentrum, (double) yZentrum));
        grenzenAktualisieren();
    }

    /**
     * Liest die Breite der Grafik aus.
     */
    public int breiteGeben() {
        return (int) Math.rint(breite);
    }

    /**
     * Liest die Hoehe der Grafik aus.
     */
    public int hoeheGeben() {
        return (int) Math.rint(hoehe);
    }

    /**
     * Liest die x-Koordinate der Position (linke obere Ecke des die Grafik
     * ueberdeckenden Rechtecks) aus.
     */
    public int xPositionGeben() {
        return (int) Math.rint(xPosition);
    }

    /**
     * Liest die y-Koordinate der Position (linke obere Ecke des die Grafik
     * ueberdeckenden Rechtecks) aus.
     */
    public int yPositionGeben() {
        return (int) Math.rint(yPosition);
    }

    /**
     * Verschiebt die Grafik um deltaX in x-Richtung und um deltaY in
     * y-Richtung.
     */
    public void verschieben(int deltaX, int deltaY) {
        transformationen.transformationHinzufuegen(new Translation(
                (double) deltaX, (double) deltaY));
        grenzenAktualisieren();
    }

    /**
     * Vergleicht zwei Grafiken. Grafikek sind gleich, wenn ihre IDs identisch
     * sind.
     */
    public boolean equals(Object o) {
        return (o instanceof Grafik) && ((Grafik) o).idGeben() == id;
    }

    /**
     * Unsere einfache "Visitenkarte": unser Klassenname gefolgt von
     * interessanten Attributwerten
     */
    public String toString() {
        return "ein " + getClass().getSimpleName() + " - Aufpunkt: (" + xPositionGeben() + ", "
                + yPositionGeben() + ")" + " - Groesse: " + breiteGeben() + " X "
                + hoeheGeben();
    }



    /**
     * Die Methode drehen dreht die Vektorgrafik relativ um den uebergebenen
     * Winkel.
     */
    public void drehenUm(int xDrehpunkt, int yDrehpunkt, int winkel) {
        transformationen.transformationHinzufuegen(new Rotation(
                (double) xDrehpunkt, (double) yDrehpunkt, winkel));
        grenzenAktualisieren();
    }



    /**
     * Liefert die ID der Grafik. Wird von der equals()-Methode aufgerufen
     */
    int idGeben() {
        return id;
    }



    /**
     * Nur das Zeichenfenster, bei dem diese Grafik registriert ist, nutzt den
     * Dienst zeichnenAuf. Grafikobjekte werden angestossen, sich selbst passend
     * im Fenster zu zeichnen.
     */
    protected abstract void zeichnenAuf(Graphics2D zeichnung);

    /**
     * Bringt die Koordinaten nach einer Transformation auf den aktuellen Stand
     */
    private void grenzenAktualisieren() {
        Grenze g = transformationen.aktuelleGrenzenGeben(standardBreite,
                standardHoehe);
        xPosition = g.xGeben();
        yPosition = g.yGeben();
        breite = g.breiteGeben();
        hoehe = g.hoeheGeben();
    }

    /**
     * Verzerrt die Grafik (fuer groesseSetzen())
     */
    private void verzerrenAn(double xZentrum, double yZentrum, double xFaktor,
            double yFaktor) {
        if (xFaktor < 0 || yFaktor < 0)
            return;
        transformationen.transformationHinzufuegen(new Skalierung(xFaktor,
                yFaktor, xZentrum, yZentrum));
        grenzenAktualisieren();
    }
}
