package eps.werkzeuge;

import java.util.*;
/**
 * Klasse Liste.
 * Objekte eines Typs koennen gehalten werden.
 * Beim Erzeugen eines Listeobjekts muss man angeben, 
 * von welchem Typ die aufzubewahrenden Objekte sein werden.<BR>
 * 
 * toDo: ueberarbeiten
 * 
 * Das Iterieren ueber Elemente der Liste ist via
 * Wiederholung mit fester Anzahl (for-each Konstrukt in Java) moeglich.
 * 
 * Anmerkung: Das Attribut speicher soll und braucht von Schuelern in der 10.Klasse
 * nicht inspiziert zu werden.
 * 
 * Hinweis: Komplexitaet von Diensten wird in der 10.Klasse nicht thematisiert. 
 * Entsprechend war dies bei der Umsetzung der Klasse Liste auch kein wichtiges Thema.
 * Diese Klasse soll Interessierten nur prinzipiell zeigen, 
 * wie Objekte "bequem" gehalten werden koennten.
 * Fuer weiterfuehrende Arbeit mit dieser Klasse kann man das Attribut
 * einfacheRepraesentation, weiter die Methode einfacheRepraesentationAktualisieren und
 * deren Aufruf aus dieser Klassendefinition auch einfach entfernen.
 * 
 * @author Ute Heuer 
 */
public class Liste<Typ> implements Iterable<Typ> {
    /*---------------Attribute-----*/
	private LinkedList<Typ> speicher = new LinkedList<Typ>();
	/**
	 * Die "einfache Repraesentation" ist via Objektinspektor (BlueJ)
	 * fuer Schueler in der 10.Klasse leichter zugaenglich und wird
	 * deshalb hier zusaetzlich angeboten. Veraenderungen des Inhalts koennen,
	 * sofern die Elemente eine nette toString Methode anbieten, recht uebersichtlich
	 * verfolgt werden. 
	 * Ein Nachteil ist, dass man "null-Eintraege" am Ende
	 * der Repraesentation der Liste sieht, die die Liste selbst "nicht hat". 
	 * Auch das interne Attribut length der Repraesentation irritiert, 
	 * denn es zaehlt diese internen "null-Eintraege" mit.
	 */
	private ArrayList<String> einfacheRepraesentation = new ArrayList<String>();
    /*---------------Konstruktor---*/
    /**
     * Eine leere Liste wird erzeugt.
     * Wollen Sie eine Liste fuer Worte erzeugen,
     * dann geben Sie als Wert des Typ-Parameters ein: String  .
     * Wollen Sie eine Liste fuer ganze Zahlen erzeugen,
     * dann geben Sie als Wert des Typ-Parameters ein: Integer  .
     * Wollen Sie eine Liste fuer Dreiecke erzeugen,
     * dann geben Sie als Wert des Typ-Parameters ein: eps.einfacheGrafik.Dreieck  .
     * u.s.w.
     */    
    public Liste() {
    }
 
    /** 
     * Konstruktor zum Umfuellen eines Feldes in eine Liste, dabei werden 
     * null-Referenzen nicht umgefuellt.
     * Es wird eine Liste erzeugt, die Elemente eines Typs enthaelt.
     * 
     * @param elemente ein Feld mit Elementen eines Typs 
     */    
    public Liste(Typ[] elemente){
        for (Typ element: elemente) {
            if (element != null) {
                hineinstecken(element);
            }
        }
        einfacheRepraesentationAktualisieren();
    }    
    /* 
     * Erzeugt eine Liste, die die Elemente der angegebenen Collection enthaelt.
     * Die Elemente der Collection muessen alle den festgelegten Typ haben.
     */    
    private Liste(Collection<Typ> elemente){
        speicher.addAll(elemente);
        einfacheRepraesentationAktualisieren();
    }
    /*---------------Methoden------*/    
    /** nach Kapitel 4<BR>
     * @return Liefert eine Kopie der aktuellen Liste,
     * die zum Durchlauf verwendet werden kann. Dann
     * kann waehrend des Durchlaufs in die aktuelle Liste
     * (nicht in die Kopie!) etwas hineingesteckt oder 
     * herausgenommen werden.
     * So vermeidet man Laufzeitfehler (Concurrent Modification Exception)
     */
    public Liste<Typ> kopieGeben(){
        return  new Liste<Typ>(speicher);
    }
    
    /**
     * Dieser Dienst steckt ein Element in die Liste hinein,
     * und zwar am Ende. Engl.: addLast .
     */
    public void hineinstecken(Typ element) {
        speicher.addLast(element);
        einfacheRepraesentationAktualisieren();
    }
    
