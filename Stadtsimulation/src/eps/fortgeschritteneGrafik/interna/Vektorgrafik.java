package eps.fortgeschritteneGrafik.interna;

import java.awt.Color;

/**
 * Abstrakte Klasse Vektorgrafik 
 * 
 * @author Ute Heuer
 * @version 0.1
 */
public abstract class Vektorgrafik extends Grafik {
	/**
	 * Das Attribut farbe speichert die aktuelle Farbe der Vektorgrafik.
	 */
	private String farbe;

	public Vektorgrafik(boolean anmelden, Zeichenfenster fenster) {
		super(anmelden, fenster);
		farbe = "schwarz";
	}

	/**
	 * Die Farbe der Grafik kann gewaehlt werden. Moegliche Farben sind:
	 * "weiss", "gelb", "orange", "rot", "pink", "magenta", "cyan", "gruen",
	 * "blau", "grau", "schwarz" Achtung: Die Anfuehrungsstriche sind noetig!
	 * Alle anderen Eingabewerte werden ignoriert.
	 */
	public void farbeSetzen(String neueFarbe) {
		if (farbeUebersetzen(neueFarbe) != null) {
			farbe = neueFarbe;
		}
	}

	/**
	 * Liest unsere Farbe aus. Moegliche Werte sind: "weiss", "gelb", "orange",
	 * "rot", "pink", "magenta", "cyan", "gruen", "blau", "grau", "schwarz"
	 */
	public String farbeGeben() {
		return farbe;
	}

	/**
	 * Gibt unsere Farbe als Colorobjekt zurueck, falls gueltig, d.h. in der Liste der
	 * moeglichen Werte enthalten, ansonsten wird null zurueckgegeben.
	 * Moegliche Werte sind: "weiss", "gelb", "orange",
	 * "rot", "pink", "magenta", "cyan", "gruen", "blau", "grau", "schwarz"
	 */
	private Color farbeUebersetzen(String farbe) {
		if (farbe.equals("rot")) {
			return Color.RED;
		}
		else
			if (farbe.equals("blau")) {
				return Color.BLUE;
			}
			else
				if (farbe.equals("gelb")) {
					return Color.YELLOW;
				}
				else
					if (farbe.equals("gruen")) {
						return Color.GREEN;
					}
					else
						if (farbe.equals("grau")) {
							return Color.GRAY;
						}
						else
							if (farbe.equals("schwarz")) {
								return Color.BLACK;
							}
							else
								if (farbe.equals("weiss")) {
									return Color.WHITE;
								}
								else
									if (farbe.equals("pink")) {
										return Color.PINK;
									}
									else
										if (farbe.equals("orange")) {
											return Color.ORANGE;
										}
										else
											if (farbe.equals("magenta")) {
												return Color.MAGENTA;
											}
											else
												if (farbe.equals("cyan")) {
													return Color.CYAN;
												}
		return null;
	}

	/**
	 * Wird von Unterklassen aufgerufen, wenn diese 
	 * vom Zeichenfenster aufgefordert werden, eine
	 * aktuelle "Zeichnung" ihrer selbst abzugeben.
	 * Bei (momentan) ungueltiger Farbe wird die Farbe schwarz
	 * zurueckgegeben, so kann damit notfalls auch gezeichnet werden.
	 */
	protected Color farbeAufloesen() {
		Color color = farbeUebersetzen(farbe);
		if (color == null) {
			return Color.BLACK;
		} else {
			return color;
		}
	}

	/**
	 * Unsere einfache "Visitenkarte": unser Klassenname gefolgt von
	 * interessanten Attributwerten
	 */
	public String toString() {
		return super.toString() + " - Farbe: " + farbe;
	}
}
