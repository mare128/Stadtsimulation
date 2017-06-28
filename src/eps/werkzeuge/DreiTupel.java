package eps.werkzeuge;

//: net/mindview/util/ThreeTuple.java
// aus dem Buch B. Eckel: Thinking in Java
// Uebersetzung und Auswahl: U. Heuer
/**
 * Die Klasse DreiTupel wird typischerweise verwendet, wenn ein Dienst drei
 * Werte zurueckgeben moechte. Alle Komponenten koennen hoechstens
 * einmal mit einem Wert belegt werden. Komponenten wurden veroeffentlicht, um
 * diese leicht auslesen zu koennen. Hier liegt keine Verletzung des
 * Geheimnisprinzips vor. Das zu verstehen ist jedoch nicht Lernziel der
 * 10.Klasse. Deshalb bietet die Klasse DreiTupel zusaetzlich noch Dienste zum
 * Auslesen der Komponenten an. So muss in der 10.Klasse nicht thematisiert
 * werden, warum nur im speziellen Fall der Klasse DreiTupel, ein Zugriff auf
 * Attribute erlaubt ist.
 * 
 * siehe auch net/mindview/util/TwoTuple.java
 * aus dem Buch B. Eckel: Thinking in Java
 * Uebersetzung und Auswahl: U. Heuer
 * 
 * @version 02.2008
 */
public class DreiTupel<A, B, C>
        extends ZweiTupel<A, B> {
    /**
     * Dritte Komponente final heisst: wurde dem Attribut einmal ein Objekt des
     * Typs C zugewiesen, kann kein anderes mehr gesetzt werden. Anmerkung: Der
     * Zustand des Objekts "dritte" (Komponente) kann geaendert werden, sofern
     * das Objekt dazu entsprechende Dienste bereitstellt.
     */
    public final C dritte;

    public DreiTupel(A a, B b, C c) {
        super(a, b);
        dritte = c;
    }

    @Override
	public String toString() {
        return "(" + erste + ", " + zweite + ", " + dritte + ")";
    }

    /**
     * Lesenden Zugriff via Dienst dritteGeben auf unsere dritte Komponenten
     * bereitstellen.
     */
    public C dritteGeben() {
        return dritte;
    }
}
