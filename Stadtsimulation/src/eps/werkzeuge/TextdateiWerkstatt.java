package eps.werkzeuge;

import java.awt.Component;
import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Die Klasse Textdatei stellt Werkzeuge bereit, mit denen eine Textdatei als
 * Wort gelesen und gespeichert werden kann. Erzeugt man ein Objekt der Klasse
 * Textdatei, so kann "interaktiv" mit dem ueblichen Oeffnen/Speichern-Dialog
 * gearbeitet werden. Das Textdateiobjekt merkt sich dabei den zuletzt angewaehlten
 * Ordner und wird diesen beim naechsten Aufruf im Dialog vorschlagen.
 * 
 * Anmerkung: In diesem Zusammenhang ist der Begriff Zustand eines Objekts 
 * interessant. Mittels des Zustands merkt das Objekt sich den zuletzt angewaehlten
 * Ordner. Das ist sinnvoll, denn fuer verschiedene Anwendungen waehlt
 * der Benutzer typischerweise verschiedene Ordner, in denen er immer mal wieder
 * speichern moechte.<BR> 
 * Nur fuer Interessierte: Ueber statische Methoden haette man nur einen letzten Ordner
 * fuer alle Anwendungen zur Verfuegung stellen koennen. (Dies wird hier nicht gemacht).
 * 
 * 
 * @author Heuer 
 * @version (a version number or a date)
 */
public class TextdateiWerkstatt {
	/**
	 * Unser "internes" Trennzeichen fuer den Zeilenvorschub
	 */
	private static final String zeilenvorschub = "\n";

	private JFileChooser dateiauswahl = new JFileChooser(new File("")
			.getAbsoluteFile());

	public TextdateiWerkstatt() {
		FileFilter filter = new FileNameExtensionFilter("Textdatei", "txt");
		dateiauswahl.addChoosableFileFilter(filter);
		dateiauswahl.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	}

	/**
	 * Speichert eine Textdatei. 
	 * Der Benutzer kann Ort und Dateinamen ueber den ueblichen Speicherdialog
	 * auswaehlen.
	 * ACHTUNG: Beim ersten Aufruf kann der Dialog ggf. hinter allen 
	 * offenen Fenstern versteckt sein.
	 * 
	 * Die geschriebene Textdatei enthaelt genau das,
	 * was zuSpeichernderText angibt.
     * Wird versucht eine existierende Datei  
     * zu ueberschreiben, wird mit einer Notiz nachgefragt, ob man das moechte.
	 */
	public void speichern(String zuSpeichernderText) {
		Fenster component = null;
		speichern(component, zuSpeichernderText);
	}

	/**
	 * Speichert eine Textdatei. 
	 * Der Benutzer kann Ort und Dateinamen ueber den ueblichen Speicherdialog
	 * auswaehlen.
	 * ACHTUNG: Beim ersten Aufruf kann der Dialog ggf. hinter allen 
	 * offenen Fenstern versteckt sein.
	 * 
	 * Die Textdatei enthaelt dann die Eintraege der zuSpeicherndeTextliste,
	 * die durch ein Plattformuebliches Zeilenvorschubzeichen getrennt sind.
     * Wird versucht eine existierende Datei  
     * zu ueberschreiben, wird mit einer Notiz nachgefragt, ob man das moechte.
	 */
	public void speichern(ArrayList<String> zuSpeicherndeTextliste) {
		Fenster component = null;
		speichern(component, zuSpeicherndeTextliste);
	}

