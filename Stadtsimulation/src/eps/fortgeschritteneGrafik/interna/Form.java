package eps.fortgeschritteneGrafik.interna;

import java.awt.Shape;
import java.awt.Graphics2D;

/**
 * Abstrakte Klasse Form Rechtecke, Dreiecke und Ellipsen sind Formen. Formen
 * stellen die zusaetzlichen Dienste gefuelltSetzen, groesseSetzen u. ae.
 * bereit. Weiter wird Technisches festgelegt, um Formen drehen zu koennen.
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public abstract class Form
        extends Vektorgrafik {

    /**
     * Der Wert des Attributs istGefuellt zeigt an, ob die Form gefuellt
     * gezeichnet wird, oder ob nur eine Kontur gezeichnet wird.
     */
    private boolean istGefuellt;

    /**
     * Es wird eine neue Form mit den Standardeinstellungen erzeugt, diese kann
     * mit einem Zeichenfenster verbunden werden. Wird null eingegeben, wird das
     * Standardfenster verwendet. Die Form ist gefuellt.
     * Sie kann sogleich beim Zeichenfenster angemeldet werden (true eingeben) oder
     * nicht (false eingeben). Nur angemeldete Grafiken koennen vom Zeichenfenster
     * gezeichnet werden.
     */
    public Form(boolean anmelden, Zeichenfenster fenster) {
        super(anmelden, fenster);
        standardBreite = 50;
        standardHoehe = 100;
        groesseSetzen((int) standardBreite, (int) standardHoehe);
        istGefuellt = true;        
    }

    /**
     * Mit dem Dienst gefuelltSetzen kann bestimmt werden, ob die Form gefuellt
     * zu zeichnen ist (true), oder ob nur die Kontur der Form zu zeichnen ist
     * (false).
     */
    public void gefuelltSetzen(boolean fuellen) {
        istGefuellt = fuellen;
    }

    protected void zeichnenAuf(Graphics2D zeichnung) {
        Graphics2D kopie = (Graphics2D) zeichnung.create();
        transformationenGeben().anwenden(kopie);
        Shape aktuelleGestalt = formFuerFensterErzeugen();
        kopie.setColor(farbeAufloesen());
        if (istGefuellt) {
            kopie.fill(aktuelleGestalt);
        } else {
            kopie.draw(aktuelleGestalt);
        }
        kopie.dispose();
    }

    /**
     * Konkrete Unterklassen bieten diesen Dienst an. Er gibt eine interne
     * Repraesentation der konkreten Form zurueck. Diese wird letztlich vom
     * Zeichenfenster gezeichnet.
     */
    protected abstract Shape formFuerFensterErzeugen();
}
