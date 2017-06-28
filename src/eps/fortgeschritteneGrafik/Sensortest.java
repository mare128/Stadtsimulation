package eps.fortgeschritteneGrafik;

import eps.fortgeschritteneGrafik.interna.Zeichenfenster;

/**
 * Klasse Sensortest.
 * 
 * @author Ute Heuer
 * @version 0.1
 */
public class Sensortest
        extends Tastatursensor {

    public Sensortest() {
        super();
    }

    /**
     * @param fenster
     *            wenn das uebergebene Zeichenfenster angewaehlt ist (den Fokus
     *            hat), dann wird die Methode ausloesen bei Tastendruck
     *            gefeuert.
     */
    public Sensortest(Zeichenfenster fenster) {
        super(fenster);
    }

    public void beiDruckAusloesen(int taste) {
        System.out.println(taste);
    }
}