	/**
	 * Speichert eine Textdatei. 
	 * Der Benutzer kann Ort und Dateinamen ueber den ueblichen Speicherdialog
	 * auswaehlen. Der Speicherdialog kann mit einem Fenster verbunden
	 * werden. Das hat den Vorteil, dass der Dialog gleich an passender Stelle im
	 * Vordergrund ist, wenn man als Benutzer "am Fenster arbeitet. Formular und 
	 * fortgeschritteneGrafik.Zeichenfenster
	 * sind moegliche Fenster.
	 * Die geschriebene Textdatei enthaelt genau das,
	 * was zuSpeichernderText angibt.
     * Wird versucht eine existierende Datei  
     * zu ueberschreiben, wird mit einer Notiz nachgefragt, ob man das moechte.
	 */
	public void speichern(Fenster hintergrundfenster, String zuSpeichernderText) {
		Component komponente;
		if (hintergrundfenster != null) {
			komponente = hintergrundfenster.verknuepfungGeben();
		}
		else {
			komponente = null;
		}

		// Dialog zur Auswahl einer Datei anzeigen
		int result = dateiauswahl.showSaveDialog(komponente);

		// Waehlt der Benutzer "Abbrechen" verlassen wir diese Methode
		if (result == JFileChooser.CANCEL_OPTION)
			return;

		// Wir holen den gewuenschten Dateinamen
		File datei = dateiauswahl.getSelectedFile();

		// und speichern im ausgewaehlten Verzeichnis.
		speichern(datei, zuSpeichernderText);
	}

	/**
	 * Speichert eine Textdatei. 
	 * Der Benutzer kann Ort und Dateinamen ueber den ueblichen Speicherdialog
	 * auswaehlen. Der Speicherdialog kann mit einem Fenster verbunden
	 * werden. Das hat den Vorteil, dass der Dialog gleich an passender Stelle im
	 * Vordergrund ist, wenn man als Benutzer "am Fenster arbeitet". Formular und 
	 * fortgeschritteneGrafik.Zeichenfenster
	 * sind moegliche Fenster.
	 * Die Textdatei enthaelt dann die Eintraege der zuSpeicherndeTextliste,
	 * die durch ein Plattformuebliches Zeilenvorschubzeichen getrennt sind.
     * Wird versucht eine existierende Datei  
     * zu ueberschreiben, wird mit einer Notiz nachgefragt, ob man das moechte.
	 */
	public void speichern(Fenster hintergrundfenster,
			ArrayList<String> zuSpeicherndeTextliste) {
		speichern(hintergrundfenster, listeZuString(zuSpeicherndeTextliste));
	}

	/**
	 * Die Textdatei mit dem Namen dateiname wird in das Verzeichnis 
	 * des aufrufenden BlueJ Projekts geschrieben.
	 * Beispiel fuer einen Dateinamen: "meinText.txt".
	 * Die Textdatei enthaelt dann genau das,
	 * was zuSpeichernderText angibt.
     * Wird versucht eine existierende Datei  
     * zu ueberschreiben, wird mit einer Notiz nachgefragt, ob man das moechte.
	 */
	public static void speichern(String dateiname, String zuSpeichernderText) {
		speichern(dateiname, zuSpeichernderText);
	}

	/**
	 * Die Textdatei mit dem Namen dateiname wird in das Verzeichnis 
	 * des aufrufenden BlueJ Projekts geschrieben.
	 * Beispiel fuer einen Dateinamen: "meinText.txt".
	 * Die Textdatei enthaelt dann die Eintraege der zuSpeicherndeTextliste,
	 * die durch ein Plattformuebliches Zeilenvorschubzeichen getrennt sind.
     * Wird versucht eine existierende Datei  
     * zu ueberschreiben, wird mit einer Notiz nachgefragt, ob man das moechte.
	 */
	public static void speichern(String dateiname,
			ArrayList<String> zuSpeicherndeTextliste) {
		speichern(dateiname, listeZuString(zuSpeicherndeTextliste));
	}

	private static String listeZuString(ArrayList<String> liste) {
		StringWriter zeichenkette = new StringWriter();
		PrintWriter vermittler = new PrintWriter(new BufferedWriter(
				zeichenkette));
		for (String absatz : liste) {
			vermittler.println(absatz);
		}
		vermittler.close();
		return zeichenkette.toString();
	}

