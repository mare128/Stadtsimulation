package eps.fortgeschritteneGrafik.interna;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.net.URL;

import eps.fortgeschritteneGrafik.Bild;


/**
 * Diese Klasse dient als Zwischenspeicher fuer die dargestellten Bilder. So
 * muessen Bilder nicht mehrfach geladen werden.
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public class BildSpeicher {
    /**
     * Der Bildspeicher
     */
    private Image[] bilder;

    /**
     * Der ReferenzSpeicher
     */
    private String[] bildernamen;

    /**
     * Der Pfad zum Bilder-Ordner relativ zur Bild.class
     */
    public static final String ordnerpfad = "Bilder/";

    /**
     * Referenz auf den einzigen BildSpeicher nach der Singleton-Idee
     */
    private static BildSpeicher speicher;

    /**
     * Erzeugt einen neuen Bildspeicher
     */
    private BildSpeicher() {
        bilder = new Image[0];
        bildernamen = new String[0];
    }

    /**
     * Laed ein Bild (wenn moeglich aus dem Speicher)
     */
    public Image ladeBild(String bilddatei) {
        Image bild = sucheBildImSpeicher(bilddatei);
        if (bild != null)
            return bild;
        if (!istDateiVorhanden(bilddatei)) {
            System.err
                    .println("Die gewuenschte Datei "
                            + bilddatei
                            + " steht nicht zur Verfuegung. \n"
                            + "Nutzen Sie den Dienst bilderGeben eines Bildobjekts, um herauszufinden, \n"
                            + "welche Bilddateien zur Zeit in Ihrem Projekt gewaehlt werden koennen.");
            return null;
        }
        if (!istDateiDarstellbar(bilddatei)) {
            System.err
                    .println("Es koennen die Bildformate gif, jpg und png dargestellt werden.\n"
                            + "Die Datei\n    "
                            + bilddatei
                            + "\nhat wahrscheinlich ein nicht darstellbares Format.");
            return null;
        }
        bild = new ImageIcon(Bild.class.getResource(ordnerpfad + bilddatei))
                .getImage();
        bildSpeichern(bild, bilddatei);
        return bild;
    }

    /**
     * Liefert eine Referenz auf den Speicher
     */
    public static BildSpeicher speicherGeben() {
        if (speicher == null)
            speicher = new BildSpeicher();
        return speicher;
    }

    public static boolean istDateiDarstellbar(String name) {
        URL url = Bild.class.getResource(ordnerpfad + name);
        if (url == null) return false;
        Icon bild = new ImageIcon(url);
        return (bild != null && bild.getIconWidth() >= 0);
    }

    private boolean istDateiVorhanden(String bilddatei) {
        return Bild.class.getResource(ordnerpfad + bilddatei) != null;
    }

    private void bildSpeichern(Image bild, String bildname) {
        Image[] neueBilder = new Image[bilder.length + 1];
        String[] neueBildernamen = new String[bilder.length + 1];
        for (int i = 0; i < bilder.length; i++) {
            neueBilder[i] = bilder[i];
            neueBildernamen[i] = bildernamen[i];
        }
        neueBilder[bilder.length] = bild;
        neueBildernamen[bilder.length] = bildname;
        bilder = neueBilder;
        bildernamen = neueBildernamen;
    }

    private Image sucheBildImSpeicher(String bilddatei) {
        for (int i = 0; i < bildernamen.length; i++) {
            if (bildernamen[i].equals(bilddatei))
                return bilder[i];
        }
        return null;
    }
}
