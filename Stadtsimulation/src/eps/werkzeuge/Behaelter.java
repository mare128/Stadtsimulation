package eps.werkzeuge;

import java.util.HashSet;
import java.util.Collection;
import java.util.Iterator;

/**
 * Eine Art "Universalbehaelter", der Objekte eines Typs halten kann.<BR><BR>
 * 
 * Beim Erzeugen eines Behaelterobjekts muss man angeben, 
 * von welchem Typ die aufzubewahrenden Objekte sein werden.<BR>
 * 
 * Ein Objekt kann nur dann in diesen Behaelter eingefuegt werden, wenn es
 * noch kein gleiches Objekt im Behaelter gibt.<BR> 
 * Wann sind zwei Objekte gleich? Diese Frage wird mit Hilfe des Dienstes 
 * "equals" beantwortet, den jedes Objekt anbietet.<BR><BR>
 * 
 * Diese Behaelter merkt sich nicht, ob ein Objekt "frueher oder spaeter" als
 * ein anderes eingefuegt wurde. Man kann als Nutzer auch nicht sagen,
 * "wo" man das Objekt nun gerne einfuegen moechte.
 * 
 * Anmerkung: Das Attribut speicher soll und braucht von Schuelern in der 10.Klasse
 * nicht inspiziert zu werden.
 * 
 * Hinweis: Komplexitaet von Diensten wird in der 10.Klasse nicht thematisiert. 
 * Entsprechend war dies bei der Umsetzung der Klasse Behaelter auch kein wichtiges Thema.
 * Diese Klasse soll Interessierten nur prinzipiell zeigen, 
 * wie Objekte "bequem" gehalten werden koennten.
 * 
 * @author Ute Heuer 
 * @version 05.08 
 */
public class Behaelter<Typ> implements Iterable<Typ> {
    private HashSet<Typ> speicher = new HashSet<Typ>();
   /* -----------------------------------Konstruktoren-*/     
    /**
     * Ein leerer Behaelter wird erzeugt.
     * Wollen Sie einen Behaelter fuer Worte erzeugen,
     * dann geben Sie als Wert des Typ-Parameters ein: String  .
     * Wollen Sie einen Behaelter fuer ganze Zahlen erzeugen,
     * dann geben Sie als Wert des Typ-Parameters ein: Integer  .
     * Wollen Sie einen Behaelter fuer Dreiecke erzeugen,
     * dann geben Sie als Wert des Typ-Parameters ein: eps.einfacheGrafik.Dreieck  .
     */
    public Behaelter(){
    }
    
    /** nach Kapitel 3 <BR>
     * Konstruktor zum Umfuellen eines Feldes in einen Behaelter, dabei werden gleiche Objekte
     * nur einmal in den Behaelter eingefuellt.
     * Es wird ein Behaelter erzeugt, der Elemente eines Typs enthaelt.
     * 
     * @param elemente ein Feld mit Elementen eines Typs 
     */    
    public Behaelter(Typ[] elemente){
        for (Typ element: elemente) {
            hineinstecken(element);
        }
    }

    /** nach Kapitel 4 <BR>
     * Erzeugt einen Behaelter, der die Elemente der angegebenen Collection enthaelt.
     * (Einzige in der 10.Klasse manchmal verwendete Collection ist: ArrayList.)
     * Dabei werden gleiche Objekte nur einmal in den Behaelter eingefuellt.
     * Die Elemente der Collection muessen alle den festgelegten Typ haben.
     */    
    public Behaelter(Collection<Typ> elemente){
        speicher.addAll(elemente);
    }

    /* -----------------------------------Methoden----*/     

    /** nach Kapitel 4<BR>
     * @return Liefert eine Kopie des aktuellen Behaelters,
     * die zum Durchlauf verwendet werden kann. Dann
     * kann waehrend des Durchlaufs in den aktuellen Behaelter
     * (nicht in die Kopie!) etwas hineingesteckt oder 
     * herausgenommen werden.
     * So vermeidet man Laufzeitfehler (Concurrent Modification Exception)
     */
    public Behaelter<Typ> kopieGeben(){
        return  new Behaelter<Typ>(speicher);
    }
    
    /**
     * Dieser Dienst steckt ein Element in den Behaelter hinein,
     * sofern noch kein gleiches darinnen ist. Engl.: add .
     */
    public void hineinstecken(Typ element) {
        speicher.add(element);
    }

