package Simulation;

import java.awt.Color;
import Data.Parser;

import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.MyButton;
import Zeichenfenster.MyFrame;
import Zeichenfenster.Rechteck;

public class SimulationCalculator {

	private String[] map;
	private Rechteck[] buildings;
	private String[] settings;
	private Parser p;
	private SimulationCalculator sc;
	
	public SimulationCalculator(){
		MyFrame j = new MyFrame(Color.white);		
		new MouseAndKeyListener(j);
		int x = 0;
		int y = 50;
		for(int i = 0; i < 22; i++){
			for(int z = 0; z < 48; z++){
				new Rechteck(j.getPanel(), x + (z * 40), y + (i * 40), 40, 40, Color.white);
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
		//SIlvano
		//Muss sich dann auch mit Knopfdruck wieder schließen
	}
	
	public void loadGame(){
		//wie funktioniert dass genau mit dem laden von den Gebäuden
		map = p.loadBuildings(1056);
	}
	
	public void saveGame(){
		
		
	}
	
	public void cancelGame(){
		
		
	}
	
	public String[] getMap(){ 
		return map;
	}
}
