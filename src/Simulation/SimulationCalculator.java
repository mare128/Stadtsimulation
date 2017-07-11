package Simulation;

import java.awt.Color;
import Data.Parser;
import Data.WrapperclassCars;
import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.GameScreen;
import Zeichenfenster.OpeningScreen;
import Zeichenfenster.MyCanvas;

public class SimulationCalculator {

	private String[] map;
	private MyCanvas[] buildings;
	private Parser p;
	private SimulationCalculator sc;
	private GameScreen gs;
	private Customize customize;
	private Car[] car;
	private WrapperclassCars cars;
	
	public SimulationCalculator(){
		OpeningScreen os = new OpeningScreen(Color.white, sc);
		os.newGameScreen();
		new MouseAndKeyListener(os);
		int x = 0;
		int y = 90;
		for(int i = 0; i < 22; i++){
			for(int z = 0; z < 48; z++){
				buildings[z + (i * 48)] = new MyCanvas(gs.getPanel(),x + (z * 40),y + (i * 40),40, 40, Color.GREEN);
			}
		}
		new MouseAndKeyListener(gs);
		gs.paint();
		int visits = p.getVisits();
		if(visits == 0){
			Help h = new Help(sc,customize);
			h.startTutorial();
		}
	}
	
	public void loadGame(){
		//hier sollte der Speicherstand gewählt werden
		map = p.loadBuildings(1);
		cars = p.loadCars(1);
		int[] x = cars.getXPosition();
		int[] y = cars.getYPosition();
		int[] dest = cars.getDestination();
		int[] dir = cars.getDirection();
		for(int i = 0; i < 1000; i++){
			car[i] = new Car(sc,gs.getPanel(), x[i],y[i],i,dest[i],dir[i]);
		}
	}
	
	public void saveGame(){
		//hier sollte der Speicherstand ausgewählt werden
		p.saveBuildings(1);
		for(int i = 0; i < car.length; i++ ){
			p.writeCars(i, car[i].getDirection(),car[i].getDestination(), car[i].getxPosition(), car[i].getyPosition());
		}
		p.saveCars(1);
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