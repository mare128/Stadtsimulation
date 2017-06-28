package eps.werkzeuge;

import javax.swing.*;
import java.util.Scanner;

/**
 * Die Klasse Notiz bietet Dienste an, die Meldungen in einem
 * kleinen Fenster ausgeben und Zeichenketten oder Zahlen oder 
 * Bestaetigung/Ablehnung in diesem Fenster einlesen.
 * Die Meldungen muessen vom Benutzer bestaetigt werden, 
 * erst dann "geht es weiter im Programmablauf".
 * 
 * @author Ute Heuer 
 * @version 
 */
public class Notiz {

	/**
	 * Ueber ein kleines Eingabefenster kann eine 
	 * Zeile Text eingelesen werden. Leerzeichen am Anfang und am Ende werden
	 * abgetrennt.
	 */
	public String lesen() {
		return lesen("");
	}

	/**
	 * Ueber ein kleines Eingabefenster kann eine 
	 * Zeile Text eingelesen werden. Leerzeichen am Anfang und am Ende werden
	 * abgetrennt.
	 * @param aufforderung wird ueber der Eingabezeile des Fensters angezeigt
	 */
	public String lesen(String aufforderung) {
		Scanner scanner = eingabeLesen("Texteingabe", aufforderung);
		if (scanner.hasNextLine()) {
			return scanner.nextLine().trim();
		}
		else {
			return "";
		}
	}

	/**
	 * Erzeugt ein kleines Eingabefenster und
	 * liest eine Ganzzahl ein. Davor duerfen maximal Leerzeichen stehen.
	 * Das Ende der Ganzzahl kann durch ein Leerzeichen angezeigt werden.
	 * Alles nach diesem Leerzeichen wird dann ignoriert. 
	 */
	public int ganzeZahlLesen() {
		return ganzeZahlLesen("");
	}

	/**
	 * Erzeugt ein kleines Eingabefenster und
	 * liest eine Ganzzahl ein. Davor duerfen maximal Leerzeichen stehen.
	 * Das Ende der Ganzzahl kann durch ein Leerzeichen angezeigt werden.
	 * Alles nach diesem Leerzeichen wird dann ignoriert. 
	 * @param aufforderung wird ueber der Eingabezeile des Fensters angezeigt 
	 */
	public int ganzeZahlLesen(String aufforderung) {
		Scanner scanner = eingabeLesen("Eingabe einer ganzen Zahl",
				aufforderung);
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		}
		else {
			return new Notiz()
					.ganzeZahlLesen("Sie haben keine ganze Zahl eingegeben. "
							+ "Bitte versuchen Sie erneut, eine ganze Zahl einzugeben! \n"
							+ aufforderung);
		}
	}

	/**
	 * Erzeugt ein kleines Eingabefenster und
	 * liest eine Zahl ein. Davor duerfen maximal Leerzeichen stehen.
	 * Hat die Zahl Stellen nach dem Komma, so muessen diese auch durch ein
	 * Komma abgetrennt werden (falls Sie in einer "deutschen Umgebung" arbeiten). 
	 * Bsp.: 5 oder 5,789 sind Eingaben, die in diesem Fall
	 * akzeptiert werden.
	 * Das Ende der Zahl kann durch ein Leerzeichen angezeigt werden.
	 * Alles nach diesem Leerzeichen wird dann ignoriert. 
	 */
	public double kommaZahlLesen() {
		return kommaZahlLesen("");
	}

	/**
	 * Erzeugt ein kleines Eingabefenster und
	 * liest eine Zahl ein. Davor duerfen maximal Leerzeichen stehen.
	 * Hat die Zahl Stellen nach dem Komma, so muessen diese auch durch ein
	 * Komma abgetrennt werden (falls Sie in einer "deutschen Umgebung" arbeiten). 
	 * Bsp.: 5 oder 5,789 sind Eingaben, die in diesem Fall
	 * akzeptiert werden.
	 * Das Ende der Zahl kann durch ein Leerzeichen angezeigt werden.
	 * Alles nach diesem Leerzeichen wird dann ignoriert. 
	 * @param aufforderung wird ueber der Eingabezeile des Fensters angezeigt 
	 */
	public double kommaZahlLesen(String aufforderung) {
		Scanner scanner = eingabeLesen("Eingabe einer Zahl", aufforderung);
		if (scanner.hasNextDouble()) {
			return scanner.nextDouble();
		}
		else {
			return new Notiz()
					.kommaZahlLesen("Sie haben keine Zahl eingegeben. Haben Sie evt. ein falsches Trennzeichen verwendet?"
							+ "\nBitte versuchen Sie erneut, eine Zahl einzugeben! \n"
							+ aufforderung);
		}
	}

	/**
	 * Ausgabe einer Zeichenkette auf einem kleinen Ausgabefenster
	 * (MessageBox)
	 * 
	 * @param  objekt das Objekt, dessen Repraesentation als Wort
	 * ausgegeben werden soll. 
	 */
	public void schreiben(Object objekt) {
		JOptionPane pane = new JOptionPane(objekt.toString());
		pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = pane.createDialog(null, "Meldung");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}

	private Scanner eingabeLesen(String art, String aufforderung) {
		JOptionPane pane = new JOptionPane(aufforderung);
		pane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		pane.setWantsInput(true);
		JDialog dialog = pane.createDialog(null, art);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		String input = pane.getInputValue().toString();
		return new Scanner(input);
	}

	/**
	 * Diese Methode liefert true, falls der Ja-Knopf vom Benutzer 
	 * angewaehlt wurde, ansonsten false.
	 */
	public boolean jaNeinAntwortLesen(String jaNeinFrage) {
		Object[] optionen = {"Ja", "Nein"};
		JOptionPane pane = new JOptionPane(jaNeinFrage);
		pane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		pane.setOptions(optionen);
		JDialog dialog = pane.createDialog(null, "Frage");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		Object eingabe = pane.getValue();
		if (eingabe != null) {
			String auswahl = eingabe.toString();
			if (auswahl.equals(optionen[0].toString())) {//Ja
				return true;
			}
		}
		return false;
	}
}
