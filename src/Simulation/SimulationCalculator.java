package Simulation;

import java.awt.Color;

import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.MyButton;
import Zeichenfenster.MyFrame;
import Zeichenfenster.Rechteck;

public class SimulationCalculator {

	int[] map;
	Rechteck[] buildings;
	String[] settings;
	private SimulationCalculator SimulationCalculator;
	
	public SimulationCalculator(){
		MyFrame j = new MyFrame();
		new MouseAndKeyListener(j);
		
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
