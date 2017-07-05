package Simulation;

import java.awt.Color;
import Data.Parser;

import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.MyButton;
import Zeichenfenster.MyFrame;
import Zeichenfenster.Rechteck;

public class SimulationCalculator {

	int[] map;
	Rechteck[] buildings;
	String[] settings;
	private Parser p;
	
	public SimulationCalculator(){
		int visits = p.getVisits();
		if(visits == 0){
			Help h = new Help();
			h.startTutorial();
		}
	}
	
	public void enterMenu(){
		
	}
	
	public void loadGame(){
		
	}
	
	public void saveGame(){
		
		
	}
	
	public void cancelGame(){
		
		
	}
	
	public int[] getMap(){ 
		return map;
	}
}
