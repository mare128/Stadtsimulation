package Zeichenfenster;

import java.awt.Color;

import Simulation.SimulationCalculator;

public class OpeningScreen extends MyFrame{
	
	private SimulationCalculator sc;
	private MyButton b1;
	private MyButton b2;

	public OpeningScreen(Color color, SimulationCalculator sc){
		super(color);
		this.sc = sc;
		b1 = new MyButton(p, 810, 480, 300, 50, "Spiel starten",sc);
		b2 = new MyButton(p, 810, 550, 300, 50, "Beenden",sc);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	public void newGameScreen(){
		if(b1.newGameScreen() == true){
			GameScreen gs = new GameScreen(Color.white);
		}
	}
}