    /**
     * Dieser Dienst ermoeglicht das "Anschauen" des ersten Listenelements.
     * Das "angeschaute" Element bleibt in der Liste, es wird nicht entfernt.
     * 
     * Wird versucht, ein Element aus einer leeren Liste anzuschauen, dann
     * gibt dieser Dienst einfach null aus.
     */
    public Typ schauen() {
        Iterator<Typ> iterator = speicher.iterator();
        if (iterator.hasNext()){
            return iterator.next();
        }
        return null;        
    }    

    /**
     * Entnimmt das erste Element aus der Liste.
     * Engl.: removeFirst
     * 
     * Aus einer leeren Liste kann kein Element entnommen werden,
     * dieser Dienst gibt dann einfach null aus.
     */
    public Typ herausholen() {
		if (speicher.isEmpty()) {
			return null;
		}
		else {// es gibt mindestens ein Element in der Liste
		    Typ erstes = speicher.removeFirst();
		    einfacheRepraesentationAktualisieren();
			return erstes;
		}
    }
    
    /**
     * Versucht ein Element aus der Liste zu entfernen, welches dem eingegebenen gleicht.
     * Engl.: remove.
     * Ausgabe: true, wenn das Element drin war und also entfernt werden konnte,
     * ansonsten false.
     * Anmerkung: Wenn die Kopie einer Liste durchlaufen wird,
     * dann kann aus der "Orginalliste" mit diesem Dienst etwas entfernt werden.
     */ 
    public boolean entfernen(Typ element) {
        if (enthaeltElement(element)) {
            boolean erfolgreichEntfernt = speicher.remove(element);            
            einfacheRepraesentationAktualisieren();
            return erfolgreichEntfernt;
        } else {// an der Liste wurde nichts geaendert
            return false;
        }
    }        
    /**
     * Vollstaendige Entleerung der Liste
     */
    public void leeren() {
        speicher.clear();
        einfacheRepraesentationAktualisieren();
    }
    
	public boolean istLeer() {
		return speicher.isEmpty();
	}//empty

    /**
     * Berechnet die Anzahl der Elemente in der Liste.
     * Ausgabe: die Anzahl der Elemente
     */	
	public int anzahlGeben() {
		return speicher.size();
	}

    /**
     * Dieser Dienst liefert Informationen ueber den Inhalt der Liste.
     * Jedes Element der Liste gibt sozusagen seine Visitenkarte (via
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
	public String toString() {
		return speicher.toString();
	} 

    /**
     * Dieser Dienst fuegt eine beliebig lange Aufzaehlung von Elementen
     * gleichen Typs am Ende der Liste an,
     * und zwar in der angegebenen Reihenfolge
     */
    public void hineinstecken(Typ... elemente) {
        for (Typ element: elemente) {
            hineinstecken(element);
        }
    }

    /**
     * Dieser Dienst ist fuer Nutzer in der 10.Klasse nicht weiter von Interesse.
     * 
     * Anmerkung: Wenn via Iterator an Listenobjekten etwas veraendert wird,
     * ist der Nutzer dafuer verantwortlich, (bei Interesse) das
     * Attribut einfacheRepraesentation zu aktualisieren. Es wird dann
     * nicht automatisch aktualisiert. In dem Fall sollte die entsprechende
     * Methode dieser Klassendefinition veroeffentlicht werden (oder das Attribut etc.
     * komplett aus der Klassendefinition entfernt werden.)
     */
    public Iterator<Typ> iterator() { return speicher.iterator();}    
    
    /**
     * Kann nach Kapitel 2 verwendet werden.
     * Motivation: Es ist sinnvoll festzulegen, wann zwei Listen gleich sind.
     * Hier ist Gleichheit als �bereinstimmung in Reihenfolge und Inhalt definiert. 
     * 
     * Der Name des Dienstes ist von Java festgelegt.
     * Ab Kapitel 5 kann angesprochen werden, dass equals der Oberklasse Object
     * ueberschrieben wird.
     */
    public boolean equals(Liste<Typ> listeRechts) {
        if (listeRechts != null){
            return speicher.equals(listeRechts.speicher);
        } else {
            return false;// denn uns gibt es
        }
    }
    
    public boolean enthaeltElement(Typ element) { 
        return speicher.contains(element);
    }

	private void einfacheRepraesentationAktualisieren() {
	    einfacheRepraesentation.clear();
	    for (Typ element : speicher) {
	        einfacheRepraesentation.add(element.toString());
	    }
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
