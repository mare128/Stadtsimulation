package eps.werkzeuge;

import java.awt.Component;
/**
 * Interface Fenster
 * 
 * @author Ute Heuer 
 * @version 0.1
 */

public interface Fenster {
    /**
     * Kann aufgerufen werden, wenn eine Anbindung an einen Dialog 
     * gewuenscht wird. Z.B. fuer den Dienst speichern der in der Klasse
     * Textdatei definiert ist.
     * 
     * @return eine Komponente des Fensters, typischerweise ein JFrame oder ein Canvas 
     */
    Component verknuepfungGeben();
}
