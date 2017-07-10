package Simulation;

import java.awt.Color;
import Data.Parser;
import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.GameScreen;
import Zeichenfenster.OpeningScreen;
import Zeichenfenster.MyCanvas;

public class SimulationCalculator {

	private String[] map;
	private MyCanvas[] buildings;
	private String[] settings;
	private Parser p;
	private SimulationCalculator sc;
	private GameScreen gs;
	private Customize customize;
	private Car[] cars;
	
	public SimulationCalculator(){
		OpeningScreen os = new OpeningScreen(Color.white, sc);
		new MouseAndKeyListener(os);
		int x = 0;
		int y = 50;
		for(int i = 0; i < 22; i++){
			for(int z = 0; z < 48; z++){
				buildings[z + (i * 48)] = new MyCanvas(gs.getPanel(),x + (z * 40),y + (i * 40),40, 40, Color.WHITE);
			}
		}
		new MouseAndKeyListener(gs);
		int visits = p.getVisits();
		if(visits == 0){
			Help h = new Help(sc,customize);
			h.startTutorial();
		}
	}
	
	public void loadGame(){
		//  vorgefertigte Straßenkarte (größe small, medium doer large) laden mit loadMap oder bereits gespeicherte Karte (d.h. jemad hat schon mal das Spiel gespielt und eine Stadt gespeichert) laden mit loadBuildings(nummer des speicherstands angeben)
		// loadCars (gleicher Speicherstand wie bei Häusern angeben, nur beim Laden von gespeicherten Karten, vorgefertigte Karten haben keine Autos
		
		map = p.loadBuildings(1);
	}
	
	public void saveGame(){
		//hier sollte der Speicherstand ausgewählt werden
		p.saveBuildings(1);
		// mit writeCars alle Autos in das Feld schreiben(Autos bitte durchnummerieren) und mit saveCars mit der gleichen Speicherstand-Nummer speichern
		for(int i = 0; i <= cars.length; i++ ){
			
		}
		
	}
	
	public void cancelGame(){
		
		
	}
	
	public String[] getMap(){ 
		map = p.loadMap("medium");
		return map;
	}
	
	public void startSimulation(){
		
	}
	
	public void pushGameScreen(GameScreen gs){
		this.gs = gs;
	}
	
	public void changeFunction(int ID, String Function){
		map[ID] = "Function";
	}
}
