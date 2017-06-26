package eps.fortgeschritteneGrafik;

import java.awt.Shape;
import java.awt.Polygon;

import eps.fortgeschritteneGrafik.interna.Form;
import eps.fortgeschritteneGrafik.interna.Zeichenfenster;


/**
 * Objekte der Klasse Dreieck stellen einige einfache Dienste zum Darstellen von
 * gleichschenkligen Dreiecken auf dem Zeichenfenster bereit.
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public class Dreieck
        extends Form {

    /**
     * Erzeugt eine Dreieck mit Standardwerten auf dem Standardfenster
     */
    public Dreieck() {
        this(null);
    }
    
    public Dreieck(boolean anmelden, Zeichenfenster fenster) {
        super(anmelden, fenster);
    }

    /**
     * Es wird ein neues Dreieck mit den Standardeinstellungen erzeugt. Dieses
     * kann mit einem Zeichenfenster verbunden werden. Wird null eingegeben,
     * wird das Standardfenster verwendet. Das Dreieck ist gefuellt.
     */
    public Dreieck(Zeichenfenster fenster) {
        this(true, fenster);
    }

    /**
     * Technische Methode, die Zeichenfensterobjekte nutzen.
     */
    protected Shape formFuerFensterErzeugen() {
        int[] xPositionen = { 0, (int) standardBreite, (int) standardBreite / 2 };
        int[] yPositionen = { (int) standardHoehe, (int) standardHoehe, 0 };
        return new Polygon(xPositionen, yPositionen, 3);
    }
}