    /**
     * Dieser Dienst ermoeglicht das "Anschauen" eines Elements aus dem Behaelter.
     * Das "angeschaute" Element bleibt im Behaelter, es wird nicht entfernt.
     * 
     * Wird versucht, ein Element aus einem leeren Behaelter anzuschauen, dann
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
     * Entnimmt ein Element aus dem Behaelter.
     * Engl.: remove
     * 
     * Aus einem leeren Behaelter kann kein Element entnommen werden,
     * dieser Dienst gibt dann einfach null aus.
     */
    public Typ herausholen() {
        Iterator<Typ> iterator = speicher.iterator();
        if (iterator.hasNext()){
            Typ herausgeholtesElement = iterator.next();
            iterator.remove();
            return herausgeholtesElement;
        }
        return null;
    }

    /**
     * Versucht ein Element aus dem Behaelter zu entfernen, welches dem eingegebenen gleicht.
     * Engl.: remove.
     * Ausgabe: true, wenn das Element drin war und also entfernt werden konnte,
     * ansonsten false. 
     * Anmerkung: Wenn die Kopie eines Behaelters durchlaufen wird,
     * dann kann aus dem "Orginalbehaelter" mit diesem Dienst etwas entfernt werden.
     */ 
    public boolean entfernen(Typ element) {
        if (enthaeltElement(element)) {
            return speicher.remove(element);
        } else {
            return false;
        }
    }    

    /**
     * Berechnet die Anzahl der Elemente im Behaelter.
     * Ausgabe: die Anzahl der Elemente
     */
    public int anzahlGeben() { return speicher.size(); }

    /**
     * Vollstaendige Entleerung des Behaelters
     */
    public void leeren() {speicher.clear();} 
    
    /**
     * Dieser Dienst liefert Informationen ueber den Inhalt des Behaelters. 
     * Experiment: "Holen" Sie sich die Ausgabe dieses Dienstes auf die
     * Arbeitsleiste Ihrer Umgebung. Vergeben Sie einen Namen fuer die Ausgabe,
     * sagen wir: string1. Schicken Sie sodann die Anweisung 
     * System.out.println(string1)
     * via Direkteingabe-Fenster ab.
     */
    public String inhaltsuebersichtGeben() {
        return speicher.toString();
    }
    /**
     * Dieser Dienst liefert Informationen ueber den Inhalt des Behaelters. 
     * Er traegt den Namen, der in Java "vorgesehen ist" 
     * und nicht "inhaltsuebersichtGeben". 
     * Experiment: "Holen" Sie sich die Ausgabe dieses Dienstes auf die
     * Arbeitsleiste Ihrer Umgebung. Vergeben Sie einen Namen fuer die Ausgabe,
     * sagen wir: string1. Schicken Sie sodann die Anweisung 
     * System.out.println(string1)
     * via Direkteingabe-Fenster ab.
     */    
    public String toString() {
        return speicher.toString(); 
    } 

    /** Nur fuer Interessierte <BR>
     * Dieser Dienst fuellt die Elemente aus einem anderen Behaelter in
     * diesen Behaelter hinein,
     * sofern jeweils noch kein gleiches darinnen ist. Engl.: addAll
     */
    public void hineinstecken(Behaelter<Typ> einzufuellendes) {
        if (einzufuellendes != null){
            speicher.addAll(einzufuellendes.speicher);
        }
    }
    
    /**
     * Dieser Dienst steckt eine beliebig lange Aufzaehlung von Elementen
     * gleichen Typs in den Behaelter hinein,
     * sofern jeweils noch kein gleiches darinnen ist. 
     */
    public void hineinstecken(Typ... elemente) {
        for (Typ element: elemente) {
            hineinstecken(element);
        }
    }

    /** 
     * In der 10.Klasse nicht von Interesse
     */    
    public Iterator<Typ> iterator() { return speicher.iterator();}    
    
    /**
     * Kann nach Kapitel 2 verwendet werden.
     * Motivation: Es ist sinnvoll festzulegen, wann zwei Behaelter gleich sind.
     * Hier ist Gleichheit als Inhaltsgleichheit definiert. Zwei Behaelter sind gleich,
     * wenn sie in ihren Elementen uebereinstimmen.
     * 
     * Der Name des Dienstes ist von Java festgelegt.
     * Ab Kapitel 5 kann angesprochen werden, dass equals der Oberklasse Object
     * ueberschrieben wird.
     */
    public boolean equals(Behaelter<Typ> behaelterRechts) {
        if (behaelterRechts != null){
            return speicher.equals(behaelterRechts.speicher);
        } else {
            return false;
        }
    }
    
    public boolean enthaeltElement(Typ element) { 
        return speicher.contains(element);
    }
    public boolean istLeer() {return speicher.isEmpty();}    
}
