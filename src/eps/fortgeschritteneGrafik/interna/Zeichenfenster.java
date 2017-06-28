package eps.fortgeschritteneGrafik.interna;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.Toolkit;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import eps.fortgeschritteneGrafik.Bild;
import eps.fortgeschritteneGrafik.Tastatursensor;
import eps.werkzeuge.Pause;
import eps.werkzeuge.Notiz;
import eps.werkzeuge.Fenster;


/**
 * Das Zeichenfenster der Grafiken
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public class Zeichenfenster
        extends Canvas implements Fenster {
    private static final long serialVersionUID = 1L;

    /**
     * Die Liste der Grafiken auf dem Zeichenfenster
     */
    private Grafik[] grafiken;

    /**
     * Technisches Objekt zum Zeichnen des Fensters
     */
    private BufferStrategy strategie;

    /**
     * Zeiger auf ein Zeichenfenster nach der Singleton-Idee
     */
    private static Zeichenfenster zeichenfenster;

    /**
     * Das "oberste Fenster"
     */
    private JFrame frame;

    /**
     * Technisches Objekt zum Zeichnen des Fensters
     */
    private JPanel leinwandPanel;

    /**
     * Technisches Objekt zum Zeichnen des Fensters
     */
    private JPanel buttonPanel;

    /**
     * Die Hoehe des Gitternetz-Buttons
     */
    private int buttonHoehe;

    /**
     * Ist wahr, wenn das Gitternetz angezeigt wird
     */
    private boolean gitternetz;

    /**
     * Der Button zum Anzeigen des Gitternetzes
     */
    private JButton gitternetzButton;

    /**
     * Ist wahr, wenn in guter Qualitaet gezeichnet wird
     */
    private boolean inGuterQualitaetZeichnen;

    /**
     * Die Konstante STANDARD_FENSTER_BREITE stellt eine Fensterbreite in
     * Bildpunkten bereit, wenn vom Nutzer keine andere angegeben wird.
     */
    private static final int STANDARD_FENSTER_BREITE = 810;

    /**
     * Die Konstante STANDARD_FENSTER_HOEHE stellt eine Fensterhoehe in
     * Bildpunkten bereit, wenn vom Nutzer keine andere angegeben wird.
     */
    private static final int STANDARD_FENSTER_HOEHE = 600;

    /**
     * Die Konsante FENSTER_NAME haelt den Titel des mit oeffentlichem
     * Konstruktor erzeugten Fensters.
     */
    private static final String FENSTER_NAME = "Zeichenfenster";

    /**
     * Die Konsante SINGLETON_FENSTER_NAME haelt den Titel des 
     * bei Bedarf automatisch erzeugten Fensters. Von diesem gibt 
     * es maximal eines nach der Singleton-Idee.
     */
    private static final String SINGLETON_FENSTER_NAME = "Standard-Zeichenfenster";    
    /**
     * Die Konstante HINTERGRUND_FARBE haelt die Hintergrundfarbe des
     * Zeichenfensters.
     */
    private static final Color HINTERGRUND_FARBE = Color.WHITE;

    /**
     * Hier wird gehalten, wieviele Fenster bisher erzeugt wurden.
     * Es wird nicht nach Standardfenster (Singleton) und Fenster
     * unterschieden sondern einfach durchgezaehlt.
     */
    private static int fensteranzahl = 0;
    
    /**
     * Mehrere Fenster werden kaskadierend angeordnet, deltaX = deltaY = offset
     */
    private static int offset = 0;
    /**
     * Fuer das automatische Zeichnen noetig
     */
    private Synchronisierer synchronisation;

    /**
     * Fuer das automatische Zeichnen noetig
     */
    private boolean zeichenautomatAn = false;

    
    /**
     * Erzeugt ein Zeichenfenster in der angegebenen Groesse
     */
    public Zeichenfenster(int breite, int hoehe) {
        this(breite, hoehe, false);
    }
    
    private Zeichenfenster(int breite, int hoehe, boolean singleton) {
        if (breite < 0 || hoehe < 0
                || breite > Toolkit.getDefaultToolkit().getScreenSize().width
                || hoehe > Toolkit.getDefaultToolkit().getScreenSize().height) {
            breite = STANDARD_FENSTER_BREITE;
            hoehe = STANDARD_FENSTER_HOEHE;
        }
        gitternetz = false;
        inGuterQualitaetZeichnen = true;
        grafiken = new Grafik[0];
        fensteranzahl++;
        initiieren(breite, hoehe, singleton);
    }

    /**
     * Die Konstruktor-Ersatzmethode zeichenfensterGeben erzeugt ein neues
     * Standardzeichenfenster mit Standardbreite und -hoehe falls noch kein
     * Standardzeichenfenster existiert. Sonst wird das bestehende 
     * Standardzeichenfenster zurueckgegeben.
     * Anmerkung: Von Nutzern via Konstruktor erzeugte Zeichenfenster
     * sind keine Standardzeichenfenster.
     */
    public static Zeichenfenster zeichenfensterGeben() {
        if (zeichenfenster == null) {
            Dimension d = standardDimensionenAuslesen();
            zeichenfenster = new Zeichenfenster((int) d.getWidth(), (int) d
                    .getHeight(), true); // true heisst: Standard-Zeichenfenster erzeugen
        }
        return zeichenfenster;
    }
    
    public Component verknuepfungGeben() {
        return this;
    }

    /**
     * Meldet einen neuen Tastatursensor an
     */
    public void sensorAnmelden(Tastatursensor ts) {
        addKeyListener(new TastenHorcher(ts));
        frame.addKeyListener(new TastenHorcher(ts));
    }

    /**
     * Liefert die Breite des Fenster
     */
    public int breiteGeben() {
        return getWidth();
    }

    /**
     * Liefert die Hoehe des Fensters
     */
    public int hoeheGeben() {
        return getHeight();
    }

    /**
     * Zeichnet das Fenster neu
     */
    public void zeichnen() {
        neuZeichnen();
    }

    /**
     * Das Zeichenfenster kann zugunsten der Zeichengeschwindigkeit in guter und
     * in schlechter Qualitaet gezeichnet werden. Bei schlechter Qaulitaet wird
     * unter Anderem das Anti-Aliasing ausgeschaltet. 
     * Standardeinstellung: gute Qualitaet
     */
    public void zeichenqualitaetWechseln() {
        inGuterQualitaetZeichnen = !inGuterQualitaetZeichnen;
    }

    /**
     * Schaltet das Gitternetz ein
     */
    public void gitterAnzeigen() {
        gitternetz = true;
        neuZeichnen();
    }

    /**
     * Schaltet das Gitternetz aus
     */
    public void gitterVerstecken() {
        gitternetz = false;
        neuZeichnen();
    }

    /**
     * Schaltet das automatische Neuzeichnen des Zeichenfensters
     * an. So wird das Zeichenfenster mindestens all 200ms
     * neugezeichnet.
     */
    public void zeichenautomatStarten() {
        if (zeichenautomatAn)
            return;
        if (synchronisation == null) {
            synchronisation = new Synchronisierer();
            new Thread() {
                public void run() {
                    while (true) {
                        if (!zeichenautomatAn) {
                            synchronisation.stoppen();
                        }
                        zeichnen();
                        Pause.msWarten(200);
                    }
                }
            }.start();
        }
        zeichenautomatAn = true;
        synchronisation.starten();
    }
    
    /**
     * Schaltet das automatische Neuzeichnen des Zeichenfensters
     * ab, sofern es angeschaltet ist.
     */
    public void zeichenautomatStoppen() {
        zeichenautomatAn = false;
    }

    /**
     * Fuegt eine neue Grafik dem Fenster hinzu
     */
    synchronized void grafikHinzufuegen(Grafik g) {
        if (g == null)
            return;
        Grafik[] tempArray = new Grafik[grafiken.length + 1];
        for (int i = 0; i < grafiken.length; i++) {
            if (grafiken[i].equals(g))
                return;
            tempArray[i] = grafiken[i];
        }
        tempArray[grafiken.length] = g;
        grafiken = tempArray;
    }

    /**
     * Entfernt eine Grafik vom Fenster
     */
    synchronized void grafikEntfernen(Grafik g) {
        if (g == null || grafiken.length == 0)
            return;
        Grafik[] tempArray = new Grafik[grafiken.length - 1];
        int j = 0;
        for (int i = 0; i < grafiken.length; i++) {
            if (!grafiken[i].equals(g)) {
                if (i == grafiken.length - 1 && j == i)
                    return;
                tempArray[j] = grafiken[i];
                j++;
            }
        }
        grafiken = tempArray;
    }

    private void initiieren(int breite, int hoehe, boolean singleton) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        if (singleton) {
            // Fensternummer nicht mit in die Ueberschrift schreiben
            frame = new JFrame(SINGLETON_FENSTER_NAME);
        } else {
            frame = new JFrame(FENSTER_NAME + " (" + fensteranzahl + ")");
        }
        frame.setIconImage(new ImageIcon(Bild.class
                .getResource(BildSpeicher.ordnerpfad + "logo.gif")).getImage());
        frame.setPreferredSize(new Dimension(breite, hoehe));
        frame.setBounds(offset, offset, breite, hoehe);//UH - 0,0
        offset = offset + 10;
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //UH
        ImageIcon gitterIcon = new ImageIcon(Bild.class
                .getResource(BildSpeicher.ordnerpfad + "skala.gif"));
        gitternetzButton = new JButton(gitterIcon);
        gitternetzButton.addActionListener(new GitterHorcher());
        buttonHoehe = gitterIcon.getIconHeight() + 55;
        leinwandPanel = new JPanel();
        leinwandPanel.setPreferredSize(new Dimension(breite, hoehe
                - buttonHoehe));
        leinwandPanel.setLayout(null);
        leinwandPanel.setBounds(0, 0, breite, hoehe - buttonHoehe);
        leinwandPanel.setBackground(HINTERGRUND_FARBE);
        leinwandPanel.add(this);
        frame.add(leinwandPanel);
        buttonPanel = new JPanel();
        buttonPanel.setBackground(HINTERGRUND_FARBE);
        buttonPanel.setBounds(0, hoehe - buttonHoehe, breite, buttonHoehe);
        buttonPanel.setLayout(null);
        gitternetzButton.setBounds(breite / 2 - gitterIcon.getIconWidth() / 2,
                0, gitterIcon.getIconWidth() + 10,
                gitterIcon.getIconHeight() + 10);
        buttonPanel.add(gitternetzButton);
        frame.add(buttonPanel);
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setBackground(HINTERGRUND_FARBE);
        setIgnoreRepaint(true);
        setBounds(0, 0, leinwandPanel.getWidth(), leinwandPanel.getHeight());
        createBufferStrategy(2);
        strategie = getBufferStrategy();
        frame.addWindowListener(new SchliessHorcher());
        addMouseListener(new MausHorcher());
        frame.addMouseListener(new MausHorcher());
        frame.addComponentListener(new KomponentenHorcher());
        setBackground(HINTERGRUND_FARBE);
        frame.requestFocus();
        new OnTopThread().start();
    }

    private synchronized void neuZeichnen() {
        Graphics2D g = (Graphics2D) strategie.getDrawGraphics();
        if (inGuterQualitaetZeichnen) {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                    RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                    RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_DITHERING,
                    RenderingHints.VALUE_DITHER_ENABLE);
            g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                    RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                    RenderingHints.VALUE_STROKE_DEFAULT);
        } else {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_OFF);
            g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                    RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                    RenderingHints.VALUE_COLOR_RENDER_DEFAULT);
            g.setRenderingHint(RenderingHints.KEY_DITHERING,
                    RenderingHints.VALUE_DITHER_DISABLE);
            g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                    RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_SPEED);
            g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                    RenderingHints.VALUE_STROKE_DEFAULT);
        }
        g.setColor(HINTERGRUND_FARBE);
        g.clearRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < grafiken.length; i++) {
            grafiken[i].zeichnenAuf(g);
        }
        if (gitternetz) {
            koordinatensystemMalen(g);
        }
        strategie.show();
        g.dispose();
    }

    private static Dimension standardDimensionenAuslesen() {
        URL u = Bild.class
                .getResource("sonstigeRessourcen/standardFenstergroesse.txt");
        if (u == null || u.getPath() == null)
            return new Dimension(STANDARD_FENSTER_BREITE,
                    STANDARD_FENSTER_HOEHE);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(u.openStream()));
            String zeile = reader.readLine();
            while (reader.ready()
                    && (zeile.length() < 3 || !zeile.contains(","))) {
                zeile = reader.readLine();
            }
            reader.close();
            int breite = Integer.parseInt(zeile.trim().split(",")[0].trim());
            int hoehe = Integer.parseInt(zeile.trim().split(",")[1].trim());
            return new Dimension(breite, hoehe);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return new Dimension(STANDARD_FENSTER_BREITE, STANDARD_FENSTER_HOEHE);
    }

    /**
     * Die Methode koordinatensystemMalen zeichnet auf wunsche ein
     * Koordinatensystem mit Hilfslinien auf das Zeichenfenster.
     */
    private void koordinatensystemMalen(Graphics2D zeichenInstanz) {
        int fensterhoehe = getHeight();
        int fensterbreite = getWidth();
        zeichenInstanz.setColor(Color.BLACK);
        Font schriftart = new Font("SansSerif", Font.PLAIN, 10);
        zeichenInstanz.setFont(schriftart);
        /* Koordinatenachsen zeichnen */
        zeichenInstanz.drawLine(5, 0, 5, fensterhoehe);
        zeichenInstanz.drawLine(0, 5, fensterbreite, 5);

        /* Skala und Striche der y-Achse */
        for (int i = 50; i < fensterhoehe; i += 50) {
            zeichenInstanz.setColor(Color.LIGHT_GRAY);
            zeichenInstanz.drawLine(0, i, fensterbreite, i);
            zeichenInstanz.setColor(Color.BLACK);
            zeichenInstanz.drawLine(0, i, 11, i);
            zeichenInstanz.drawString(i + "", 15, (i + 5));
        }
        /* Skala und Striche der x-Achse */
        for (int i = 50; i < fensterbreite; i += 50) {
            zeichenInstanz.setColor(Color.LIGHT_GRAY);
            zeichenInstanz.drawLine(i, 0, i, fensterhoehe);
            zeichenInstanz.setColor(Color.BLACK);
            zeichenInstanz.drawLine(i, 0, i, 11);
            zeichenInstanz.drawString(i + "", (i - 13), 20);
        }
    }

    private class SchliessHorcher
            extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            Notiz meldung = new Notiz();//UH
            if (meldung.jaNeinAntwortLesen("Wenn Sie schliessen werden ALLE erzeugten " + 
                "Objekte entfernt.\n Beabsichtigen Sie dies?")) {
                System.exit(0);
            } 
        }
    }

    private class GitterHorcher implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            gitternetz = !gitternetz;
            new Thread() {
                public void run() {
                    neuZeichnen();
                }
            }.start();
        }
    }

    private class KomponentenHorcher implements ComponentListener {
        public void componentHidden(ComponentEvent arg0) {
        }

        public void componentMoved(ComponentEvent arg0) {
            neuZeichnen();
        }

        public void componentResized(ComponentEvent arg0) {
            leinwandPanel.setBounds(0, 0, ((JFrame) arg0.getSource())
                    .getWidth(), ((JFrame) arg0.getSource()).getHeight()
                    - buttonHoehe);
            setBounds(0, 0, leinwandPanel.getWidth(), leinwandPanel.getHeight());
            buttonPanel.setBounds(0, ((JFrame) arg0.getSource()).getHeight()
                    - buttonHoehe, ((JFrame) arg0.getSource()).getWidth(),
                    buttonHoehe);
            gitternetzButton.setBounds(buttonPanel.getWidth() / 2
                    - gitternetzButton.getWidth() / 2, 0, gitternetzButton
                    .getWidth(), gitternetzButton.getHeight());
            buttonPanel.repaint();
            neuZeichnen();
        }

        public void componentShown(ComponentEvent arg0) {
            neuZeichnen();
        }
    }

    private class MausHorcher implements MouseListener {

        public void mouseClicked(MouseEvent arg0) {
            neuZeichnen();
        }

        public void mouseEntered(MouseEvent arg0) {
            neuZeichnen();
        }

        public void mouseExited(MouseEvent arg0) {
            neuZeichnen();
        }

        public void mousePressed(MouseEvent arg0) {
        }

        public void mouseReleased(MouseEvent arg0) {
        }
    }

    private class TastenHorcher implements KeyListener {
        private Tastatursensor sensor;

        public TastenHorcher(Tastatursensor neuerSensor) {
            sensor = neuerSensor;
        }

        public void keyPressed(KeyEvent arg0) {
            sensor.beiDruckAusloesen(arg0.getKeyCode());
        }

        public void keyReleased(KeyEvent arg0) {
            sensor.beiFreigabeAusloesen(arg0.getKeyCode());
        }

        public void keyTyped(KeyEvent arg0) {
            sensor.beiAnschlagAusloesen(arg0.getKeyCode());
        }
    }

    private class OnTopThread
            extends Thread {
        public void run() {
            frame.setAlwaysOnTop(true);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            frame.setAlwaysOnTop(false);
        }
    }
    
    private class Synchronisierer {
        private boolean istGestartet = false;

        public synchronized void stoppen() {
            istGestartet = false;
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        public synchronized void starten() {
            istGestartet = true;
            notifyAll();
        }
        
        public synchronized boolean istGestartet() {
            return istGestartet;
        }
    }
}
