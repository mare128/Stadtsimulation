package eps.fortgeschritteneGrafik;

import java.awt.Image;
import java.awt.Graphics2D;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import eps.fortgeschritteneGrafik.interna.Grafik;
import eps.fortgeschritteneGrafik.interna.Zeichenfenster;

/**
 * Objekte der Klasse Bild stellen einige einfache Dienste zum Darstellen von
 * Dateien des Typs jpg, png, gif... auf dem Zeichenfenster bereit. Die Bilder
 * muessen im Unterordner "Bilder" liegen. Dieser muss sich im Verzeichnis
 * befinden, indem auch die Datei Bild.java (genauer: die Datei Bild.class)
 * liegt. Es muss dort mindestens das Standardbild Tulpe.png vorhanden sein.
 * Versucht der Nutzer eines erfolgreich erzeugten Bildobjekts, einen dateinamen
 * zu setzen, der im Unterordner nicht vorhanden ist, dann gibt es eine kurze
 * freundliche Fehlermeldung auf der Konsole und der Zustand des Bildobjekts
 * aendert sich nicht.
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */

public class Bild extends Grafik {
	/**
	 * Der Name der Bilddatei
	 */
	private String dateiname;

	/**
	 * Haelt eine interne Repraesentation des Bildes.
	 */
	private Image internesBild;

	/**
	 * Es wird ein neues Bildobjekt mit den Standardeinstellungen erzeugt.
	 * Aufpunkt: (0, 0) - linke obere Ecke des ueberdeckenden Rechtecks. Das
	 * Standardbild ist eine Tulpe, sie wird angezeigt. Das Bild wird an einem
	 * Zeichenfenster angemeldet. Wird null eingegeben, wird das
	 * Standardfenster verwendet. Bilder muessen im Unterordner "Bilder" liegen.
	 */
	public Bild(Zeichenfenster fenster) {
		this(true, fenster);
	}

	/**
	 * Es wird ein neues Bild mit den Standardeinstellungen erzeugt. 
	 * Dieses kann mit einem Zeichenfensterobjekt verbunden werden und dort
	 * sogleich angemeldet werden (-> in den Eingangsparameter anmelden
	 * true hineinfuellen) oder nicht (-> in den Eingangsparameter anmelden
	 * false hineinfuellen). Wird null in den Eingangsparameter fenster
	 * eingefuellt, so wird das Standardfenster verwendet.
	 */
	public Bild(boolean anmelden, Zeichenfenster fenster) {
		super(anmelden, fenster);
		dateiname = "Tulpe.png";
		internesBild = eps.fortgeschritteneGrafik.interna.BildSpeicher
				.speicherGeben().ladeBild(dateiname);
		standardBreite = internesBild.getWidth(fensterGeben());
		standardHoehe = internesBild.getHeight(fensterGeben());
		if (internesBild != null) {
			groesseSetzen((int) standardBreite, (int) standardHoehe);
		}
	}

	/**
	 * Es wird ein neues Bildobjekt mit den Standardeinstellungen auf dem
	 * Standardfenster erzeugt.
	 */
	public Bild() {
		this(null);
	}

	/**
	 * Eine neue Bilddatei kann gewaehlt werden. Die Werte der Attribute breite
	 * und hoehe werden entsprechend der neuen Bilddatei angepasst.
	 * 
	 * Die Bilddatei muss im Unterordner Bilder (relativ zum Ort der Datei
	 * "Bild.class" dieses Projekts) liegen. Es koennen die Formate png und jpg
	 * dargestellt werden. Der Unterordner "Bilder/" wird nach der Eingabe
	 * automatisch ergaenzt, er darf nicht mit angegeben werden. Der Dienst gibt
	 * ggf. Fehlermeldungen auf der Standardkonsole an den Benutzer aus.
	 * 
	 * neuerDateiname - moegliche (Standard)Eingangswerte sind "Kirschen.png"
	 * oder "Tulpe.png".
	 * 
	 * Achtung: Die neue Bilddatei wird in Orginalgroesse dargestellt! 
	 * Die Werte der Attribute breite und hoehe werden entsprechend
	 * aktualisiert.
	 * Nur die Position (linke obere Ecke des achsenparallelen ueberdeckenden Rechtecks)
	 * bleibt erhalten.
	 * Alle bisherigen Drehungen, Streckungen (und Veraenderungen der Groesse via groesseSetzen) 
	 * werden durch das Setzen eines neuen Dateinamens geloescht.
	 */
	public void dateinameSetzen(String neuerDateiname) {
		Image bild = eps.fortgeschritteneGrafik.interna.BildSpeicher
				.speicherGeben().ladeBild(neuerDateiname);
		if (bild != null) {
			standardBreite = bild.getWidth(fensterGeben());
			standardHoehe = bild.getHeight(fensterGeben());
			transformationenGeben().loeschen();
			double xPosition = xPositionGeben();
			double yPosition = yPositionGeben();
			verschieben((int) xPosition, (int) yPosition);
			internesBild = bild;
			dateiname = neuerDateiname;
		}
	}

