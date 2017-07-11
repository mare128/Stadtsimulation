package Zeichenfenster;

import java.awt.Color;

import Simulation.SimulationCalculator;

public class OpeningScreen extends MyFrame{
	
	private SimulationCalculator sc;

	public OpeningScreen(Color color, SimulationCalculator sc){
		super(color);
		this.sc = sc;
		MyButton b1 = new MyButton(p, 810, 480, 300, 50, "Spiel starten",sc);
		MyButton b2 = new MyButton(p, 810, 550, 300, 50, "Beenden",sc);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
}
