package eps.werkzeuge;

//: net/mindview/util/TwoTuple.java
// aus dem Buch B. Eckel: Thinking in Java
// Uebersetzung und Auswahl: U. Heuer
/**
 * Die Klasse ZweiTupel wird typischerweise verwendet, wenn ein Dienst zwei
 * Werte zurueckgeben moechte. Beide Komponenten koennen hoechstens
 * einmal mit einem Wert belegt werden. Beide Komponenten wurden
 * veroeffentlicht, um diese leicht auslesen zu koennen. Hier liegt keine
 * Verletzung des Geheimnisprinzips vor. Das zu verstehen ist jedoch nicht
 * Lernziel der 10.Klasse. Deshalb bietet die Klasse ZweiTupel zusaetzlich noch
 * Dienste zum Auslesen der Komponenten an. So muss in der 10.Klasse nicht
 * thematisiert werden, warum nur im speziellen Fall der Klasse ZweiTupel, ein
 * Zugriff auf Attribute erlaubt ist.
 * 
 * siehe auch net/mindview/util/TwoTuple.java
 * aus dem Buch B. Eckel: Thinking in Java
 * Uebersetzung und Auswahl: U. Heuer
 * 
 * @version 02.2008
 */
public class ZweiTupel<A, B> {
    /**
     * Erste Komponente. final heisst: wurde dem Attribut einmal ein Objekt des
     * Typs A zugewiesen, kann kein anderes mehr gesetzt werden. Anmerkung: Der
     * Zustand des Objekts "erste" (Komponente) kann geaendert werden, sofern
     * das Objekt dazu entsprechende Dienste bereitstellt.
     */
    public final A erste;

    /**
     * Zweite Komponente. final heisst: wurde dem Attribut einmal ein Objekt des
     * Typs A zugewiesen, kann kein anderes mehr gesetzt werden. Anmerkung: Der
     * Zustand des Objekts "zweite" (Komponente) kann geaendert werden, sofern
     * das Objekt dazu entsprechende Dienste bereitstellt.
     */
    public final B zweite;

    public ZweiTupel(A a, B b) {
        erste = a;
        zweite = b;
    }

    @Override
	public String toString() {
        return "(" + erste + ", " + zweite + ")";
    }

    /**
     * Lesenden Zugriff via Dienst ersteGeben auf unsere erste Komponenten
     * bereitstellen.
     */
    public A ersteGeben() {
        return erste;
    }

    /**
     * Lesenden Zugriff via Dienst zweiteGeben auf unsere zweite Komponente
     * bereitstellen.
     */
    public B zweiteGeben() {
        return zweite;
    }
}