	/**
	 * Der Dienst gibt eine Aufzaehlung aller Dateien im Bilder-Unterverzeichnis
	 * zurueck.
	 */
	public static String[] bilderGeben() {
		URL u = Bild.class
				.getResource(eps.fortgeschritteneGrafik.interna.BildSpeicher.ordnerpfad);
		if (u == null || u.getPath() == null)
			return new String[0];
		File file = new File(pfadFormatieren(u.getPath()));
		if (file == null || file.list() == null)
			return new String[0];
		String[] dateiliste = file.list();
		ArrayList<String> umgefuellteListe = new ArrayList<String>();
		umgefuellteListe.addAll(Arrays.asList(dateiliste));
		Iterator<String> it = umgefuellteListe.iterator();
		while (it.hasNext()) {
			if (!eps.fortgeschritteneGrafik.interna.BildSpeicher
					.istDateiDarstellbar(it.next())) {
				it.remove();
			}
		}
		return umgefuellteListe.toArray(new String[0]);
	}

	/**
	 * Breite und Hoehe der Grafik koennen gewaehlt werden. Nicht
	 * positive (unsinnige) Angaben werden automatisch auf den kleinsten
	 * noch sinnvollen Wert fuer eine Grafik gesetzt, hier 1. Die Grafik ist dann
	 * entsprechend auf dem Zeichenfenster zu sehen. 
	 * Bei einem vorher evt. aufgetretenen Bildfehler wird der Aufruf von groesseSetzen
	 * ignoriert (ein nicht existierende Bild kann auch nicht in der Groesse veraendert
	 * werden).
	 */
	public void groesseSetzen(int neueBreite, int neueHoehe) {
		if (internesBild == null)
			return;
		super.groesseSetzen(neueBreite, neueHoehe);
	}

	/**
	 * Unsere einfache "Visitenkarte": unser Klassenname gefolgt von
	 * interessanten Attributwerten
	 */
	public String toString() {
		if (internesBild == null)
			return super.toString() + " - Dateiname: " + dateiname
					+ " - nicht darstellbar";
		return super.toString() + " - Dateiname: " + dateiname;
	}

	public String dateinameGeben() {
		if (internesBild == null)
			return dateiname + " - nicht darstellbar";
		return dateiname;
	}

	/**
	 * Technische Methode, die Zeichenfensterobjekte nutzen.
	 */
	protected void zeichnenAuf(Graphics2D zeichnung) {
		if (internesBild == null) {
			return;
		}
		Graphics2D kopie = (Graphics2D) zeichnung.create();
		transformationenGeben().anwenden(kopie);
		kopie.drawImage(internesBild, 0, 0, fensterGeben());
		kopie.dispose();
	}

	private static String pfadFormatieren(String pfad) {
		return pfad.replace("%20", " ").replace("%25", "%").replace("%c3%84",
				"\u00C4").replace("%c3%96", "\u00D6").replace("%c3%9c",
				"\u00DC").replace("%c3%a4", "\u00E4").replace("%c3%b6",
				"\u00F6").replace("%c3%bc", "\u00FC").replace("%3d", "=")
				.replace("%5b", "[").replace("%5d", "]").replace("%7b", "{")
				.replace("%7d", "}").replace("%60", "`").replace("%C3%84",
						"\u00C4").replace("%C3%96", "\u00D6").replace("%C3%9C",
						"\u00DC").replace("%C3%A4", "\u00E4").replace("%C3%C6",
						"\u00F6").replace("%C3%BC", "\u00FC").replace("%3D",
						"=").replace("%5B", "[").replace("%5D", "]").replace(
						"%7B", "{").replace("%7D", "}");
	}
}
