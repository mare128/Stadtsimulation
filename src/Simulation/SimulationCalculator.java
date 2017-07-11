package Simulation;

import java.awt.Color;
import java.util.Random;

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
	private int amountOfBuildings;
	
	public SimulationCalculator(){
		OpeningScreen os = new OpeningScreen(Color.white, sc);
		new MouseAndKeyListener(os);
		buildings = new MyCanvas[1056];
		int x = 0;
		int y = 90;
		for(int i = 0; i < 22; i++){
			for(int z = 0; z < 48; z++){
				buildings[z + (i * 48)] = new MyCanvas(gs.getPanel(),x + (z * 40),y + (i * 40),40, 40, Color.WHITE);
			}
		}
		new MouseAndKeyListener(gs);
		gs.paint();
		/*
		Hier sollte beim ersten Start, dass Tutorial aufgerufen werden. Hier ausgeklammert.
		int visits = p.getVisits();
		if(visits == 0){
			Help h = new Help(sc,customize);
			h.startTutorial();
		}
		*/
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
	
	public String[] getMap(){ 
		map = p.loadMap("medium");
		//Setzen der Anzahl der Gebäude fällt weg
		amountOfBuildings = 901;
		return map;
	}
	
	public void startSimulation(){
		simulateCars();
		//Simulation der Events entfällt
	}
	
	private void simulateCars(){
		boolean done = false;
		boolean driving = false;
		for(int i = 0; i < car.length; i++){
			driving = car[i].getDriving();
			if(driving == false){
				Random rd = new Random();
				int j = rd.nextInt(100);
				if(j == 0){
					while(done = false){
						int dest = rd.nextInt(amountOfBuildings + 1);
						dest = convertBuildingID(dest);
						if(map[dest].equals("street")){
						} else {
						car[i].drive();
						done = true;
						}
					}
				}
			}
		}
	}
	
	private int convertBuildingID(int dest){
		switch(amountOfBuildings){
		case 1055 : break;
		case 901: dest = (dest % 38) + (48* (dest / 38)); 
		case 747: dest = (dest % 28) + (48* (dest / 28)); 
		}
		return dest;
	}
	
	public void pushGameScreen(GameScreen gs){
		this.gs = gs;
	}
	
	public void changeFunction(int ID, String Function){
		map[ID] = "Function";
	}
}
