package Starter;

import java.awt.Color;

import Simulation.SimulationCalculator;
import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.MyCanvas;
import Zeichenfenster.OpeningScreen;

public class Starter {
	
	private SimulationCalculator sc;
	
	public static void main(String[] args) {
		SimulationCalculator sc = new SimulationCalculator();
		sc.startSimulation();
	}

}
