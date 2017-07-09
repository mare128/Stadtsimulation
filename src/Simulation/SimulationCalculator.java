package Simulation;

import java.awt.Color;
import eps.fortgeschritteneGrafik.Rechteck;
import Data.Parser;
import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.MyButton;
import Zeichenfenster.MyFrame;
import Zeichenfenster.GameScreen;
import Zeichenfenster.KreisPanel;
import Zeichenfenster.OpeningScreen;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.MyButton;
import Zeichenfenster.MyCanvas;

public class SimulationCalculator {

	private String[] map;
	private Rechteck[] buildings;
	private String[] settings;
	private Parser p;
	private SimulationCalculator sc;
	
	public SimulationCalculator(){
		OpeningScreen os = new OpeningScreen(Color.white);
		MyCanvas c = new MyCanvas(os.getPanel());
		KreisPanel k = new KreisPanel(os.getPanel());
		new MouseAndKeyListener(os);
		int x = 0;
		int y = 50;
		for(int i = 0; i < 22; i++){
			for(int z = 0; z < 48; z++){
				Rechteck r = new Rechteck();
				r.positionSetzen(x + (z * 40),y + (i * 40));
				r.farbeSetzen("weiss");
				r.groesseSetzen(40, 40);
				
			}
		}
		int visits = p.getVisits();
		if(visits == 0){
			Help h = new Help(sc);
			h.startTutorial();
		}
		else{
			enterMenu();
		}
	}
	
	public void enterMenu(){
		
	}
	
	public void loadGame(){
		//  vorgefertigte Straßenkarte (größe small, medium doer large) laden mit loadMap oder bereits gespeicherte Karte (d.h. jemad hat schon mal das Spiel gespielt und eine Stadt gespeichert) laden mit loadBuildings(nummer des speicherstands angeben)
		// loadCars (gleicher Speicherstand wie bei Häusern angeben, nur beim Laden von gespeicherten Karten, vorgefertigte Karten haben keine Autos
		
		map = p.loadBuildings(1056);
	}
	
	public void saveGame(){
		// saveBuildings und nummer des Speicherstands angeben(es gibt fünf verschiedene?)
		// mit writeCars alle Autos in das Feld schreiben(Autos bitte durchnummerieren) und mit saveCars mit der gleichen Speicherstand-Nummer speichern
		
	}
	
	public void cancelGame(){
		
		
	}
	
	public String[] getMap(){ 
		return map;
	}
	
	public void startSimulation(){
		
	}
}
