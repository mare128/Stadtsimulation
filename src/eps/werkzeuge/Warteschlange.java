package eps.werkzeuge;

import java.util.*;

/**
 * Ein Puffer (heisst auch Warteschlange oder Queue).<BR>
 * Hinzugefuegt wird am Ende, geschaut und entfernt wird am Anfang.<BR>
 * In der Schlange koennen Objekte eines Typs "anstehen".<BR>
 * Beim Erzeugen eines Warteschlangenobjekts muss man angeben,
 * von welchem Typ die aufzubewahrenden Objekte sein werden.
 * 
 * Hinweis: 
 * Fuer weiterfuehrende Arbeit mit dieser Klasse kann man das Attribut
 * einfacheRepraesentation, weiter die Methode einfacheRepraesentationAktualisieren und
 * deren Aufruf aus dieser Klassendefinition auch einfach entfernen.
 * 
 * @author Ute Heuer 
 * @version 05.2008 
 */
public class Warteschlange<Typ> {
	private LinkedList<Typ> speicher = new LinkedList<Typ>();
	/**
	 * Die "einfache Repraesentation" ist via Objektinspektor (BlueJ)
	 * fuer Schueler in der 10.Klasse leichter zugaenglich und wird
	 * deshalb hier zusaetzlich angeboten. Veraenderungen des Inhalts koennen,
	 * sofern die Elemente eine nette toString Methode anbieten, recht uebersichtlich
	 * verfolgt werden.
	 * Ein Nachteil ist, dass man "null-Eintraege" am Ende
	 * der Repraesentation der Liste sieht, die die Liste selbst "nicht hat". 
	 * Auch das interne Attribut length  der Repraesentation irritiert, 
	 * denn es zaehlt diese internen "null-Eintraege" mit.
	 */
	private ArrayList<String> einfacheRepraesentation = new ArrayList<String>();
	
	private void einfacheRepraesentationAktualisieren() {
	    einfacheRepraesentation.clear();
	    for (Typ element : speicher) {
	        einfacheRepraesentation.add(element.toString());
	    }
	}

	/**
	 * Dieser Dienst ermoeglicht es, ein Element des Typs am Ende
	 * der Schlange einzureihen. Engl.: addLast
	 */
	public void hineinstecken(Typ e) {
		speicher.addLast(e);
		einfacheRepraesentationAktualisieren();
	}//add

	/**
	 * Dieser Dienst erm�glicht das "Anschauen" des ersten Elements in der Schlange.
	 * Das "angeschaute" Element bleibt in der Schlange, es wird nicht
	 * entfernt. Engl.: getFirst<BR>
	 * 
	 * Wird versucht, ein Element aus einer leeren Schlange anzuschauen, dann
	 * gibt dieser Dienst einfach null aus.<BR>
	 * 
	 * schauen() ist ein
	 * sondierender Dienst. Der Inhalt der Schlange (genauer: der Zustand der Schlange)
	 * wird nicht veraendert.
	 */
	public Typ schauen() {//peek 
		if (speicher.isEmpty()) {
			return null;
		}
		else {// es gibt mindestens ein Element in der Warteschlange        
			return speicher.getFirst();
		}
	}

	/**
	 * Entnimmt das erste Element aus der Warteschlange. Engl.: removeFirst<BR>
	 * 
	 * Aus einer leeren Warteschlange kann kein Element entnommen werden, dieser
	 * Dienst gibt dann einfach null aus.
	 */
	public Typ herausholen() { //remove
		if (speicher.isEmpty()) {
			return null;
		}
		else {// es gibt mindestens ein Element in der Warteschlange
		    Typ erstes = speicher.removeFirst();
		    einfacheRepraesentationAktualisieren();
			return erstes;
		}
	}

	public boolean istLeer() {
		return speicher.isEmpty();
	}//empty

    /**
     * Berechnet die Anzahl der Elemente in der Schlange.
     * Ausgabe: die Anzahl der Elemente
     */	
	public int anzahlGeben() {
		return speicher.size();
	}

    /**
     * Dieser Dienst liefert Informationen ueber den Inhalt der Warteschlange.
     * Jedes Element der Warteschlange gibt sozusagen seine Visitenkarte (via
     * Dienst toString, den jedes Objekt anbietet) ab.
     * Er traegt den Namen, der in Java "vorgesehen ist" 
     * und nicht "inhaltsuebersichtGeben". <BR>
     * Anmerkung: Wenn die Objekte des Typs keine "nette Visitenkarte" haben, dann
     * wird eine Standardvisitenkarte verwendet. Da ist der Klassenname des 
     * Objekts notiert und eine Adresse im Speicher. <BR>
     * Experiment: "Holen" Sie sich die Ausgabe dieses Dienstes auf die
     * Arbeitsleiste Ihrer Umgebung. Vergeben Sie einen Namen fuer die Ausgabe,
     * sagen wir: string1. Schicken Sie sodann die Anweisung 
     * System.out.println(string1)
     * via Direkteingabe-Fenster ab.
     */    	
	@Override
	public String toString() {
		return speicher.toString();
	}
}


/**
 * Das haben wir auch ausprobiert. Aber bei dieser Alternative kann man
 * im Objektinspektor von BlueJ 
 * Aenderungen nur dann beobachten, wenn man das entsprechende Fenster immer wieder
 * neu aufmacht. Deshalb haben wir uns gegen diese Moeglichkeit entschieden.
 * Allerdings hat man den Nachteil der verwirrenden null-Referenzen hier nicht (siehe
 * Kommentar zur momentanen Implementation).
 * 
 * 	private String[] einfacheRepraesentation;	
 * 
 * 	private void einfacheRepraesentationAktualisieren() {
	    einfacheRepraesentation = new String[speicher.size()];
	    int i = 0;
	    for (Typ element : speicher) {
	        einfacheRepraesentation[i] = element.toString();
	        i++;
	    }
	}    
 */

