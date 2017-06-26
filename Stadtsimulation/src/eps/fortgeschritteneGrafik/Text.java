package eps.fortgeschritteneGrafik;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import eps.fortgeschritteneGrafik.interna.Vektorgrafik;
import eps.fortgeschritteneGrafik.interna.Zeichenfenster;


/**
 * Objekte der Klasse Text stellen einige einfache Dienste zum Darstellen von
 * Zeichenketten auf dem Zeichenfenster bereit.
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public class Text
        extends Vektorgrafik {

    /**
     * Die Standard-Schriftart des Textes (ohne Transformationen) 
     */
    private Font standardSchrift;

    /**
     * Das Attribut text haelt die Zeichenkette, die dargestellt werden soll.
     */
    private String text;
    
    /**
     * Es wird ein neues Textobjekt mit den Standardeinstellungen auf dem
     * Standardfenster erzeugt.
     */
    public Text() {
        this(null);
    }

    /**
     * Es wird ein neues Textobjekt mit den Standardeinstellungen auf dem
     * Standardfenster erzeugt.
     * Die Schriftgroesse des Textobjekts kann gewaehlt werden. Werden hier
     * unsinnige nicht positive Eingaben gemacht, wird automatisch die kleinste
     * moegliche Schriftgroesse 1 gesetzt. 
     * Das Textobjekt ist noch nicht am Zeichenfenster angemeldet.
     */
    public Text(int schriftgroesse) {
        this(schriftgroesse, false, null);
    }

    /**
     * Es wird ein neuer Text mit den Standardeinstellungen erzeugt. 
     * Die Schriftgroesse des Textobjekts kann gewaehlt werden. Werden hier
     * unsinnige nicht positive Eingaben gemacht, wird automatisch die kleinste
     * m�gliche Schriftgroesse 1 gesetzt. 
     * Dieser kann mit einem Zeichenfensterobjekt verbunden werden und dort
     * sogleich angemeldet werden (-> in den Eingangsparameter anmelden
     * true hineinfuellen) oder nicht (-> in den Eingangsparameter anmelden
     * false hineinfuellen). Wird null in den Eingangsparameter fenster
     * eingefuellt, so wird das Standardfenster verwendet.
     */
    public Text(int schriftgroesse, boolean anmelden, Zeichenfenster fenster) {
        super(anmelden, fenster);
        if (schriftgroesse < 1) {
            schriftgroesse = 1;
        }
        standardSchrift = new Font("SansSerif", Font.PLAIN, schriftgroesse);        
        text = "Text";
        standardBreite = fensterGeben().getFontMetrics(standardSchrift)
                .stringWidth(text);
        standardHoehe = fensterGeben().getFontMetrics(standardSchrift)
                .getHeight();
        groesseSetzen((int) standardBreite, (int) standardHoehe);        
    }
    
    public Text(boolean anmelden, Zeichenfenster fenster) {
        this(48, anmelden, fenster);
    }
    
    /**
     * Es wird ein neuer Text mit den Standardeinstellungen erzeugt. Die
     * Zeichenkette "Test" wird gehalten. Die Schriftgroesse betraegt 48 pt.
     * Dieser kann mit einem Zeichenfensterobjekt verbunden werden. Wird null
     * eingegeben, wird das Standardfenster verwendet.
     */
    public Text(Zeichenfenster fenster) {
        this(true, fenster);
    }

//     /**
//      * Die Schriftgroesse der Zeichenkette kann gewaehlt werden.
//      * toDo: Entfernen
//      */
//     public void groesseSetzen(int neueSchriftgroesse) {
//         Font font = new Font(standardSchrift.getFamily(), Font.PLAIN,
//                 neueSchriftgroesse);
//         double breite = fensterGeben().getFontMetrics(font).stringWidth(text);
//         double hoehe = fensterGeben().getFontMetrics(font).getHeight();
//         groesseSetzen((int) breite, (int) hoehe);
//     }

    /**
     * Der anzuzeigende Inhalt kann gewaehlt werden. Achtung: Die Anfuehrungsstriche
     * beim Datentyp String nicht vergessen! Z.B. "Guten Morgen" 
     * Aber es k�nnen auch Zahlen (Datentyp int) eingefuellt werden. Z.B. 54
     * Achtung: Der Inhalt wird in der bei Konstruktion des Textobjekts festgelegten
     * Schriftgroesse dargestellt! Die Werte der Attribute breite und hoehe werden entsprechend
     * aktualisiert.
     * Farbe und Position bleiben jedoch erhalten.
     * Alle Drehungen, Streckungen (und Veraenderungen der Groesse via groesseSetzen) 
     * werden durch das Setzen eines neuen Textes geloescht.
     */
    public void inhaltSetzen(Object neuerInhalt) {
        text = neuerInhalt.toString();
        standardBreite = fensterGeben().getFontMetrics(standardSchrift)
                .stringWidth(text);
        standardHoehe = fensterGeben().getFontMetrics(standardSchrift)
                .getHeight();
        transformationenGeben().loeschen();
        double xPosition = xPositionGeben();
        double yPosition = yPositionGeben();
        verschieben((int) xPosition, (int) yPosition);
    }
    
    public String inhaltGeben() {
        return text;
    }

    /**
     * Unsere einfache "Visitenkarte": unser Klassenname gefolgt von
     * interessanten Attributwerten
     */
    public String toString() {
        return super.toString() + " - Inhalt: " + text;
    }

    /**
     * Technische Methode, die Zeichenfensterobjekte nutzen.
     * Die Zeichenkette wird auf dem Zeichenfenster dargestellt, falls das
     * Attribut istAnzuzeigen entsprechend gesetzt wurde.
     */
    protected void zeichnenAuf(Graphics2D zeichnung) {
        if (text == null) {
            return;
        }
        Graphics2D kopie = (Graphics2D) zeichnung.create();
        transformationenGeben().anwenden(kopie);
        kopie.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        kopie.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_SPEED);
        kopie.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_SPEED);
        kopie.setFont(standardSchrift);
        kopie.setColor(farbeAufloesen());
        kopie.drawString(text, (float) 0.0, standardSchrift.getSize2D());
        kopie.dispose();
    }
}
