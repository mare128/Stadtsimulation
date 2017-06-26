package eps.werkzeuge;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Spielt Tondateien ab, die im Ordner "tonDateien" relativ
 * zum Ort der Datei TonSpieler.class liegen.
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public class TonSpieler {
    private static final String ordnerpfad = "tonDateien/";

    /**
     * Spielt die angegebene Tondatei ab.
     */
    public static void tonDateiAbspielen(String dateiName) {
        final String d = dateiName;
        new Thread() {
            public void run() {
                URL u = TonSpieler.class.getResource(ordnerpfad + d);
                if (u == null || u.getPath() == null)
                    return;
                AudioClip sound = null;
                sound = Applet.newAudioClip(u);
                sound.play();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }
}
