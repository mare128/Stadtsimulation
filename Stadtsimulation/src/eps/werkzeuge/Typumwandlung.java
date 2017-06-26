package eps.werkzeuge;


/**
 * Klasse Typumwandlung.
 * toDo: Klassenbeschreibung schreiben, Klasse
 * geeignet erweitern...
 * @author Ute Heuer 
 */
public class Typumwandlung {
    /*---------------Attribute-----*/


    /*---------------Konstruktor---*/
    public Typumwandlung() {
    }

    /*---------------Methoden------*/    
    /**
     * Liefert den Text als ganze Zahl, 
     * falls moeglich. null sonst.
     * 
     */
    public static Integer inGanzzahl(String text) {
        try {
            Integer i = Integer.parseInt(text);
            return i;
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    
}