	/**
     * Die Textdatei wird geschrieben.
     * Die Textdatei enthaelt dann genau das,
     * was zuSpeichernderText angibt.
     * Wird versucht eine existierende Datei  
     * zu ueberschreiben, wird mit einer Notiz nachgefragt, ob man das moechte.
     * Nach Bruce Eckel net.mindview.util.TextFile.
	 * Nach Bruce Eckel net.mindview.util.TextFile.
	 */
	private static void speichern(File datei, String zuSpeichernderText) {
		if (!datei.isAbsolute())
			datei = datei.getAbsoluteFile();

		if (datei.exists()) {
			if (!new Notiz().jaNeinAntwortLesen("Die Datei " + datei.getName()
					+ " gibt es bereits im ausgewaehlten Verzeichnis. "
					+ " Wollen Sie diese Datei ueberschreiben?")) {
				return;
			}
		}

		try {
			PrintWriter out = new PrintWriter(datei);
			try {
				out.print(zuSpeichernderText);
			}
			finally {
				out.close();
			}
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String standardverzeichnisGeben() {
		return new File("").getAbsoluteFile().toString();
	}

	/**
	 * Liest eine Textdatei und gibt deren Inhalt als ein Wort zurueck. 
	 * Der Benutzer kann Ort und Dateinamen ueber den ueblichen Speicherdialog
	 * auswaehlen. 
	 * Hinweis: Beim ersten Aufruf kann der Dialog ggf. hinter allen 
	 * offenen Fenstern versteckt sein.
	 * 
	 * Der Benutzer kann den Dialog abbrechen. Dann wird null zurueckgegeben.
	 * 
	 */
	public String lesen() {
		Fenster component = null;
		return lesen(component);
	}

	/**
	 * Liest eine Textdatei und gibt deren Inhalt als eine Absatzliste zurueck. 
	 * Der Benutzer kann Ort und Dateinamen ueber den ueblichen Speicherdialog
	 * auswaehlen. 
	 * Hinweis: Beim ersten Aufruf kann der Dialog ggf. hinter allen 
	 * offenen Fenstern versteckt sein.
	 * 
	 * Der Benutzer kann den Dialog abbrechen. Dann wird null zurueckgegeben.
	 * 
	 */
	public ArrayList<String> absatzlisteLesen() {
		Fenster component = null;
		return absatzlisteLesen(component);
	}

	/**
	 * Liest eine Textdatei und gibt deren Inhalt als ein Wort zurueck. 
	 * Der Benutzer kann Ort und Dateinamen ueber den ueblichen Speicherdialog
	 * auswaehlen. Der Speicherdialog kann mit einem Fenster verbunden
	 * werden. Das hat den Vorteil, dass der Dialog gleich sichtbar ist, wenn
	 * man als Benutzer das Fenster ausgewaehlt hat. Formular und 
	 * fortgeschritteneGrafik.Zeichenfenster
	 * sind moegliche Fenster.
	 * 
	 * Der Benutzer kann den Dialog abbrechen. Dann wird null zurueckgegeben.
	 * 
	 */
	public String lesen(Fenster hintergrundfenster) {
		Component komponente;
		if (hintergrundfenster != null) {
			komponente = hintergrundfenster.verknuepfungGeben();
		}
		else {
			komponente = null;
		}
		// Dialog zur Auswahl einer Datei anzeigen
		int result = dateiauswahl.showOpenDialog(komponente);

		// Waehlt der Benutzer "Abbrechen" verlassen wir diese Methode
		// und geben null zurueck
		if (result == JFileChooser.CANCEL_OPTION)
			return null;

		// Wir holen den gewuenschten Dateinamen
		File datei = dateiauswahl.getSelectedFile();

		// und lesen im gleichen Verzeichnis, in dem wir auch stehen.
		return lesen(datei);
	}

	/**
	 * Liest eine Textdatei und gibt deren Inhalt als eine Absatzliste zurueck. 
	 * Der Benutzer kann Ort und Dateinamen ueber den ueblichen Speicherdialog
	 * auswaehlen. Der Speicherdialog kann mit einem Fenster verbunden
	 * werden. Das hat den Vorteil, dass der Dialog gleich sichtbar ist, wenn
	 * man als Benutzer das Fenster ausgewaehlt hat. Formular und 
	 * fortgeschritteneGrafik.Zeichenfenster
	 * sind moegliche Fenster.
	 * 
	 * Der Benutzer kann den Dialog abbrechen. Dann wird null zurueckgegeben.
	 * 
	 */
	public ArrayList<String> absatzlisteLesen(Fenster hintergrundfenster) {
		Component komponente;
		if (hintergrundfenster != null) {
			komponente = hintergrundfenster.verknuepfungGeben();
		}
		else {
			komponente = null;
		}
		// Dialog zur Auswahl einer Datei anzeigen
		int result = dateiauswahl.showOpenDialog(komponente);

		// Waehlt der Benutzer "Abbrechen" verlassen wir diese Methode
		// und geben null zurueck
		if (result == JFileChooser.CANCEL_OPTION)
			return null;

		// Wir holen den gewuenschten Dateinamen
		File datei = dateiauswahl.getSelectedFile();

		// und lesen im gleichen Verzeichnis, in dem wir auch stehen.
		return absatzlisteLesen(datei);
	}

	/**
	 * Liest eine Textdatei ein. Zurueckgegeben wird die Datei als ein Wort.
	 * Die Datei muss in dem Verzeichnis 
	 * des aufrufenden BlueJ Projekts stehen.
	 */
	public static String lesen(String dateiname) {
		return lesen(new File(dateiname));
	}

	/**
	 * Liest eine Textdatei ein. Zurueckgegeben wird die Datei als eine Absatzliste.
	 * Zeilenvorschuebe werden vom internen Dateileser erkannt. Die so entstehenden
	 * einzelnen "Zeilen" (Absaetze) werden in eine Liste eingefuellt und zurueckgegeben.
	 * Die Datei muss in dem Verzeichnis 
	 * des aufrufenden BlueJ Projekts stehen.
	 */
	public static ArrayList<String> absatzlisteLesen(String dateiname) {
		return absatzlisteLesen(new File(dateiname));
	}

	/**
	 * Liest eine Textdatei ein. Zurueckgegeben wird die Datei als eine Absatzliste.
	 * Zeilenvorschuebe werden vom internen Dateileser erkannt. Die so entstehenden
	 * einzelnen "Zeilen" (Absaetze) werden in eine Liste eingefuellt und zurueckgegeben.
	 */
	private static ArrayList<String> absatzlisteLesen(File datei) {	    
	    ArrayList<String> liste = new ArrayList<String>(Arrays.asList(lesen(datei).split(
				zeilenvorschub)));
// 		// Falls eine leere Zeile am Anfang entstanden ist, diese entfernen.		
// 		if (liste.get(0).equals("")) liste.remove(0);		
		return liste; 
	}

	/**
	 * Liest eine Textdatei ein. Zurueckgegeben wird die Datei als ein Wort.
	 * Zeilenvorschuebe werden vom internen Dateileser erkannt und sodann in der
	 * Rueckgabe durch die Konstante Zeilenvorschub repraesentiert.
	 * Wenn die Datei im aktuellen Home (bei geoeffntem BlueJ Projekt ist das der
	 * Wurzel-Ordner desselben) nicht gefunden werden konnte oder nicht
	 * lesbar ist, wird eine Runtime-Exception geworfen.
	 * nach Bruce Eckel net.mindview.util.TextFile.
	 */
	private static String lesen(File datei) {
		if (!datei.isAbsolute())
			datei = datei.getAbsoluteFile();
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(datei));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append(zeilenvorschub);
				}
			}
			finally {
				in.close();
			}
		}
		catch (IOException e) {
		    System.err.println("Die gewaehlte Datei konnte nicht gefunden werden:");
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

// 	/**
// 	 * Moegliche Probleme mit Leerzeichen etc. im Pfad des
// 	 * BlueJ Projekts vermeiden.
// 	 */
// 	private static String pfadFormatieren(String pfad) {
// 		return pfad.replace("%20", " ").replace("%25", "%").replace("%c3%84",
// 				"\u00C4").replace("%c3%96", "\u00D6").replace("%c3%9c",
// 				"\u00DC").replace("%c3%a4", "\u00E4").replace("%c3%b6",
// 				"\u00F6").replace("%c3%bc", "\u00FC").replace("%3d", "=")
// 				.replace("%5b", "[").replace("%5d", "]").replace("%7b", "{")
// 				.replace("%7d", "}").replace("%60", "`").replace("%C3%84",
// 						"\u00C4").replace("%C3%96", "\u00D6").replace("%C3%9C",
// 						"\u00DC").replace("%C3%A4", "\u00E4").replace("%C3%C6",
// 						"\u00F6").replace("%C3%BC", "\u00FC").replace("%3D",
// 						"=").replace("%5B", "[").replace("%5D", "]").replace(
// 						"%7B", "{").replace("%7D", "}");
// 	}
}
